package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf =Persistence.createEntityManagerFactory("oracleJpaUnit");
        //persistence.xml`에 정의된 영속성 유닛 이름을 넘긴다.
        //`EntityManagerFactory`는 데이터베이스와 연결된 `EntityManager`를 생성하는 공장(factory) 역할을 하며,
        // 애플리케이션 전체에서 한 번만 생성해 재사용하는 것이 권장됩니다
        EntityManager em = emf.createEntityManager();
        //엔티티 객체의 저장, 조회, 수정, 삭제 등 데이터베이스 작업을 수행하며, 영속성 컨텍스트를 관리합니다
        EntityTransaction et = em.getTransaction();
        //트랜잭션을 관리하는 `EntityTransaction` 객체를 얻습니다.
        //JPA에서 데이터 변경 작업은 반드시 트랜잭션 내에서 수행해야 하므로, 트랜잭션 객체를 통해 시작, 커밋, 롤백 등을 제어합니다
        et.begin();
        //트랜잭션을 시작합니다.
        //이 시점부터 데이터 변경 작업이 하나의 논리적 단위로 묶이며, 작업 성공 시 `commit()`, 실패 시 `rollback()`을 호출하여 DB 상태를 일관성 있게 유지합니다
        try{
            List<Member2> resultList = em.createQuery("select m from Member2 m", Member2.class)//m 객체 자체를 SELECT하게 된다.
                    .setFirstResult(5)//최초값
                    .setMaxResults(10)//마지막값
                    .getResultList();
            for (Member2 member2 : resultList) {
                System.out.println(member2.getName());
            }
            et.commit();
            //트랜잭션을 커밋하여 영속성 컨텍스트에 저장된 변경 사항을 데이터베이스에 반영합니다.
        }catch (Exception e)
        {
            et.rollback();
        }finally {
            em.close();
            //사용하지 않는 자원을 반납한다.
        }
        emf.close();
        //사용하지 않는 자원을 반납한다.
    }
}

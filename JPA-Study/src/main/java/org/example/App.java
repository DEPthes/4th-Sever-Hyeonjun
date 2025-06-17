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
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try{
            Member2 member = new Member2(3L,"doje");
            em.persist(member);

            Board board1 = new Board("5","내용용");
            board1.setMember(member);

            em.persist(board1);

            Board board2 = new Board("6","내용요용");
            board2.setMember(member);

            em.persist(board2);

            et.commit();
            System.out.println("완료");
        }
        catch (Exception e) {
            System.out.println("실패");
            e.printStackTrace();
            et.rollback(); // 실패 시 롤백
        }
        finally {
            em.close();
        }
        emf.close();
    }
}
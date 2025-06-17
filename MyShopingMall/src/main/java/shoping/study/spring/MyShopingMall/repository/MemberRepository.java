package shoping.study.spring.MyShopingMall.repository;

import shoping.study.spring.MyShopingMall.Entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext//EntityManager를 빈으로 주입할 때 사용하는 어노테이션입니다.
    EntityManager em;

    public void save(Member member)
    {
        em.persist(member);
    }

    public Member findOne(Long id)
    {
        return em.find(Member.class,id);
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m",Member.class).getResultList();
    }

    public List<Member> findByName(String name){
        return em. createQuery("select m from Member m where m.name = :name",Member.class)
                .setParameter("name",name)
                .getResultList();
    }

}

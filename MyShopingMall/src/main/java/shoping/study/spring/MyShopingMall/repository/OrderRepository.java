package shoping.study.spring.MyShopingMall.repository;

import shoping.study.spring.MyShopingMall.Entity.Order;
import shoping.study.spring.MyShopingMall.Entity.Member;
import shoping.study.spring.MyShopingMall.Entity.OrderSearch;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    @PersistenceContext
    EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }

    public Order findOne(Long id) { // 메서드명 오타 수정
        return em.find(Order.class, id);
    }

    public List<Order> findAll(OrderSearch orderSearch) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
        Root<Order> o = cq.from(Order.class);

        List<Predicate> criteria = new ArrayList<>();

        // 주문 상태로 검색
        if (orderSearch.getOrderStatus() != null) {
            Predicate status = cb.equal(o.get("status"), orderSearch.getOrderStatus());
            criteria.add(status);
        }

        // 회원 이름으로 검색
        if (StringUtils.hasText(orderSearch.getMemberName())) {
            Join<Order, Member> m = o.join("member", JoinType.INNER);
            Predicate name = cb.like(m.get("name"), "%" + orderSearch.getMemberName() + "%");
            criteria.add(name);
        }

        cq.where(cb.and(criteria.toArray(new Predicate[0])));
        TypedQuery<Order> query = em.createQuery(cq).setMaxResults(1000); // 최대 1000건
        return query.getResultList();
    }
}

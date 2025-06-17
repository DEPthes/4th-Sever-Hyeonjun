package shoping.study.spring.MyShopingMall.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shoping.study.spring.MyShopingMall.Entity.*;
import shoping.study.spring.MyShopingMall.repository.MemberRepository;
import shoping.study.spring.MyShopingMall.repository.OrderRepository;

import java.util.List;

@Service
@Transactional
public class OrderService {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ItemService itemService;
    public Long order(Long memberId, Long itemId, int count) {

        Member member = memberRepository.findOne(memberId);
        Item item = itemService.fineOne(itemId);
        Delivery delivery = new Delivery();
        OrderItem orderItem =
        OrderItem.createOrderItem(item, item.getPrice(), count);
        Order order = Order.createOrder(member, delivery, orderItem);
        orderRepository.save(order);
        return order.getId();
    }
    /** 주문 취소 */
    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findOne(orderId);
        order.cancel();
    }
    public List<Order> findOrders(OrderSearch orderSearch) {
        return orderRepository.findAll(orderSearch);
    }
}


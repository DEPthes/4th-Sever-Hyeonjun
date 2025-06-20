package shoping.study.spring.MyShopingMall.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "ORDERS")
public class Order{
    @Id @GeneratedValue @Column(name = "ORDER_ID")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "MEMBER_ID")
    private Member member; //주문 회원
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery; //배송정보
    private Date orderDate; //주문시간
    @Enumerated(EnumType.STRING)
    private OrderStatus status;//주문상태
    //= =연관관계 메소드= =//
    public void setMember(Member member) { this.member = member;
    member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }

    public static Order createOrder(Member member, Delivery delivery, OrderItem... orderItems) {
        Order order = new Order();
        order.setMember(member);
        order.setDelivery(delivery);
        for (OrderItem orderItem : orderItems) { order.addOrderItem(orderItem);
        }
        order.setStatus(OrderStatus.ORDER);
        order.setOrderDate(new Date());
        return order;
    }
    // 주문 취소
    public void cancel() {
        if (delivery.getStatus() == DeliveryStatus.COMP) {
            throw new RuntimeException( "이미 배송완료된 상품은 취소가 불가능합니다.");
        }
        this.setStatus(OrderStatus.CANCEL);
        for (OrderItem orderItem : orderItems) {
            orderItem.cancel();
        }
    }
    // 전체 주문 가격 조회
    public int getTotalPrice() {
        int totalPrice = 0;
        for (OrderItem orderItem : orderItems) {
            totalPrice += orderItem.getTotalPrice();
        }
        return totalPrice;
    }
    //Getter, Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}

package shoping.study.spring.MyShopingMall.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem {
    @Id @GeneratedValue @Column(name = "ORDER_ITEM_ID")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "ITEM_ID")
    private Item item; //주문 상품
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "ORDER_ID")
    private Order order; //주문
    private int orderPrice; //주문 가격
    private int count; //주문 수량

    public static OrderItem createOrderItem(Item item, int orderPrice, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);
        item.removeStock(count);
        return orderItem;
    }
    //주문 취소
    public void cancel() {
        getItem().addStock(count);
    }
    //조회
    public int getTotalPrice() {
        return getOrderPrice() * getCount();
    }


    //Getter, Setter

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }
}

package shoping.study.spring.MyShopingMall.Entity;

public class NotEnoughStockException extends RuntimeException {
    public NotEnoughStockException(String needMoreStock) {
    }
}

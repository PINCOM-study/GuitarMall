package PINCOM.GuitarMall.Order;

//주문 도메인
public class Order {
    private Long memberId;
    private String itemName;

    public Order(Long memberId, String itemName) {
        this.memberId = memberId;
        this.itemName = itemName;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


}

package cafepossystem.data;

public class Discount {

	private String orderNum;
	private String discount;

	public Discount(String orderNum, String discount) {
		this.orderNum = orderNum;
		this.discount = discount;
	}
	
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	
	@Override
	public String toString() {
		return String.format("Discount [orderNum=%s, discount=%s]", orderNum, discount);
	}
}

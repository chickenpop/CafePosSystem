package cafepossystem.data.dummy;

public class OrderHistory {

	private String seq;
	private String coffeeName;
	private String coffeeNum;
	private String price;
	private String orderNum;
	
	public OrderHistory(String seq, String coffeeName, String coffeeNum, String price,
			String orderNum) {
		super();
		this.seq = seq;
		this.coffeeName = coffeeName;
		this.coffeeNum = coffeeNum;
		this.price = price;
		this.orderNum = orderNum;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getCoffeeName() {
		return coffeeName;
	}

	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}

	public String getCoffeeNum() {
		return coffeeNum;
	}

	public void setCoffeeNum(String coffeeNum) {
		this.coffeeNum = coffeeNum;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	
	
}

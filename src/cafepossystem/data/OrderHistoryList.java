package cafepossystem.data;

public class OrderHistoryList {

	private int seq;
	private String coffeeName;
	private String coffeeNum;
	private int price;
	private String orderNum;
	
	public OrderHistoryList(int seq, String coffeeName, String coffeeNum, int price,
			String orderNum) {
		super();
		this.seq = seq;
		this.coffeeName = coffeeName;
		this.coffeeNum = coffeeNum;
		this.price = price;
		this.orderNum = orderNum;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	
	
}

package cafepossystem.data;

public class CoffeeMenu {

	private String seq;
	private String coffeeName;
	private int price;
	
	public CoffeeMenu(String seq, String coffeeName, int price) {
		super();
		this.seq = seq;
		this.coffeeName = coffeeName;
		this.price = price;
	}

	public String getCoffeeName() {
		return coffeeName;
	}

	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSeq() {
		return seq;
	}

	@Override
	public String toString() {
		return String.format("coffemenu [seq=%s, coffeeName=%s, price=%s]", seq, coffeeName, price);
	}

}

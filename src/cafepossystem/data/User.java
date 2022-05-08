package cafepossystem.data;

public class User {

	private String seq;
	private String name;
	private String phoneNum;
	private String point;
	private String coupon;
	
	public User(String seq, String name, String phoneNum, String point, String coupon) {
		this.seq = seq;
		this.name = name;
		this.phoneNum = phoneNum;
		this.point = point;
		this.coupon = coupon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getCoupon() {
		return coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public String getSeq() {
		return seq;
	}

	@Override
	public String toString() {
		return String.format("user [seq=%s, name=%s, phoneNum=%s, point=%s, coupon=%s]", seq, name,
				phoneNum, point, coupon);
	}
	
}

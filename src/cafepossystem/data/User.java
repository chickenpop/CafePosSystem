package cafepossystem.data;

public class User {

	private String seq;
	private String name;
	private String address;
	private String phoneNum;
	private String point;
	private String coupon;

	public User(String seq, String name, String address, String phoneNum, String point,
			String coupon) {
		this.seq = seq;
		this.name = name;
		this.phoneNum = phoneNum;
		this.address = address;
		this.point = point;
		this.coupon = coupon;
	}
	
	public String getSeq() {
		return seq;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	
	@Override
	public String toString() {
		return String.format("회원정보 [seq=%s, name=%s, phoneNum=%s, address=%s, point=%s, coupon=%s]",
				seq, name, phoneNum, address, point, coupon);
	}
}

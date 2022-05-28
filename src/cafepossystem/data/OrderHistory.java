package cafepossystem.data;

public class OrderHistory {

	private String OrderNum;
	private String dateTime;
	private String adminName;
	
	public OrderHistory(String orderNum, String dateTime, String adminName) {
		super();
		OrderNum = orderNum;
		this.dateTime = dateTime;
		this.adminName = adminName;
	}
	public String getOrderNum() {
		return OrderNum;
	}
	public void setOrderNum(String orderNum) {
		OrderNum = orderNum;
	}
	public String getDate() {
		return dateTime;
	}
	public void setDate(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
}

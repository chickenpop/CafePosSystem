package cafepossystem.data;

public class OrderHistoryList {

	private String OrderNum;
	private String date;
	private String adminName;
	
	public OrderHistoryList(String orderNum, String date, String adminName) {
		super();
		OrderNum = orderNum;
		this.date = date;
		this.adminName = adminName;
	}
	public String getOrderNum() {
		return OrderNum;
	}
	public void setOrderNum(String orderNum) {
		OrderNum = orderNum;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
}

package cafepossystem.data;

import java.util.Calendar;

public class OrderHistory {

	private String OrderNum;
	private Calendar date;
	private String adminName;
	
	public OrderHistory(String orderNum, Calendar date, String adminName) {
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
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
}

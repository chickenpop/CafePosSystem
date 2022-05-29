package cafepossystem.management.menu;

import java.util.Calendar;
import cafepossystem.Output;
import cafepossystem.data.Data;
import cafepossystem.data.OrderHistoryList;

public class CafeRevenueCRUD {

	private Calendar now;
	
	public CafeRevenueCRUD() {
		this.now = Calendar.getInstance();
	}

	public void readAnnualSales() {
		
	}
	
	public void readMonthSales() {
		
	}

	public void readDaySales() {
		
		int totalPrice = 0;
		Output.bar();
		Output.subTitle("일매출");
		Output.bar();
		for(OrderHistoryList ohl : Data.orderHistoryList) {
			if(String.format("%tF", now).equals(ohl.getOrderNum().substring(0, 10))) {
				totalPrice += ohl.getPrice();
			}
		}
		
		if(totalPrice == 0) {
			System.out.println("현재 판매된 내역이 조회되지 않습니다.");
		} else {
			System.out.printf("일매출 : %d원\n", totalPrice);			
		}
		Output.bar();
		Output.Waiting();
	}
	
}












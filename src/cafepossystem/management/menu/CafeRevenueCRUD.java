package cafepossystem.management.menu;

import java.util.Calendar;
import cafepossystem.Output;
import cafepossystem.data.CoffeeMenu;
import cafepossystem.data.Data;
import cafepossystem.data.Discount;
import cafepossystem.data.OrderHistoryList;

public class CafeRevenueCRUD {

	private Calendar now;
	private int totalPrice;
	private int[] menuCnt;
	private int[] priceCnt;
	private int discount;
	
	public CafeRevenueCRUD() {
		
		this.now = Calendar.getInstance();
		this.totalPrice = 0;
		this.menuCnt = new int[Data.coffeeMenuList.size()];
		this.priceCnt = new int[Data.coffeeMenuList.size()];
		this.discount = 0;
	}
	
	public void readSales(String input) {
		
		this.totalPrice = 0;
		
		Output.bar();
		System.out.println(input);
		if(input.equals("1")) {
			Output.subTitle("연매출");
			Output.bar();
			AnnualSales();
			ReadSalesRate();
			ReadDiscount();
		} else if(input.equals("2")) {
			Output.subTitle("월매출");
			Output.bar();
			MonthSales();
			ReadSalesRate();
			ReadDiscount();
		} else if(input.equals("3")) {
			Output.subTitle("일매출");
			Output.bar();
			DaySales();
			ReadSalesRate();
			ReadDiscount();
		} else {
			Output.pause();
			return;
		}
		
		if(totalPrice == 0) {
			System.out.println("현재 판매된 내역이 조회되지 않습니다.");
		} else {
			System.out.printf("총 매출 : %d원\n", totalPrice-discount);			
			Output.bar();
			Output.Waiting();
		}
	}
	
	public void ReadSalesRate() {
		
		System.out.println("판매수량");
		Output.bar();
		System.out.println("메뉴명\t\t|  수량  |  판매액  |");
		Output.bar();
		for(CoffeeMenu cm : Data.coffeeMenuList) {
			
			System.out.printf("%-8s\t|%6d잔|%8d원|\n"
					, cm.getCoffeeName()
					, this.menuCnt[Integer.parseInt(cm.getSeq())-1]
					, this.priceCnt[Integer.parseInt(cm.getSeq())-1]);
			
		}
		
	}
	
	public void ReadDiscount() {
		Output.bar();
		System.out.printf("할인 금액: %d원\n", this.discount);
	}
	
	public void countDiscount(String orderNum) {
		for(Discount d : Data.discountList) {
			if(orderNum.equals(d.getOrderNum())) {
				discount += Integer.parseInt(d.getDiscount());
			}
		}
	}
	
	public void countSalesRate(String coffeeMenuName, String coffeeMenuCnt, int coffeePrice) {
		
		for(CoffeeMenu cm : Data.coffeeMenuList) {
			
			if(coffeeMenuName.equals(cm.getCoffeeName())) {
				
				this.menuCnt[Integer.parseInt(cm.getSeq())-1] += Integer.parseInt(coffeeMenuCnt);
				this.priceCnt[Integer.parseInt(cm.getSeq())-1] += coffeePrice;
				break;
			}
			
		}
		
	}
	
	public void AnnualSales() {
		
		for(OrderHistoryList ohl : Data.orderHistoryList) {
			if(String.format("%04d", now.get(Calendar.YEAR)).equals(ohl.getOrderNum().substring(0, 4))) {
				totalPrice += ohl.getPrice();
				countSalesRate(ohl.getCoffeeName(), ohl.getCoffeeNum(), ohl.getPrice());
				countDiscount(ohl.getOrderNum());
			}
		}
	
	}
	
	public void MonthSales() {

		for(OrderHistoryList ohl : Data.orderHistoryList) {
			if(String.format("%02d", now.get(Calendar.MONTH)+1).equals(ohl.getOrderNum().substring(5, 7))) {
				totalPrice += ohl.getPrice();
				countSalesRate(ohl.getCoffeeName(), ohl.getCoffeeNum(), ohl.getPrice());
				countDiscount(ohl.getOrderNum());
			}
		}
	}

	public void DaySales() {
		
		for(OrderHistoryList ohl : Data.orderHistoryList) {
			if(String.format("%tF", now).equals(ohl.getOrderNum().substring(0, 10))) {
				totalPrice += ohl.getPrice();
				countSalesRate(ohl.getCoffeeName(), ohl.getCoffeeNum(), ohl.getPrice());
				countDiscount(ohl.getOrderNum());
			}
		}
	}
	
}












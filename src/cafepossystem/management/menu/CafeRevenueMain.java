package cafepossystem.management.menu;

import java.util.Scanner;
import cafepossystem.Output;

public class CafeRevenueMain {

	public void CafeRevenue() {
		
		Scanner in = new Scanner(System.in);
		
		Output.title("매출 관리");
		Output.bar();
		
		while(true) {
			
			System.out.println("매출 현황");
			Output.bar();
			System.out.println("1. 연 매출");
			System.out.println("2. 월 매출");
			System.out.println("3. 일 매출");
			Output.bar();
			System.out.println("뒤로가기는 0을 입력해주세요");
			String input = in.nextLine();
		
			if(input.equals("0")) {
				System.out.println("이전으로 돌아갑니다.");
				break;
			} else if (input.equals("1")) {
				Output.subTitle("연매출");
				CafeRevenueCRUD cr = new CafeRevenueCRUD();
				cr.readAnnualSales();
			} else if (input.equals("2")) {
				Output.subTitle("월매출");
				CafeRevenueCRUD cr = new CafeRevenueCRUD();
				cr.readMonthSales();
			} else if (input.equals("3")) {
				Output.subTitle("일매출");
				CafeRevenueCRUD cr = new CafeRevenueCRUD();
				cr.readDaySales();
			}
			
		}
		
	}

	
} 

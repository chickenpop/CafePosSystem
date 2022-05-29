package cafepossystem.management.menu;

import java.util.Scanner;
import cafepossystem.Output;
import cafepossystem.data.Data;

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
			} else if (!Data.isString(input)) {
				CafeRevenueCRUD crc = new CafeRevenueCRUD();
				crc.readSales(input);
			} else {
				Output.pause();
			}
			
		}
		
	}

	
} 

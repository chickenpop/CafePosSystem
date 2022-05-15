package cafepossystem;

import java.util.Scanner;
import cafepossystem.data.Data;
import cafepossystem.management.menu.CoffeeMenuMain;
import cafepossystem.management.menu.UserMain;

public class Main {

	public static void main(String[] args) {

		// 데이터 로드
		Data.loadCoffeeMenu();
		Data.loadUser();
		
		Scanner in = new Scanner(System.in);
		
		while(true) {
			Output.logo();
			Output.title("  카페 관리 시스템");
			Output.menu();
			
			System.out.print("이동 메뉴 선택: ");
			String input = in.nextLine();
			
			if(input.equals("1")) {
				System.out.println("주문 관리");
			} else if(input.equals("2")) {
				
				CoffeeMenuMain cm = new CoffeeMenuMain();
				cm.managementCoffeeMenu();
				
			} else if(input.equals("3")) {
				System.out.println("매출 관리");
			} else if(input.equals("4")) {
				UserMain um = new UserMain();
				um.managementUser();
			} else if(input.equals("0")) {
				System.out.println("프로그램이 종료됩니다.");
				in.close();
				break;
			} else {
				Output.pause();
			}
		}

	}

}

package cafepossystem;

import java.util.Scanner;
import cafepossystem.data.Data;
import cafepossystem.login.AdminLogin;
import cafepossystem.management.menu.CafeOrderMain;
import cafepossystem.management.menu.CafeRevenue;
import cafepossystem.management.menu.CoffeeMenuMain;
import cafepossystem.management.menu.UserMain;

public class Main {

	public static void main(String[] args) {

		// 데이터 로드
		Data.loadCoffeeMenu();
		Data.loadUser();
		
		Scanner in = new Scanner(System.in);
		
		// 첫화면
		Output.logo();
		Output.title("  카페 관리 시스템");
		Output.bar();
		Output.subTitle("로그인");
		
		
		// 로그인 기능
		AdminLogin al = new AdminLogin();
		while(true) {
			boolean flag = al.amdinLogin();
			if(flag) {
				break;
			}
		}		
		
		while(true) {
			Output.logo();
			Output.title("  카페 관리 시스템");
			Output.menu();
			
			System.out.print("이동 메뉴 선택: ");
			String input = in.nextLine();
			
			if(input.equals("1")) {
				
				CafeOrderMain co = new CafeOrderMain();
				co.managementCafeOrder();
				
			} else if(input.equals("2")) {
				
				CoffeeMenuMain cm = new CoffeeMenuMain();
				cm.managementCoffeeMenu();
				
			} else if(input.equals("3")) {
				
				CafeRevenue cr = new CafeRevenue();
				cr.CafeRevenueMain();
				
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

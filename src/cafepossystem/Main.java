package cafepossystem;

import java.util.Scanner;
import cafepossystem.data.Data;
import cafepossystem.login.AdminLogin;
import cafepossystem.management.menu.CafeOrderMain;
import cafepossystem.management.menu.CafeRevenueMain;
import cafepossystem.management.menu.CoffeeMenuMain;
import cafepossystem.management.menu.UserMain;

public class Main {

	public static void main(String[] args) {

		// 데이터 로드
		Data.loadCoffeeMenu();
		Data.loadUser();
		Data.loadOrderHistory();
		Data.loadOrderHistoryList();
		
		Scanner in = new Scanner(System.in);
		
		// 첫화면
		Output.logo();
		Output.title("  카페 관리 시스템");
		Output.bar();
		
		
		// 로그인 기능
		AdminLogin al = new AdminLogin();
		boolean flag = true;		
		
		while(true) {
			
			while(flag) {
				flag = al.amdinLogin();
				if(!flag) {
					break;
				}
			}
			
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
				
				CafeRevenueMain cr = new CafeRevenueMain();
				cr.CafeRevenue();
				
			} else if(input.equals("4")) {
				UserMain um = new UserMain();
				um.managementUser();
			} else if(input.equals("5")) {
				
				flag = al.adminLogout();
				
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

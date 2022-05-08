package cafepossystem;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		while(true) {
			Output.logo();
			Output.title();
			Output.menu();
			
			System.out.print("이동 메뉴 선택: ");
			String input = in.nextLine();
			
			if(input.equals("1")) {
				System.out.println("주문 관리");
			} else if(input.equals("2")) {
				System.out.println("메뉴 관리");
				
			} else if(input.equals("3")) {
				System.out.println("매출 관리");
			} else if(input.equals("4")) {
				System.out.println("회원 관리");
			} else if(input.equals("0")) {
				System.out.println("프로그램이 종료됩니다.");
				in.close();
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
				System.out.print("다시 입력하시겠습니까?(엔터를 입력해주세요.)");
				input = in.nextLine();
			}
		}

	}

}

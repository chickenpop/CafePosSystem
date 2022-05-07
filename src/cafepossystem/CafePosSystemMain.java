package cafepossystem;

import java.util.Scanner;

public class CafePosSystemMain {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		while(true) {
			CafePosSystemOutput.logo();
			CafePosSystemOutput.title();
			CafePosSystemOutput.menu();
			
			System.out.print("이동 메뉴 선택: ");
			String input = in.nextLine();
			
			if(input.equals("1")) {
				
			} else if(input.equals("2")) {
				
			} else if(input.equals("3")) {
				
			} else if(input.equals("4")) {
				
			} else if(input.equals("0")) {
				System.out.println("프로그램이 종료됩니다.");
				in.close();
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
				System.out.print("다시 입력하시겠습니까?(아무키를 입력해주세요.)");
				String retry = in.nextLine();
			}
		}

	}

}

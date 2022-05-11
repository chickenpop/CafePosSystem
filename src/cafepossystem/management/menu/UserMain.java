package cafepossystem.management.menu;

import java.util.Scanner;
import cafepossystem.Output;

public class UserMain {

	public void managementUser() {
		
		while(true) {
			Scanner in = new Scanner(System.in);
			
			System.out.println();
			System.out.println();
			Output.title("유저 관리 시스템");
			Output.bar();
			
			
			
			System.out.print("이동 번호(기능) 선택:");
			String input = in.nextLine();
					
			// 메뉴 기능
			if(input.equals("0")) break;
			
		}
		
	}
	
}

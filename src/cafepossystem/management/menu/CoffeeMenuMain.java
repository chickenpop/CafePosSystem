package cafepossystem.management.menu;

import java.util.Scanner;
import cafepossystem.Output;
import cafepossystem.data.CoffeeMenu;
import cafepossystem.data.Data;

public class CoffeeMenuMain {

	public void managementCoffeeMenu() {
			
		Scanner in = new Scanner(System.in);
		int currentPage = 1; // 현재 페이지
		int pageBlock = 5;  // 페이지 당 목록 수
		while(true) {
			
			System.out.println();
			System.out.println();
			Output.title("메뉴 관리 시스템");
			Output.bar();
			
			Output.subTitle("메뉴 현황");
			// 페이징
			int totalPage = Data.coffeeMenuList.size()/pageBlock + ((Data.coffeeMenuList.size()%pageBlock) > 0 ? 1 : 0); // 총 페이지		
			
			int currentBlock = currentPage-1;	// 현재 목록 번호
			int startNum = currentBlock*pageBlock+1;
			int endNum = currentBlock*pageBlock + pageBlock;
			
			// 메뉴 조회
			System.out.println("번호 | 메뉴 이름\t | 가격");
			Output.bar();
			Data.coffeeMenuList
					.stream()
					.filter(c -> (Integer.parseInt(c.getSeq()) <= endNum && Integer.parseInt(c.getSeq()) >= startNum))
					.forEach(c -> System.out.printf("%4s | %-8s\t | %-5s원\n",c.getSeq(), c.getCoffeeName(), c.getPrice()));
			
			for(int i=1; i<=totalPage; i++) {
				if(i>totalPage) break;
				if(i==currentPage) System.out.printf("[%d]", i);
				else System.out.printf("|%d|", i);
			}
			System.out.println();
			Output.bar();
			System.out.println("|메뉴 추가 | 메뉴 수정 | 메뉴 삭제| 뒤로가기(0)");
			Output.bar();
			System.out.println("메뉴 기능을 사용하려면 추가, 수정, 삭제로 입력해주세요");
			System.out.println("페이지를 이동하려면 숫자를 입력해주세요");
			System.out.print("이동 번호(기능) 선택:");
			String input = in.nextLine();
					
			// 메뉴 기능
			if(Data.isString(input)) {
				if(input.equals("추가")) {
					CoffeeMenuCRUD.createCoffeeMenu();
					
				} else if(input.equals("수정")) {
					
					CoffeeMenuCRUD.updateCoffeeMenu();
					
				} else if(input.equals("삭제")) {
								
					boolean result = CoffeeMenuCRUD.deleteCoffeeMenu();
					if(result) {
						currentPage = 1;
					} 
				
				} else {
					Output.pause();
				}
			} else { // 페이지 이동
				int pageNum = Integer.parseInt(input);
				if(pageNum == 0) {
					System.out.println("이전으로 돌아갑니다.");
					break;
				} else if(pageNum >= 1  && pageNum <=totalPage) {
					currentPage = pageNum;
				} else {
					Output.pause();
				}
			}
			
		}
	} // managementCoffeeMenu
	
	
} // CoffeeMenuMain

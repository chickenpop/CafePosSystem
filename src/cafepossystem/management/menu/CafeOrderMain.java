package cafepossystem.management.menu;

import java.util.Scanner;
import cafepossystem.Output;
import cafepossystem.data.CoffeeMenu;
import cafepossystem.data.Data;

public class CafeOrderMain {

	public void managementCafeOrder() {
		
		// 주문 메뉴 출력
		int currentPage = 1; // 현재 페이지
		int pageBlock = 5;  // 페이지 당 목록 수
		Scanner in = new Scanner(System.in);
		
		
		int totalPrice = 0; // 주문 합계 가격
		int menuPrice = 0; // 선택된 메뉴 가격
		
		while(true) {
			
			System.out.println();
			System.out.println();
			Output.title("주문 관리");
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
			System.out.println("주문은 숫자 페이지이동은 p+숫자를 입력해주세요");
			System.out.print("이동 번호(기능) 선택:");
			String input = in.nextLine();
		
			
			// 메뉴 기능
			if(input.equals("0")) {
				break;
			} else if(Data.isString(input)) {
				if(input.toLowerCase().contains("p")) {
					input = input.toLowerCase().replace("p", "");
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
			} else { // 페이지 이동

				for(CoffeeMenu cf : Data.coffeeMenuList) {
					
					if(cf.getSeq().equals(input)) {
						menuPrice = cf.getPrice();
						break;
					}
					
				}
				System.out.println(menuPrice);
				
			}
			
			// 수량 선택
			System.out.println("선택한 메뉴의 수량을 입력해주세요");
			System.out.print("수량:");
			String num = in.nextLine();
			if(Data.isString(num)) {
				Output.pause();
			} else {
				totalPrice = menuPrice * Integer.parseInt(num);
			}
			System.out.printf("현재 금액 : %d\n", totalPrice);
			
		}
		
		// 최종 출력(가격이랑 수량 표시)
		
		// 주문 등록
		
		
	}

}

package cafepossystem.management.menu;


import java.util.ArrayList;
import java.util.Scanner;
import cafepossystem.Output;
import cafepossystem.data.CoffeeMenu;
import cafepossystem.data.Data;
import cafepossystem.data.OrderHistoryList;

public class CafeOrderMain {

	private static int totalPrice = 0; 		// 주문 합계 가격
	private static CoffeeMenu pickCoffee = new CoffeeMenu("0", "미선택메뉴", 0); 		// 선택된 메뉴
	private static int currentMenuPrice = 0; 	// 선택된 메뉴 * 수량

	public void managementCafeOrder() {
		
		// 주문 메뉴 출력
		int currentPage = 1; // 현재 페이지
		int pageBlock = 5;  // 페이지 당 목록 수
		Scanner in = new Scanner(System.in);
		
		
		// 주문 내역
		ArrayList<OrderHistoryList> orderList = new ArrayList<OrderHistoryList>(10);

		while(true) {
			
			System.out.println();
			System.out.println();
			Output.title("주문 관리");
			Output.bar();
			
			Output.subTitle("메뉴 현황");
			Output.bar();
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
			System.out.println("주문을 중간에 취소하려면 \"취소\"를 입력해주세요");
			System.out.println("주문을 확정하시려면 \"확정\"을 입력해주세요 ");
			System.out.print("이동 번호(기능) 선택:");
			String input = in.nextLine();
		
			
			// 메뉴 기능
			if(input.equals("0")) {
				// 뒤로가기
				break;
			} else if(Data.isString(input)) {
				// 페이지 이동
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
				
				if(input.equals("취소")) {
					orderList.clear();
					totalPrice = 0;
				}
				
				if(input.equals("확정")) {
					
				}
				
			} else { 
				
				for(CoffeeMenu cf : Data.coffeeMenuList) {
					
					if(cf.getSeq().equals(input)) {
						pickCoffee = cf;
						break;
					}
					
				}
				
				if(!pickCoffee.getSeq().equals("0")) {
					// 수량 선택
					System.out.println("선택한 메뉴의 수량을 입력해주세요");
					System.out.print("수량:");
					String num = in.nextLine();
					if(Data.isString(num)) {
						Output.pause();
					} else {
						totalPrice += pickCoffee.getPrice() * Integer.parseInt(num);
						currentMenuPrice = pickCoffee.getPrice() * Integer.parseInt(num);
					}
					
					OrderHistoryList ohl = new OrderHistoryList(orderList.size()+1, pickCoffee.getCoffeeName(), num, currentMenuPrice, "a");
					if(!ohl.getCoffeeNum().equals("0") && !pickCoffee.getSeq().equals("0")) {
						orderList.add(ohl);					
					}
					// 현재 주문 내역 출력
					System.out.println("현재 주문 현황");
					orderList.stream()
								.forEach(o -> System.out.printf("메뉴 : %s 수량 : %s 메뉴금액: %d원 합계금액 %d원\n"
																			, o.getCoffeeName()
																			, o.getCoffeeNum()
																			, o.getPrice()/Integer.parseInt(o.getCoffeeNum())
																			, o.getPrice()));
					System.out.printf("현재 총 금액 : %d\n", totalPrice);
				} else {
					System.out.println("잘못된 메뉴 선택입니다.");
					Output.pause();
				}
			}
			
		}
	
		
		
	}



}

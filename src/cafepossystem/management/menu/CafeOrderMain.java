package cafepossystem.management.menu;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import cafepossystem.Output;
import cafepossystem.data.CoffeeMenu;
import cafepossystem.data.Data;
import cafepossystem.data.Discount;
import cafepossystem.data.OrderHistory;
import cafepossystem.data.OrderHistoryList;
import cafepossystem.data.User;

public class CafeOrderMain {

	private int totalPrice = 0; 		// 주문 합계 가격
	private int totalMenuCnt = 0;
	private int currentMenuPrice = 0; 	// 선택된 메뉴 * 수량
	private int ordercnt;
	private int seq = Data.orderHistoryList.size()+1;
	private int discount = 0;
	private CoffeeMenu pickCoffee = new CoffeeMenu("0", "미선택메뉴", 0); 		// 선택된 메뉴
	private Calendar now = Calendar.getInstance();
	private Scanner in = new Scanner(System.in);
	
	public void managementCafeOrder() {
		
		ordercnt = ordercnt();
		
		// 주문 메뉴 페이지 변수
		int currentPage = 1; // 현재 페이지
		int pageBlock = 5;  // 페이지 당 목록 수
		
		// 주문 내역
		ArrayList<OrderHistoryList> orderList = new ArrayList<OrderHistoryList>(10);

		while(true) {
			
			System.out.println();
			System.out.println();
			Output.title("\t주문 관리");						if(orderList.size() > 0) {
				Output.subTitle("메뉴 현황", "\t\t\t  [주문진행중]");				
			} else {
				Output.subTitle("메뉴 현황");				
			}
			
			// 주문 메뉴 페이지 변수
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
			System.out.print("이동 번호(기능) 선택:");
			String input = in.nextLine();
		
			
			// 메뉴 기능
			if(input.equals("0")) {
				// 뒤로가기
				break;
			} else if(Data.isString(input)) { 
				// p + 숫자 형태라면 페이지 이동
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
				
				// '취소'라는 단어가 입력되면 주문 내역 clear
				if(input.equals("취소")) {
					orderList.clear();
					totalPrice = 0;
				}
	
				
			} else { 
				
				// 입력한 메뉴 찾기
				for(CoffeeMenu cf : Data.coffeeMenuList) {
					
					if(cf.getSeq().equals(input)) {
						pickCoffee = cf;
						break;
					}
					
				}
				
				if(!pickCoffee.getSeq().equals("0")) {
					
					input = pickMenuPrintOrder(orderList);
					
					if(input.equals("확정")) {
						
						String phoneNum = useCoupon();
						order(orderList);
						orderUser(totalMenuCnt, phoneNum);
						Output.Waiting();
						
					} else {
						System.out.println("메뉴현황으로 이동합니다.");
					}
					MenuOutput.bar();
				} else {
					System.out.println("잘못된 메뉴 선택입니다.");
					Output.pause();
				}
			}
			
		}
	
		
	} // managementCafeOrder

	private String pickMenuPrintOrder(ArrayList<OrderHistoryList> orderList) {
		String input;
		// 수량 선택
		boolean flag = true;
		String num = null;
		while(flag) {
			
			MenuOutput.bar();
			System.out.println("선택한 메뉴의 수량을 입력해주세요");
			System.out.print("수량:");
			num = in.nextLine();
			flag = pickCoffeeMenuCnt(num);
			MenuOutput.bar();
		}
		
		now = Calendar.getInstance();
		String ordernum = String.format("%tF%s%03d", now, Data.amdin.getStatus(), ordercnt);

		OrderHistoryList ohl = new OrderHistoryList(seq++, pickCoffee.getCoffeeName(), num, currentMenuPrice, ordernum);
		if(!ohl.getCoffeeNum().equals("0") && !pickCoffee.getSeq().equals("0")) {
			orderList.add(ohl);					
		}
		
		// 현재 주문 내역 출력
		MenuOutput.bar();
		System.out.println("현재 주문 현황");
		MenuOutput.bar();
		MenuOutput.OrderMenu();					
		orderList.stream()
					.forEach(o -> System.out.printf("%-8s\t | %4s | %6d원 | %8d원\n"
																, o.getCoffeeName()
																, o.getCoffeeNum()
																, o.getPrice()/Integer.parseInt(o.getCoffeeNum())
																, o.getPrice()));
		MenuOutput.bar();
		System.out.printf("현재 총 금액\t\t\t%13d원\n", totalPrice);
		MenuOutput.bar();
		System.out.println("주문을 확정하시려면 \"확정\"을 입력해주세요(아니라면 엔터)");
		input = in.nextLine();
		return input;
	}

	// 쿠폰 사용 기능
	private String useCoupon() {

		MenuOutput.bar();
		System.out.print("쿠폰을 사용하시겠습니까?(y/n) : ");
		
		String input = in.nextLine();
		if(input.toLowerCase().equals("y")) {
			MenuOutput.UserPhoneNum();
			input = in.nextLine();
			
			MenuOutput.bar();
			input = input.replace(" ", ""); // 공백제거
			
			for(User u : Data.userList) {
				if(u.getPhoneNum().equals(input)) {
					
					
					System.out.printf("%s의 회원님 쿠폰이 총 %s개 있습니다.\n", u.getName(), u.getCoupon());
					System.out.println("쿠폰의 1개는 에스프레소 가격입니다.");
					System.out.println("쿠폰 사용을 취소하시려면 0을 입력해주세요");
					MenuOutput.bar();
					System.out.println("사용하시려는 쿠폰 갯수를 입력해주세요");
					System.out.print("쿠폰:");
					String coupon = in.nextLine();
					coupon = UserCRUD.inputIsNumber(coupon, 0);  // 숫자 유효성 검사
					if(coupon.equals("0")) return null; // 쿠폰 입력을 0으로 하는 경우 쿠폰 사용이 취소된다.
					discount += Data.coffeeMenuList.get(0).getPrice() * Integer.parseInt(coupon);
					u.setCoupon(String.format("%s", Integer.parseInt(u.getCoupon()) - Integer.parseInt(coupon)));
					
					Data.saveUser();
					Data.loadUser();
					
					return input;
				}
			}

		} 
		
		return null;
		
	}

	// 적립 기능
	private void orderUser(int totalMenuCnt, String phoneNum) {

		if(phoneNum == null) {
			System.out.print("적립하시겠습니까?(y/n) : ");
			String input = in.nextLine();
			if(input.toLowerCase().equals("y")) {
				
				MenuOutput.UserPhoneNum();
				input = in.nextLine();
				
				input = input.replace(" ", ""); // 공백제거
			
				for(User u : Data.userList) {
					if(u.getPhoneNum().equals(input)) {
						
						MenuOutput.bar();
						System.out.printf("%s의 회원님 적립됐습니다.\n", u.getName());
						MenuOutput.bar();
						
						totalMenuCnt += Integer.parseInt(u.getPoint());
						if(totalMenuCnt >= 10) {
							int temp = Integer.parseInt(u.getCoupon());
							u.setCoupon(String.format("%s", (temp+totalMenuCnt/10)));
							u.setPoint(String.format("%s", (totalMenuCnt%10)));
						} else {
							u.setPoint(String.format("%s", totalMenuCnt));
						}
						break;
					}
				}
				
				Data.saveUser();
				Data.loadUser();
				
			} 
		}else {
			return;
		}
		
	}

	// 주문 확정
	private void order(ArrayList<OrderHistoryList> orderList) {
		now = Calendar.getInstance();
		
		String ordernum = String.format("%tF%s%03d", now, Data.amdin.getStatus(), ordercnt);
		OrderHistory order = new OrderHistory(ordernum,String.format("%tT", now),Data.amdin.getStatus());
		
		Data.orderHistory.add(order);
		for(OrderHistoryList ohl : orderList) {
			Data.orderHistoryList.add(ohl);
		}
		ordercnt++;
		orderList.clear();
		
		Data.saveOrderHistoryList();
		Data.saveOrderHistory();
		Data.loadOrderHistory();
		Data.loadOrderHistoryList();
		
		
		MenuOutput.bar();
		System.out.println("최종 영수증 출력");
		MenuOutput.bar();
		MenuOutput.OrderMenu();
		for(OrderHistoryList ohl : Data.orderHistoryList) {
			if(Data.orderHistory.get(Data.orderHistory.size()-1).getOrderNum().equals(ohl.getOrderNum())){
				 System.out.printf("%-8s\t | %4s | %6d원 | %8d원\n"
							, ohl.getCoffeeName()
							, ohl.getCoffeeNum()
							, ohl.getPrice()/Integer.parseInt(ohl.getCoffeeNum())
							, ohl.getPrice());
				 totalMenuCnt += Integer.parseInt(ohl.getCoffeeNum());
			}
		}
		MenuOutput.bar();
		System.out.printf("할인 금액\t\t\t%13d원\n", discount);
		System.out.printf("총 금액\t\t\t\t%13d원\n", totalPrice-discount);	
		MenuOutput.bar();
		
		if(totalPrice-discount < 0) {
			discount = totalPrice;
		} 
		
		if(discount != 0) {
			Discount d = new Discount(ordernum, String.format("%s", discount));
			Data.discountList.add(d);
			Data.saveDiscount();
			Data.loadDiscount();
		}		
	
		discount = 0;
		totalPrice = 0;
	}

	private int ordercnt() {
		
		now = Calendar.getInstance();
		
		String nowdate = String.format("%tF", now);
		String temp = Data.orderHistoryList.get(Data.orderHistoryList.size()-1).getOrderNum();
		String date = temp.substring(0, 10);
		int cnt = 1;
		
		if(!nowdate.equals(date)) {
			return cnt;
		} else {
			cnt = Integer.parseInt(temp.substring(12))+1;
		}
		
		return cnt;
	}
	
	private boolean pickCoffeeMenuCnt(String num) {
		if(Data.isString(num)) {
			Output.pause();
			return true;
		} else if (Integer.parseInt(num) == 0) {
			Output.pause();
			return true;
		} else {
			totalPrice += pickCoffee.getPrice() * Integer.parseInt(num);
			currentMenuPrice = pickCoffee.getPrice() * Integer.parseInt(num);
			return false;
		}
	}



}

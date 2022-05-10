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
			
			int totalPage = Data.coffeeMenuList.size()/pageBlock + ((Data.coffeeMenuList.size()%pageBlock) > 0 ? 1 : 0); // 총 페이지		
			
			int currentBlock = currentPage-1;	// 현재 목록 번호
			int startNum = currentBlock*pageBlock+1;
			int endNum = currentBlock*pageBlock + pageBlock;
			
			Output.subTitle("메뉴 현황");
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
			if(isString(input)) {
				if(input.equals("추가")) {
					Output.subTitle("메뉴 추가");
					String seq = Data.coffeeMenuList.size() + 1 + "";
					String name;
					String price;
					// 메뉴명
					while(true) {
						System.out.println("추가할 메뉴명을 입력해주세요");
						System.out.print("메뉴명: ");
						name = in.nextLine();
						if(checkCoffeeName(name)) {
							break;
						} else {
							System.out.println("메뉴명이 유효하지 않습니다.");
							System.out.println("메뉴명을 다시 입력해주세요");
						}
					}
					// 가격
					while(true) {
						System.out.println("메뉴의 가격을 입력해주세요");
						System.out.print("가격: ");
						price = in.nextLine();
						if(checkPrice(price)) {
							break;
						} else {
							System.out.println("가격이 유효하지 않습니다.");
							System.out.println("가격을 다시 입력해주세요");
						}
					}
					
					CoffeeMenu cf = new CoffeeMenu(seq, name, Integer.parseInt(price));
					
					// 데이터 저장
					Data.coffeeMenuList.add(cf);
					updateMenu();
					
				} else if(input.equals("수정")) {
					Output.subTitle("메뉴 수정");
					System.out.println("수정하고 싶지 않으면 엔터를 입력해주세요");
					System.out.print("수정하려는 메뉴 번호:");
					String seq = in.nextLine();
					
					System.out.print("수정 메뉴이름:");
					String menuName = in.nextLine();
					
					System.out.print("수정 가격:");
					String menuPrice = in.nextLine();
					
					for(CoffeeMenu cm : Data.coffeeMenuList) {
						
						if(cm.getSeq().equals(seq)) {
							
							if(!menuName.equals("")) {
								cm.setCoffeeName(menuName);
							}
							
							if(!menuPrice.equals("") && !isString(menuPrice)) {
								cm.setPrice(Integer.parseInt(menuPrice));
							}
							
						}
						
					}
					
					System.out.println("수정이 완료되었습니다.");
					updateMenu();
					
				} else if(input.equals("삭제")) {
					Output.subTitle("메뉴 삭제");
					System.out.println("삭제를 하고 싶지 않으면 엔터를 입력해주세요");
					
					System.out.print("삭제하려는 메뉴 번호:");
					String seq = in.nextLine();
					
					CoffeeMenu cf = null;
					
					for(CoffeeMenu cm : Data.coffeeMenuList) {
						
						if(cm.getSeq().equals(seq)) {
							cf = cm;
							break;
						}
						
					}
					
					if(cf != null) {
						System.out.printf("%s삭제되었습니다.\n", cf.getCoffeeName());
						Data.coffeeMenuList.remove(cf);
						updateMenu();
						currentPage = 1;
					} else {
						System.out.println("삭제가 실패하였습니다.");
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
	}

	private void updateMenu() {
		Data.saveCoffeeMenu();
		Data.coffeeMenuList.clear();
		Data.loadCoffeeMenu();
	}
	
	private boolean checkPrice(String price) {
			
		if(isString(price)) return false; 
		else {
			int tmp = Integer.parseInt(price);
			if(tmp <= 0) return false;
		}		
		return true;
	}

	private static boolean checkCoffeeName(String name) {
		
		boolean flag = Data.coffeeMenuList.stream().allMatch(c -> !c.getCoffeeName().equals(name));
		
		return flag;
	}
	
	private static boolean isString(String t) { 
		char[] ch = t.toCharArray();
		boolean flag = false;
		for(char c : ch) {
			if(!Character.isDigit(c)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
}

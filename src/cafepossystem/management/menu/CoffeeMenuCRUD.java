package cafepossystem.management.menu;

import java.util.Scanner;
import cafepossystem.Output;
import cafepossystem.data.CoffeeMenu;
import cafepossystem.data.Data;

public class CoffeeMenuCRUD {

	private static Scanner in = new Scanner(System.in);
	
	public static void addCoffeeMenu() {
		
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
		Data.updateMenu();
		
	}
	
	public static void updateCoffeeMenu() {
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
				
				if(!menuPrice.equals("") && !Data.isString(menuPrice)) {
					cm.setPrice(Integer.parseInt(menuPrice));
				}
				
			}
			
		}
		
		System.out.println("수정이 완료되었습니다.");
		Data.updateMenu();
	}
	
	public static boolean deleteCoffeeMenu() {
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
			Data.updateMenu();
			return true;
		} else {
			System.out.println("삭제가 실패하였습니다.");
			return false;
		}
		
	}
	
	
	private static boolean checkPrice(String price) {
			
		if(Data.isString(price)) return false; 
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
		
	
}

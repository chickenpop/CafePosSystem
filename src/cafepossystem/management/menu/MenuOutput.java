package cafepossystem.management.menu;

public class MenuOutput {

	public static void bar() {
		System.out.println("=========================================================");
	}
	
	public static void OrderMenu() {
		System.out.println("메뉴 이름\t | 수량 |     가격 | 합계  금액");
	}
	
	public static void UserPhoneNum() {
		System.out.println("회원의 전화번호를 입력해주세요");
		System.out.print("전화번호 : ");	
	}
	
}

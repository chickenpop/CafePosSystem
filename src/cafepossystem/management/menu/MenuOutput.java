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
	
	public static void title(String titleName) {
		bar();
		System.out.printf("\t     %s\n", titleName);
	}
	
	public static void subTitle(String subTitle) {
		bar();
		System.out.printf("-%s-\n", subTitle);
		bar();
	}
	
	public static void subTitle(String sutTitle, String additionalElements) {
		System.out.printf("-%s- %s\n", sutTitle, additionalElements);
	}
	
	public static void address() {
		System.out.println("강남구 내에 거주하는 사람만 가입할 수 있습니다.");
		System.out.println("강남구의 읍면동만 입력해주세요(ex)역삼동)");
	}
	
}

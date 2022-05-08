package cafepossystem;

public class Output {
	
	public static void logo() {
		bar();
		System.out.println(""
				+ "\t       "+"        /  -@     \r\n"
				+ "\t       "+"      . -#        \r\n"
				+ "\t       "+"        - $       \r\n"
				+ "\t       "+"         =        \r\n"
				+ "\t       "+"  ::::::::::::    \r\n"
				+ "\t       "+" .-          -.   \r\n"
				+ "\t       "+" .=          -:;  \r\n"
				+ "\t       "+"  =          #.;  \r\n"
				+ "\t       "+"  -!        ;= ;  \r\n"
				+ "\t       "+"  :@;      -*$!   \r\n"
				+ "\t       "+"-.!-#*    ;#      \r\n"
				+ "\t       "+",~$, ;@@@@;       \r\n"
				+ "\t       "+" @-------------   \r\n"
				+ "\t       "+" #@@@@@@@@@@@@@");
		
	}
	
	public static void title() {
		bar();
		System.out.println("\t    카페 정보 관리 시스템");
	}
	
	public static void menu() {
		bar();
		System.out.print("|1. 주문 관리 |");
		System.out.print("\t|2. 메뉴 관리 |");
		System.out.println("\t|3. 매출 관리 |");
		System.out.print("|4. 회원 관리 |");
		System.out.print("\t|0. 종료      |");
		System.out.println("\t|             |");
		bar();
	}
	
	public static void bar() {
		System.out.println("===============================================");
	}
	
}

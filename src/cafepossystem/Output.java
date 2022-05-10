package cafepossystem;

import java.util.Scanner;

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
	
	public static void title(String titleName) {
		bar();
		System.out.printf("\t     %s\n", titleName);
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
	
	public static void subTitle(String subTitle) {
		System.out.printf("-%s-\n", subTitle);
	}
	
	public static void pause() {
		Scanner in = new Scanner(System.in);
		System.out.println("잘못된 입력입니다.");
		System.out.print("다시 입력하시겠습니까?(엔터를 입력해주세요.)");
		String input = in.nextLine();
	}
	
	public static void bar() {
		System.out.println("===============================================");
	}
	
}
package cafepossystem.management.menu;

import java.util.Scanner;
import cafepossystem.Output;
import cafepossystem.data.Data;

public class UserCRUD {

	private static Scanner in = new Scanner(System.in);
	
	public static void addUser() {

		Output.subTitle("유저 회원가입");
		
		System.out.print("유저 이름:");
		String name = in.nextLine();
		name = checkRequirement(name);
		
		System.out.println("전화번호는 '-'없이 입력해주세요");
		System.out.print("유저 전화번호:");
		String phoneNum = in.nextLine();
		phoneNum = checkRequirement(phoneNum);
		phoneNum.replace("-", "");
		
		System.out.println("엔터를 입력하시면 가입 포인트로 적용됩니다.");
		System.out.print("유저 포인트:");
		String point = in.nextLine();
		if(point.equals("")) {
			point = "0";
		} 
		if(Data.isString(point)) {
			System.out.println("포인트는 숫자만 입력할 수 있습니다");
			point = checkRequirement(point);
		}
		
		// TODO 가입 쿠폰수 조정 (2022. 5. 15. 오후 11:52:20)
		System.out.println("엔터를 입력하시면 가입 쿠폰이 적용됩니다.");
		System.out.print("유저 쿠폰:");
		String coupon = in.nextLine();
		if(coupon.equals("")) {
			coupon = "1";
		} 
		if(Data.isString(coupon)) {
			System.out.println("쿠폰은 숫자만 입력할 수 있습니다");
			coupon = checkRequirement(coupon);
		}
		
		
		
	}

	private static String checkRequirement(String check) {
		while(true) {
			if(check.equals("")) System.out.println("!다시 입력해주세요!");
			else break;
			check = in.nextLine();
		}
		return check;
	}

}

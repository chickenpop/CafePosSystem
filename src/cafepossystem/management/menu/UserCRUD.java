package cafepossystem.management.menu;

import java.util.Scanner;
import cafepossystem.Output;
import cafepossystem.data.CoffeeMenu;
import cafepossystem.data.Data;
import cafepossystem.data.User;

public class UserCRUD {

	private static Scanner in = new Scanner(System.in);
	
	public static void addUser() {

		Output.subTitle("유저 회원가입");

		String seq = Data.userList.size() + 1 + "";
		
		System.out.print("유저 이름:");
		String name = in.nextLine();
		name = checkRequirement(name);
		
		System.out.println("강남구 내에 거주하는 사람만 가입할 수 있습니다.");
		System.out.println("강남에 존재하는 읍면동만 입력해주세요(ex 역삼동)");
		String address = in.nextLine();
		address = checkAddress(address, true);
		
		System.out.println("전화번호는 '-'없이 입력해주세요");
		System.out.print("유저 전화번호:");
		String phoneNum = in.nextLine();

		phoneNum = checkPhoneNum(phoneNum, true);
		
		System.out.println("엔터를 입력하시면 가입 포인트로 적용됩니다.");
		System.out.print("유저 포인트:");
		String point = in.nextLine();
		point = inputIsNumber(point, 0);
		
		System.out.println("엔터를 입력하시면 가입 쿠폰이 적용됩니다.");
		System.out.print("유저 쿠폰:");
		String coupon = in.nextLine();
		coupon = inputIsNumber(coupon, 1);
		
		User u = new User(seq, name, address, phoneNum, point, coupon);
		
		Data.userList.add(u);
		Data.updateUser();
		
	}

	private static String checkPhoneNum(String phoneNum, boolean flag) {
		while(flag) {
			for(User u : Data.userList) {
				if(u.getPhoneNum().equals(phoneNum) || phoneNum.length() != 11) {
					System.out.println("잘못된 전화번호입니다");
					System.out.println("!다시 입력해주세요!");
					phoneNum = in.nextLine();
					flag = true;
					break;
				} else {
					flag = false;
				}
			}
			
		}
		return phoneNum;
	}

	private static String checkAddress(String address, boolean flag) {
		String[] dong = {"신사동", "압구정동", "청담동", "논현동", "대치동", "삼성동", "역삼동", "도곡동", "개포동", "일원동", "수서동", "자곡동", "세곡동", "율현동"};
	
		while(flag) {
			for(String d : dong) {
				if(address.contains(d)) {
					address = "서울 특별시 강남구 " + address;
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.println("!다시 입력해주세요!");
				address = in.nextLine();
			}
		}
		return address;
	}

	private static String inputIsNumber(String check, int setting) {
		if(check.equals("")) {
			check = setting + "";
		} 
		if(Data.isString(check)) {
			System.out.println("숫자만 입력할 수 있습니다");
			check = checkRequirement(check);
		}
		return check;
	}

	private static String checkRequirement(String check) {
		while(true) {
			if(check.equals("")) System.out.println("!다시 입력해주세요!");
			else break;
			check = in.nextLine();
		}
		return check;
	}

	public static void updateUser() {

		Output.subTitle("회원 정보 수정");
		System.out.println("수정하고 싶지 않으면 엔터를 입력해주세요");
		System.out.print("수정하려는 회원 번호:");
		String seq = in.nextLine();
		
		System.out.println("회원 상세 정보");
		User user = Data.userList.get(Integer.parseInt(seq)-1);
		
		System.out.print("수정 이름:");
		String name = in.nextLine();
		if(name.equals("")) {
			name = user.getName();
		} else {
			checkRequirement(name);
		}
		
		System.out.print("수정 주소:");
		String address = in.nextLine();
		if(address.equals("")) {
			address = user.getAddress();
		} else {
			checkAddress(address, true);
		}
		
		System.out.print("수정 전화번호:");
		String phoneNum = in.nextLine();
		if(phoneNum.equals("")) {
			phoneNum = user.getPhoneNum();
		} else {
			checkPhoneNum(phoneNum, true);
		}
		
		
		System.out.print("수정 포인트:");
		String point = in.nextLine();
		if(point.equals("")) {
			point = user.getPoint();
		} else {
			point = inputIsNumber(point, Integer.parseInt(user.getPoint()));
		}
		
		System.out.print("수정 쿠폰:");
		String coupon = in.nextLine();
		if(coupon.equals("")) {
			coupon = user.getCoupon();
		} else {
			coupon = inputIsNumber(coupon, Integer.parseInt(user.getCoupon()));
		}
		
		
		for(User u : Data.userList) {
			if(u.getSeq().equals(seq)) {
				
				u.setName(name);
				u.setAddress(address);
				u.setPhoneNum(phoneNum);
				u.setPoint(point);
				u.setCoupon(coupon);
			
			}
		}
		
		
		System.out.println("수정이 완료되었습니다.");
		Data.updateUser();
		
		
	}

}

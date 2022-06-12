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

		String seq = String.format("%s", lastUserSeq()+1);
		
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


	public static void updateUser() {

		MenuOutput.subTitle("회원 정보 수정");
		System.out.println("수정하고 싶지 않으면 엔터를 입력해주세요");
		System.out.print("수정하려는 회원 번호:");
		String seq = in.nextLine();

		// 수정하려는 유저 정보
		MenuOutput.bar();
		User user = checkTargetUser(seq);
		
		MenuOutput.inputDataName("수정 이름");
		String name = in.nextLine();
		if(name.equals("")) {
			name = user.getName();
		} else {
			name = checkRequirement(name);
		}
		
		MenuOutput.address();
		MenuOutput.inputDataName("수정 주소");
		String address = in.nextLine();
		if(address.equals("")) {
			address = user.getAddress();
		} else {
			address = checkAddress(address, true);
		}
		
		MenuOutput.inputDataName("수정 전화번호");
		String phoneNum = in.nextLine();
		if(phoneNum.equals("")) {
			phoneNum = user.getPhoneNum();
		} else {
			phoneNum = checkPhoneNum(phoneNum, true);
		}
		
		MenuOutput.inputDataName("수정 포인트");
		String point = in.nextLine();
		if(point.equals("")) {
			point = user.getPoint();
		} else {
			point = inputIsNumber(point, Integer.parseInt(user.getPoint()));
		}
		
		MenuOutput.inputDataName("수정 쿠폰");
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
	
	public static boolean deleteUser() {

		Output.subTitle("회원 삭제");
		System.out.println("삭제를 하고 싶지 않으면 엔터를 입력해주세요");
		
		System.out.print("삭제하려는 회원 번호:");
		String seq = in.nextLine();
		
		User us = checkTargetUser(seq);
		
		MenuOutput.bar();
		System.out.println("진행하시려면 엔터를 취소하려면 0을 입력하세요");
		String input = in.nextLine();
		if(input.equals("0")) {
			return false;
		}
		
		if(us != null) {
			System.out.printf("%s님 삭제되었습니다.\n", us.getName());
			Data.userList.remove(us);
			Data.updateUser();
			Output.Waiting();
			return true;
		} else {
			System.out.println("삭제가 실패하였습니다.");
			Output.Waiting();
			return false;
		}
		
		
	}
	
	private static int lastUserSeq() {	
		return Integer.parseInt(Data.userList.get(Data.userList.size()-1).getSeq());
	}
	
	private static User checkTargetUser(String seq) {
		
		if(Integer.parseInt(seq) < 0 || Integer.parseInt(seq) > lastUserSeq()) {
			System.out.println("잘못된 입력입니다.");
			System.out.println("!다시 입력해주세요!");
			while(true) {
				seq = in.nextLine();
				System.out.println(seq);
				if(Integer.parseInt(seq) > 0 || Integer.parseInt(seq) < lastUserSeq()) break;
			}
		} 
		
		User user = null;
		for(User u : Data.userList) {
			if(u.getSeq().equals(seq)) {
				user = u;
				break;
			}
		}
		System.out.println("번호| 이름  |  전화번호  |  주소\t| 포인트 | 쿠폰 |");
		System.out.printf("%4s|%-4s|%12s|%-4s\t|%8s|%6s|\n"
								, user.getSeq()
								, user.getName()
								, user.getPhoneNum()
								, user.getAddress().substring(user.getAddress().lastIndexOf(" "))
								, user.getPoint()
								, user.getCoupon());
		
		return user;
	}

	public static String checkPhoneNum(String phoneNum, boolean flag) {
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

	
	public static String checkAddress(String address, boolean flag) {
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
				MenuOutput.address();
				System.out.println("!다시 입력해주세요!");
				address = in.nextLine();
			}
		}
		return address;
	}
	
	public static String inputIsNumber(String check, int setting) {
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


}
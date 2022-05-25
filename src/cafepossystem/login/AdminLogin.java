package cafepossystem.login;

import java.util.Scanner;
import cafepossystem.Output;
import cafepossystem.data.Data;

public class AdminLogin {

	public boolean amdinLogin() {
		
		Scanner in = new Scanner(System.in);
		
		Output.title("\t   로그인");
		Output.bar();
		System.out.print("\t  아이디:");
		String id = in.nextLine();
		
		System.out.print("\t  비밀번호:");
		String pw = in.nextLine();
		Output.bar();
		
		Data.loginAdmin(id, pw);
		
		if(Data.amdin != null) {
			System.out.println("로그인에 성공했습니다");
			return true;
		}else {
			System.out.println("로그인에 실패했습니다");
			return false;
		}
	}
	
}

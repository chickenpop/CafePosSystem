package cafepossystem.management.menu;

import java.util.Scanner;
import cafepossystem.Output;
import cafepossystem.data.Data;

public class UserMain {

	public void managementUser() {
		
		Scanner in = new Scanner(System.in);
		int currentPage = 1; // 현재 페이지
		int pageBlock = 10;  // 페이지 당 목록 수
		while(true) {
			
			System.out.println();
			System.out.println();
			MenuOutput.title("유저 관리 시스템");
			
			MenuOutput.subTitle("유저 현황");
			
			// 페이징
			int totalPage = Data.userList.size()/pageBlock + ((Data.userList.size()%pageBlock) > 0 ? 1 : 0); // 총 페이지		
			
			int currentBlock = currentPage-1;	// 현재 목록 번호
			int startNum = currentBlock*pageBlock+1;
			int endNum = currentBlock*pageBlock + pageBlock;
			
			
			// 유저 데이터 출력
			MenuOutput.bar();
			System.out.println("번호| 이름  |  전화번호  |  주소\t| 포인트 | 쿠폰 |");
			MenuOutput.bar();
			Data.userList.stream()
							.filter(u -> (Integer.parseInt(u.getSeq()) <= endNum && Integer.parseInt(u.getSeq()) >= startNum))
							.forEach(u -> {
							String address = u.getAddress().substring(u.getAddress().lastIndexOf(" "));
							System.out.printf("%4s|%-4s|%12s|%-4s\t|%8s|%6s|\n"
											, u.getSeq()
											, u.getName()
											, u.getPhoneNum()
											, address
											, u.getPoint()
											, u.getCoupon());});
			for(int i=1; i<=totalPage; i++) {
				if(i>totalPage) break;
				if(i==currentPage) System.out.printf("[%d]", i);
				else System.out.printf("|%d|", i);
			}
			System.out.println();
			MenuOutput.bar();
			System.out.println("| 회원 추가 | 회원 정보 수정 | 회원 삭제 | 뒤로가기(0)");
			MenuOutput.bar();
			System.out.println("회원정보를 변경하려면 추가, 수정, 삭제로 입력해주세요");
			System.out.println("페이지를 이동하려면 숫자를 입력해주세요");
			System.out.print("이동 번호(기능) 선택:");
			String input = in.nextLine();
			
		
			// 메뉴 기능
			if(Data.isString(input)) {
				if(input.equals("추가")) {
					
					UserCRUD.addUser();
					
				} else if(input.equals("수정")) {
					
					UserCRUD.updateUser();
					
				} else if(input.equals("삭제")) {
								
					boolean result = UserCRUD.deleteUser();
					if(result) {
						currentPage = 1;
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
	
}

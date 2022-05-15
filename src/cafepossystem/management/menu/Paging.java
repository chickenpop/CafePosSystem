package cafepossystem.management.menu;

import java.util.Scanner;
import cafepossystem.Output;
import cafepossystem.data.Data;

public class Paging {

	// 페이징
	public void pagingSample() {
		Scanner in = new Scanner(System.in);
		int currentPage = 1; // 현재 페이지
		int pageBlock = 10;  // 페이지 당 목록 수
		while(true) {

			// 페이징
			int totalPage = Data.userList.size()/pageBlock + ((Data.userList.size()%pageBlock) > 0 ? 1 : 0); // 총 페이지		
			
			int currentBlock = currentPage-1;	// 현재 목록 번호
			int startNum = currentBlock*pageBlock+1;
			int endNum = currentBlock*pageBlock + pageBlock;
			// 데이터 출력
			System.out.println("번호 | 이름 | 전화번호 | 보유 포인트 | 보유 쿠폰");
			Data.userList.stream()
							.forEach(u -> 
							System.out.printf("%s %s %s %s %s\n"
											, u.getSeq()
											, u.getName()
											, u.getPhoneNum()
											, u.getPoint()
											, u.getCoupon()));
			for(int i=1; i<=totalPage; i++) {
				if(i>totalPage) break;
				if(i==currentPage) System.out.printf("[%d]", i);
				else System.out.printf("|%d|", i);
			}
			System.out.println();
			Output.bar();
			System.out.println("| OO 추가 | OO 수정 | OO 삭제 | 뒤로가기(0)");
			Output.bar();
			System.out.println("OO를 변경하려면 추가, 수정, 삭제로 입력해주세요");
			System.out.println("페이지를 이동하려면 숫자를 입력해주세요");
			System.out.print("이동 번호(기능) 선택:");
			String input = in.nextLine();
			
		
			// 메뉴 기능
			if(Data.isString(input)) {
				if(input.equals("추가")) {
					
				} else if(input.equals("수정")) {
					
				} else if(input.equals("삭제")) {
								
					boolean result = false;
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
	} // paging sample
	
} // class

package cafepossystem.data.dummy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;

public class DummyUserData {

	public static void main(String[] args) {

		// 유저 데이터 생성용
		try {
			createUserData();
		} catch (Exception e) {
			System.out.println("DummyUserData.main");
			e.printStackTrace();
		}
		
	}
	
	private static void createUserData() throws Exception {
		
		String path = ".\\data\\userdata.txt";
		int size = 20;
		
		Random rnd = new Random();

		String si_gu = "서울 특별시 강남구";
		
		String[] dong = {"신사동", "압구정동", "청담동", "논현동", "대치동", "삼성동", "역삼동", "도곡동", "개포동", "일원동", "수서동", "자곡동", "세곡동", "율현동"};	
		String[] firstName = { "김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황", "안", "송", "전", "홍"};
		String[] lastName =  { "민", "준", "서", "도", "윤", "연", "지", "우", "현", "은", "유", "채", "수", "안", "소", "하", "영", "혁", "나", "승"};
		
		String[] number = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));
		
		for(int i=0; i<size; i++) {
			int seq = i + 1;
			
			String name = firstName[rnd.nextInt(firstName.length)]
						+ lastName[rnd.nextInt(lastName.length)]
						+ lastName[rnd.nextInt(lastName.length)];
			
			String address = si_gu + dong[rnd.nextInt(dong.length)];
			
			String phoneNum = "010" + phoneNo() + phoneNo();
			
			int point = 0;
			int coupon = 0;
			
			writer.write(String.format("%d,%s,%s,%s,%d,%d\n", seq, name, address, phoneNum, point, coupon));
		}
		
		writer.close();
		
	}

	private static String phoneNo() {
		return (int)(Math.random()*8999) + 1000 + "";
	}
}













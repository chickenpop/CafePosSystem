package cafepossystem.data.dummy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import cafepossystem.data.CoffeeMenu;
import cafepossystem.data.DataPath;

public class DummyData {

	public static void main(String[] args) {

		// 유저 데이터 생성용
		try {
			createUserData();
			//createOrderHistory();
		} catch (Exception e) {
			System.out.println("DummyUserData.main");
			e.printStackTrace();
		}
		
	}
	
	private static void createUserData() throws Exception {
		
		int size = 20;
		
		Random rnd = new Random();

		String si_gu = "서울 특별시 강남구 ";
		
		String[] dong = {"신사동", "압구정동", "청담동", "논현동", "대치동", "삼성동", "역삼동", "도곡동", "개포동", "일원동", "수서동", "자곡동", "세곡동", "율현동"};	
		String[] firstName = { "김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황", "안", "송", "전", "홍"};
		String[] lastName =  { "민", "준", "서", "도", "윤", "연", "지", "우", "현", "은", "유", "채", "수", "안", "소", "하", "영", "혁", "나", "승"};
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(DataPath.userdata));
		
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
	
private static void createOrderHistory() throws Exception {
		
		int size = 20;
		
		Random rnd = new Random();

		BufferedWriter writer = new BufferedWriter(new FileWriter(DataPath.orderhistory));
		
		BufferedReader reader = new BufferedReader(new FileReader(DataPath.coffeemenu));
		
		ArrayList<CoffeeMenu> coffeeMenuList = new ArrayList<CoffeeMenu>(10);
		
		String line = null;
		while((line = reader.readLine()) != null) {
			
			String[] temp = line.split(",");
			
			CoffeeMenu cf = new CoffeeMenu(temp[0], temp[1], Integer.parseInt(temp[2]));
			
			coffeeMenuList.add(cf);
			
		}
		
		reader.close();
		
		for(int i=0; i<size; i++) {
			
			int seq = i + 1;
		
			Calendar c = Calendar.getInstance();
			
			writer.write(String.format("%d,%d,%d,%s,%d,%d,%tF\n", seq, c));
		}
		
		writer.close();
		
	}
	
}













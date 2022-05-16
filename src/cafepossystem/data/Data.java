package cafepossystem.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Data {

	public static ArrayList<CoffeeMenu> coffeeMenuList = new ArrayList<CoffeeMenu>();
	public static ArrayList<User> userList = new ArrayList<User>();
	
	
	public static void loadCoffeeMenu() {
		
		try {

			BufferedReader reader = new BufferedReader(new FileReader(DataPath.coffeemenu));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				CoffeeMenu cf = new CoffeeMenu(temp[0], temp[1], Integer.parseInt(temp[2]));
				
				coffeeMenuList.add(cf);
				
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("Data.loadCoffeeMenu");
			e.printStackTrace();
		}
		
		
	}
	
	public static void saveCoffeeMenu() {
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(DataPath.coffeemenu));
			
			for(CoffeeMenu c : coffeeMenuList) {
				String line = String.format("%s,%s,%d\n", c.getSeq(), c.getCoffeeName(), c.getPrice());
				writer.write(line);
			}
			
			writer.close();
		} catch (Exception e) {
			System.out.println("Data.saveCoffeeMenu");
			e.printStackTrace();
		}
		
	}
	
	public static void updateMenu() {
		Data.saveCoffeeMenu();
		Data.coffeeMenuList.clear();
		Data.loadCoffeeMenu();
	}
	
	public static void loadUser() {
		
		try {

			BufferedReader reader = new BufferedReader(new FileReader(DataPath.userdata));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				User u = new User(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]);
				
				userList.add(u);
				
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("Data.loadUser");
			e.printStackTrace();
		}
		
		
	}

	public static void saveUser() {
		
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(DataPath.userdata));
			
			for(User u : userList) {
				String line = String.format("%s,%s,%s,%s,%s,%s\n"
											, u.getSeq()
											, u.getName()
											, u.getAddress()
											, u.getPhoneNum()
											, u.getPoint()
											, u.getCoupon());
				writer.write(line);
			}
			
			writer.close();
		} catch (Exception e) {
			System.out.println("Data.saveUser");
			e.printStackTrace();
		}
		
	}
	
	public static void updateUser() {
		Data.saveUser();
		Data.userList.clear();
		Data.loadUser();
	}
	
	
	public static boolean isString(String t) { 
		char[] ch = t.toCharArray();
		boolean flag = false;
		for(char c : ch) {
			if(!Character.isDigit(c)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
}

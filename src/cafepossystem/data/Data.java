package cafepossystem.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Data {

	public static ArrayList<CoffeeMenu> coffeeMenuList = new ArrayList<CoffeeMenu>();
	public static ArrayList<User> userList = new ArrayList<User>();
	public static ArrayList<OrderHistory> orderHistory = new ArrayList<OrderHistory>();
	public static ArrayList<OrderHistoryList> orderHistoryList = new ArrayList<OrderHistoryList>();
	public static Admin amdin;
	public static ArrayList<Discount> discountList = new ArrayList<Discount>();
	
	public static void loadCoffeeMenu() {
		
		try {

			BufferedReader reader = new BufferedReader(new FileReader(DataPath.coffeemenu));
			
			String line = null;
			
			coffeeMenuList.clear();
			
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
	
	public static int lastMenuSeq() {	
		return Integer.parseInt(Data.coffeeMenuList.get(Data.coffeeMenuList.size()-1).getSeq());
	}
	
	public static void loadUser() {
		
		try {

			BufferedReader reader = new BufferedReader(new FileReader(DataPath.userdata));
			
			String line = null;

			userList.clear();
			
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
	
	public static int lastUserSeq() {	
		return Integer.parseInt(Data.userList.get(Data.userList.size()-1).getSeq());
	}
	
	
	public static void loginAdmin(String id, String pw) {
		
		try {

			BufferedReader reader = new BufferedReader(new FileReader(DataPath.amdin));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				if(temp[1].equals(id) && temp[3].equals(pw)) {
					Admin ad = new Admin(temp[0], temp[1], temp[2], temp[3]);
					Data.amdin = ad;
					break;
				}				
				
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("Data.loadUser");
			e.printStackTrace();
		}
		
	}
	 
	public static void loadOrderHistory() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(DataPath.orderhistory));
			
			String line = null;
			
			orderHistory.clear();
			
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");

				
				OrderHistory o = new OrderHistory(temp[0], temp[1], temp[2]);
				
				orderHistory.add(o);
				
			}
			
			reader.close();
		} catch (Exception e) {
			System.out.println("Data.loadOrderHist");
			e.printStackTrace();
		}
	}
	
	public static void saveOrderHistoryList() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(DataPath.orderhistoryList));
			
			for(OrderHistoryList p : orderHistoryList) {
				String line = String.format("%s,%s,%s,%s,%s\n"
											, p.getSeq()
											, p.getCoffeeName()
											, p.getCoffeeNum()
											, p.getPrice()
											, p.getOrderNum());
				writer.write(line);
			}
			
			writer.close();
		} catch (Exception e) {
			System.out.println("Data.saveOrderHistoryList");
			e.printStackTrace();
		}
	}
	
	public static void loadOrderHistoryList() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(DataPath.orderhistoryList));
			
			String line = null;
			
			orderHistoryList.clear();
			
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");

				
				OrderHistoryList ohl = new OrderHistoryList(Integer.parseInt(temp[0]), temp[1], temp[2], Integer.parseInt(temp[3]), temp[4]);
				
				orderHistoryList.add(ohl);
				
			}
			
			reader.close();
		} catch (Exception e) {
			System.out.println("Data.loadOrderHistoryList");
			e.printStackTrace();
		}
	}
	
	public static void saveOrderHistory() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(DataPath.orderhistory));
			
			for(OrderHistory o : orderHistory) {
				String line = String.format("%s,%s,%s\n"
											, o.getOrderNum()
											, o.getDate()
											, o.getAdminName());
				writer.write(line);
			}
			
			writer.close();
		
		} catch (Exception e) {
			System.out.println("Data.saveUser");
			e.printStackTrace();
		}
	}
	
	

	public static void loadDiscount() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(DataPath.discountList));
			
			String line = null;
			
			discountList.clear();
			
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");

				Discount d = new Discount(temp[0], temp[1]);
				
				discountList.add(d);
				
			}
			
			reader.close();
		} catch (Exception e) {
			System.out.println("Data.loadDiscount");
			e.printStackTrace();
		}
	}

	public static void saveDiscount() {
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(DataPath.discountList));
			
			for(Discount d : discountList) {
				String line = String.format("%s,%s\n"
											, d.getOrderNum()
											, d.getDiscount());
				writer.write(line);
			}
			
			writer.close();
		
		} catch (Exception e) {
			System.out.println("Data.saveDiscount");
			e.printStackTrace();
		}
		
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

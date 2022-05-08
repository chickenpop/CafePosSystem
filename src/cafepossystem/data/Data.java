package cafepossystem.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Data {

	public static ArrayList<CoffeeMenu> coffeeMenuList = new ArrayList<CoffeeMenu>();
	
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
	
}

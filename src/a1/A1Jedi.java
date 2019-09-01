package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// count of items in the store
		int item_count = scan.nextInt();
		
		// create Item[] for inventory 
		
		Item[] inventory = new Item[item_count];
		
		// for loop to populate inventory
		for (int i = 0; i < item_count; i++) {
			
			//read item name and price
			String name = scan.next();
			double price = scan.nextDouble();
			
			//create new inventory item and append to inventory item array
			inventory[i] = new Item(0, name, price);
		}
		
		// count for # of customers
		int customer_count = scan.nextInt();
		
		// create Customer[]
		Customers[] customers = new Customers[customer_count];

		//for loop to populate Customers[]
		for(int x = 0; x < customer_count; x++) {
			
			//read customer data
			String first_name = scan.next();
			String last_name = scan.next();
			int num_items = scan.nextInt();
			
			//create array of items
			Item[] items = new Item[num_items];
			
			// for loop to read values for each customer item
			for(int a = 0; a < num_items; a++) {
				int quant = scan.nextInt();
				String item_name = scan.next();
				
				//Use the Item class constructor to create item and append it to an array of items
				items[a] = new Item(quant, item_name, 0);
			}
			//Use the Customers class constructor to create the customer object
			customers[x] = new Customers(first_name, last_name, num_items, items);
		}
		scan.close();
		
		//For loop which will print each customers output
		for(int i = 0; i < inventory.length; i++) {
			//Counter for number of customers for output
			int customers_counter = 0;
			
			//Counter for number of items for each item 
			int item_counter = 0;
			
			//for loop to populate our counters
			for(int x = 0; x < customers.length; x++) {
				for(int z = 0; z < customers[x].items.length; z++) {
					if(inventory[i].name.equals(customers[x].items[z].name)) {
						customers_counter++;
						item_counter = item_counter + customers[x].items[z].quantity;
					}
				}
			}
			
			//Initialize output variable
			String output = "";
			
			//If statement to determine proper output string format
			if(customers_counter == 0) {
				output = "No customers bought " + inventory[i].name;
			} else {
				output = customers_counter + " customers bought " + item_counter + " " + inventory[i].name;
			}
					
			//Print output
			System.out.println(output);
			
		}
	}
}

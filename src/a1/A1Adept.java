package a1;

import java.util.Scanner;

public class A1Adept {
	
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
		//Find biggest spender
		
		//create variable to store biggest spender
		Customers biggest = customers[0];
		double biggest_price = 0;
		
		//find customer[0] total
		double init_total = 0;
		for(int m = 0; m < customers[0].items.length; m++) {
			for(int n = 0; n < inventory.length; n++) {
				if(customers[0].items[m].name.equals(inventory[n].name)) {
					double item_total = customers[0].items[m].quantity * inventory[n].price;
					init_total = init_total + item_total;
				}
			}
		}
		biggest_price = init_total;
		
		//for loop to compare each customers total
		for(int z = 0; z < customers.length; z++) {
			//find customer total 
			double customer_total = 0;
			for(int m = 0; m < customers[z].items.length; m++) {
				for(int n = 0; n < inventory.length; n++) {
					if(customers[z].items[m].name.equals(inventory[n].name)) {
						double item_total = customers[z].items[m].quantity * inventory[n].price;
						customer_total = customer_total + item_total;
					}
				}
			}
			//compare customer total to current biggest
			if(customer_total > biggest_price) {
				biggest = customers[z];
				biggest_price = customer_total;
			}
		}
		
		//Find smallest spender
		Customers smallest = customers[0];
		double smallest_price = 9.05;
		
		//find customer[0] total
		double initial_total = 0;
		for(int m = 0; m < customers[0].items.length; m++) {
			for(int n = 0; n < inventory.length; n++) {
				if(customers[0].items[m].name.equals(inventory[n].name)) {
					double item_total = customers[0].items[m].quantity * inventory[n].price;
					initial_total = initial_total + item_total;
				}
			}
		}
		smallest_price = initial_total;
		
		//for loop to compare each customers total
		for(int p = 0; p < customers.length; p++) {
			//find customer total 
			double customer_total = 0;
			for(int m = 0; m < customers[p].items.length; m++) {
				for(int n = 0; n < inventory.length; n++) {
					if(customers[p].items[m].name.equals(inventory[n].name)) {
						double item_total = customers[p].items[m].quantity * inventory[n].price;
						customer_total = customer_total + item_total;
					}
				}
			}
			//compare customer total to current smallest
			if(customer_total < smallest_price) {
				smallest = customers[p];
				smallest_price = customer_total;
			}
		}
		
		//Find total
		double total = 0; 
		
		//for loop to sum total 
		for(int r = 0; r < customers.length; r++) {
			double customer_total = 0;
			for(int m = 0; m < customers[r].items.length; m++) {
				for(int n = 0; n < inventory.length; n++) {
					if(customers[r].items[m].name.equals(inventory[n].name)) {
						double item_total = customers[r].items[m].quantity * inventory[n].price;
						customer_total = customer_total + item_total;
					}
				}
			}
			total = customer_total + total;	
		}
		double avg_total = total / customers.length;
		
		//make all output values have 2 decimal places
		String output_avg_total = String.format("%.2f", avg_total);
		String output_biggest_price = String.format("%.2f", biggest_price);
		String output_smallest_price = String.format("%.2f", smallest_price);
		//print output
		String biggest_output = "Biggest: " + biggest.first_name + " " + biggest.last_name + " (" + output_biggest_price + ")";
		String smallest_output = "Smallest: " + smallest.first_name + " " + smallest.last_name + " (" + output_smallest_price + ")";
		String total_output = "Average: " + output_avg_total;
		System.out.println(biggest_output);
		System.out.println(smallest_output);
		System.out.println(total_output);
	}
}

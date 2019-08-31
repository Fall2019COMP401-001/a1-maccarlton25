package a1;

import java.util.Scanner;

public class Customers {
	String first_name;
	String last_name;
	int num_items;
	Item[] items;
	public Customers(String first, String last, int num_of_items, Item[] item_details) {
		first_name = first;
		last_name = last;
		num_items = num_of_items;
		items = item_details;
	}
}

public class Item {
	int quantity;
	String name;
	double price;
	
	public Item(int quant, String item_name, double item_price) {
		quantity = quant;
		name = item_name;
		price = item_price;
	}
}


public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		// integer that indicates the number of customers 
		
		int count = scan.nextInt(); 
		
		// create an array of customers
		
		Customers[] customers = new Customers[count];

		// for loop to read values for each customer, and create an array of customer objects containing their specific information
		for(int i = 0; i < customers.length; i++) {
			// scan customers full name and number of items
			String firstname = scan.next();
			String lastname = scan.next();
			int item_count = scan.nextInt();
			
			//create array of items
			Item[] items = new Item[item_count];
			
			// for loop to read values for each customer item
			for(int a = 0; a < item_count; a++) {
				int quant = scan.nextInt();
				String item_name = scan.next();
				double item_price = scan.nextDouble();
				
				//Use the Item class constructor to create item and append it to an array of items
				items[a] = new Item(quant, item_name, item_price);
			}
			//Use the Customers class constructor to create the customer object
			customers[i] = new Customers(firstname, lastname, item_count, items);
		}
		
		// close the scanner
		scan.close();
		
		// for loop for each customer
		for(int i =0; i<customers.length; i++) {
			// use charAt() method to get first initial of customer.
			char first_letter = customers[i].first_name.charAt(0);
			
			// create output sting with customer first initial and last name.
			String output = first_letter + ". " + customers[i].last_name + ": ";
			
			// create variable for the sum of item price
			double sum = 0;
			
			// create for loop to sum the customers purchase
			for(int a = 0; a<customers[i].items.length; a++) {
				//multiply quantity of item by price of item
				double mult = customers[i].items[a].quantity * customers[i].items[a].price;
				//add the item types price to the total sum
				sum = sum + mult;
			}
			
			// Concatenate the total price (sum) with the customers name and print the output
			String string_sum = String.format("%.2f", sum);
			output = output + string_sum;
			System.out.println(output);
		}
	}
	
}

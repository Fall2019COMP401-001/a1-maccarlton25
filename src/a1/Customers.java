package a1;

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

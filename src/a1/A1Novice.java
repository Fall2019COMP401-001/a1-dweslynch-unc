package a1;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		List<Customer> customers = new LinkedList<>();

		// Your code follows here.
		int xCustomers = scan.nextInt();

		for (int i = 0; i < xCustomers; i++)
		{
			String firstName = scan.next();
			String lastName = scan.next();
			Customer _customer = new Customer(firstName, lastName);

			int xItems = scan.nextInt(); // How many items are we purchasing?
			for (int _i = 0; _i < xItems; _i++)
			{
				int quantity = scan.nextInt();
				String itemName = scan.next();
				double itemPrice = scan.nextDouble();
				Item item = new Item(quantity, itemName, itemPrice);
				_customer.purchase(item); // Add the item to the customer's purchases
			}

			customers.add(_customer);
		}

		for (Customer customer : customers)
		{
			String firstInitial = customer.getFirstName().substring(0, 1);
			System.out.println(firstInitial + ". " + customer.getLastName() + ": " + customer.getPurchaseTotal());
		}
	}
}

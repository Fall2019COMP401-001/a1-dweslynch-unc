package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		Storefront store = new Storefront();

		int xItemsInStore = scan.nextInt(); // How many items does the store have?

		// Get item info and add to store
		for (int i = 0; i < xItemsInStore; i++)
		{
			String itemName = scan.next();
			double itemPrice = scan.nextDouble();
			store.addItem(itemName, itemPrice);
		}

		int xCustomers = scan.nextInt(); // How many customers are there?

		// Get customer info and purchases and add to store
		for (int i = 0; i < xCustomers; i++)
		{
			String firstName = scan.next();
			String lastName = scan.next();

			// Create a new customer using our pricemap
			AdeptCustomer customer = new AdeptCustomer(firstName, lastName, store.getPrices());

			int xItemsBought = scan.nextInt();

			// Add items to customer's purchase
			for (int _i = 0; _i < xItemsBought; _i++)
			{
				int quantity = scan.nextInt();
				String itemName = scan.next();
				customer.purchase(itemName, quantity);
			}

			// Add the customer to the store
			store.addCustomer(customer);
		}

		// Print results
		store.printLargestPurchase();
		store.printSmallestPurchase();
		store.printAveragePurchase();
	}
}

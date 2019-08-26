package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		Storefront store = Storefront.buildStore(scan); // Create a new store based on user input

		store.printInfoForAllItems();
	}
}

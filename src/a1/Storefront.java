package a1;

import java.util.*;
import java.util.stream.Collectors;

public class Storefront
{
    private Map<String, Double> prices;
    private List<AdeptCustomer> customers;

    public Storefront()
    {
        prices = new LinkedHashMap<>();
        customers = new LinkedList<>();
    }

    /* private helper methods */

    // Takes an item name and tells us how many were purchased
    private int quantityPurchased(String item)
    {
        int quantity = 0;
        for (AdeptCustomer _customer : customers)
        {
            quantity += _customer.quantityPurchased(item);
        }
        return quantity;
    }

    // Takes an item and tells us how many customers purchased it
    private int xCustomersWhoPurchased(String item)
    {
        int xPurchasers = 0;
        for (AdeptCustomer _customer : customers)
        {
            if (_customer.quantityPurchased(item) > 0) // They bought at least one
            {
                xPurchasers++;
            }
        }
        return xPurchasers;
    }

    // Prints out info for one specific item
    private void printInfoForItem(String item) // Print info on how many customers bought how many items
    {
        int xCustomers = xCustomersWhoPurchased(item);
        if (xCustomers > 0) // Somebody bought the item
        {
            System.out.println(xCustomers + " customers bought " + quantityPurchased(item) + " " + item);
        }
        else // Nobody bought it
        {
            System.out.println("No customers bought " + item);
        }
    }

    /* instance methods */

    // Add a new item to the inventory
    public void addItem(String name, double price)
    {
        prices.put(name, price);
    }

    // Add a new customer to the list
    public void addCustomer(AdeptCustomer customer)
    {
        customers.add(customer);
    }

    /* Accessors */

    public Map<String, Double> getPrices()
    {
        return prices;
    }
    public void printLargestPurchase() // Print info for the largest purchase
    {
        // Sort list by purchase total
        Collections.sort(customers);
        AdeptCustomer max = customers.get(customers.size() - 1); // Get the last customer in the list
        String formattedTotal = String.format("%.2f", max.getPurchaseTotal());
        System.out.println("Biggest: " + max.getFirstName() + " " + max.getLastName() + " (" + formattedTotal + ")");
    }
    public void printSmallestPurchase() // Print info for the smallest purchase
    {
        // Sort list by purchase total
        Collections.sort(customers);
        AdeptCustomer min = customers.get(0); // Get the first customer in the list
        String formattedTotal = String.format("%.2f", min.getPurchaseTotal());
        System.out.println("Smallest: " + min.getFirstName() + " " + min.getLastName() + " (" + formattedTotal + ")");
    }
    public void printAveragePurchase() // Print average purchase price
    {
        double _total = 0;
        for (AdeptCustomer customer : customers)
        {
            _total += customer.getPurchaseTotal();
        }
        double average = _total / (double)customers.size();
        System.out.println("Average: " + String.format("%.2f", average));
    }
    public void printInfoForAllItems()
    {
        for (Map.Entry<String, Double> entry : prices.entrySet())
        {
            printInfoForItem(entry.getKey());
        }
    }

    // Static constructors
    public static Storefront buildStore(Scanner scan)
    {
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
        return store;
    }
}

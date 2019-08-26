package a1;

import java.util.*;

public class Storefront
{
    private Map<String, Double> prices;
    private List<AdeptCustomer> customers;

    public Storefront()
    {
        prices = new LinkedHashMap<>();
        customers = new LinkedList<>();
    }

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

    // Accessors
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
}

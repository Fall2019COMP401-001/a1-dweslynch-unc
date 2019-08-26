package a1;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class AdeptCustomer implements Comparable<AdeptCustomer>
{
    private String firstName;
    private String lastName;

    private Map<String, Double> prices; // How much does each item cost?
    private Map<String, Integer> purchases; // How many of each item are we getting?

    public AdeptCustomer(String first, String last, Map<String, Double> _prices)
    {
        this.firstName = first;
        this.lastName = last;
        this.prices = _prices;
        purchases = new LinkedHashMap<>(); // Need to preserve order to pass tests
    }

    // Add an item to our purchases
    public void purchase(String item, int quantity)
    {
        if (purchases.containsKey(item)) // Customer has already purchased this item
        {
            int previousQuantity = purchases.get(item);
            purchases.replace(item, previousQuantity + quantity);
        }
        else // We haven't purchased this item yet
        {
            purchases.put(item, quantity);
        }
    }

    // Accessors
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }

    public double getPurchaseTotal()
    {
        double _total = 0;
        // Iterate through entries in the purchases map
        for (Map.Entry<String, Integer> entry : purchases.entrySet())
        {
            // Multiply price by quantity and add to total
            _total += prices.get(entry.getKey()) * (double)entry.getValue();
        }
        return _total;
    }

    // Interface implementation
    public int compareTo(AdeptCustomer otherCustomer)
    {
        double ourTotal = getPurchaseTotal();
        double theirTotal = otherCustomer.getPurchaseTotal();
        if (ourTotal == theirTotal)
        {
            return 0;
        }
        else if (ourTotal > theirTotal)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
}

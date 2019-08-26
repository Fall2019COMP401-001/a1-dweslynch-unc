package a1;

import java.util.LinkedList;
import java.util.List;

// Stores a customer record
public class Customer
{
    private String firstName;
    private String lastName;
    private List<Item> purchases; // List of all items purchased

    public Customer(String first, String last)
    {
        this.firstName = first;
        this.lastName = last;
        this.purchases = new LinkedList<Item>();
    }

    // Takes an item and adds it to the list of purchases
    public void purchase(Item i)
    {
        purchases.add(i);
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
        double _total = 0.0;
        for (Item i : purchases)
        {
            _total += i.getTotal();
        }
        return _total;
    }
}

package a1;

// Stores a purchase of one type of item
public class Item
{
    private int quantity;
    private String name;
    private double price;

    public Item(int _quantity, String _name, double _price)
    {
        this.quantity = _quantity;
        this.name = _name;
        this.price = _price;
    }

    // Accessors
    public int getQuantity()
    {
        return quantity;
    }
    public String getName()
    {
        return name;
    }
    public double getPrice()
    {
        return price;
    }

    // Gets the total price for the quantity of items purchased
    public double getTotal()
    {
        return price * (double)quantity;
    }
}

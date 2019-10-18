public class Item {
    String name;
    double price;
    int itemId;

    public Item(String name, double price, int itemId) {
        this.name = name;
        this.price = price;
        this.itemId = itemId;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getItemId() {
        return this.itemId;
    }
}

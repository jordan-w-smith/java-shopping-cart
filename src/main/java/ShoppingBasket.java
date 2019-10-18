import java.util.ArrayList;

public class ShoppingBasket {

    ArrayList<Item> items;

    public ShoppingBasket() {
        this.items = new ArrayList<Item>();
    }

    public int getItemsCount() {
        return this.items.size();
    }

    public void addItemToCart(Item item) {
        this.items.add(item);
    }

    public void removeItemFromCart(Item item) {
        this.items.remove(item);
    }

    public void emptyCart() {
        this.items.clear();
    }

    public double getTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void applyBogofDiscount() {

    }
}

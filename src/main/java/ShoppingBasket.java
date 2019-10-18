import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ShoppingBasket {

    ArrayList<Item> items;
    double cartTotal;

    public ShoppingBasket() {
        this.items = new ArrayList<Item>();
        this.cartTotal = 0;
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
        this.cartTotal = 0;
    }

    public double getTotal() {
        for (Item item : items) {
            cartTotal += item.getPrice();
        }
        return cartTotal;
    }

    public void applyBogofDiscount() {

        Item cheapestItem;
        double value = 100;
        for (Item item : items) {
            if (item.price < value) {
                value = item.price;
            }
        }
        cartTotal -= value;
//        Item cheapestItem;
//        for (Item item : items){
//            if (item.price < cheapestItem.price) {
//                cheapestItem = item;
//            }
//
//        }
    }
}

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

    public double calculateTotal() {
        for (Item item : items) {
            cartTotal += item.getPrice();
        }
        return cartTotal;
    }

    public double getCartTotal() {
        return this.cartTotal;
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
    }

    public void applyTenPercentDiscountToOrdersOver20() {
        double tenPercent = cartTotal / 10;
        if (cartTotal > 20) {
            cartTotal -= tenPercent;
        }
    }


    public void applyLoyaltyDiscount() {
        cartTotal -= (cartTotal / 100 * 2);
    }
}

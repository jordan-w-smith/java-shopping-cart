import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShoppingBasketTest {

    ShoppingBasket shoppingBasket;
    Item item;
    Item item2;

    @Before
    public void before() {
        shoppingBasket = new ShoppingBasket();
        item = new Item("Chicken", 5.00, 2);
        item2 = new Item("Whiteboard", 50.00, 3);
    }

    @Test
    public void hasItemList() {
        assertEquals(0, shoppingBasket.getItemsCount());
    }

    @Test
    public void canAddItemToCart() {
        shoppingBasket.addItemToCart(item);
        assertEquals(1, shoppingBasket.getItemsCount());
    }

    @Test
    public void canGetTotalItemsInCart() {
        shoppingBasket.addItemToCart(item);
        shoppingBasket.addItemToCart(item2);
        assertEquals(2, shoppingBasket.getItemsCount());
    }

    @Test
    public void canRemoveItemFromCart() {
        shoppingBasket.addItemToCart(item);
        shoppingBasket.addItemToCart(item2);
        shoppingBasket.removeItemFromCart(item);
        assertEquals(1, shoppingBasket.getItemsCount());
    }

    @Test
    public void canEmptyCart() {
        shoppingBasket.addItemToCart(item);
        shoppingBasket.addItemToCart(item2);
        shoppingBasket.emptyCart();
        assertEquals(0, shoppingBasket.getItemsCount());
    }

    @Test
    public void canGetTotalValueOfCart() {
        shoppingBasket.addItemToCart(item);
        shoppingBasket.addItemToCart(item2);
        assertEquals(55, shoppingBasket.getTotal(), 0.01);
    }

    @Test
    public void canApplyBogofDiscount() {
        shoppingBasket.addItemToCart(item);
        shoppingBasket.addItemToCart(item2);
        shoppingBasket.applyBogofDiscount();
        assertEquals(50, shoppingBasket.getTotal(), 0.01);
    }

    


}

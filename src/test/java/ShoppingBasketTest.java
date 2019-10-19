import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShoppingBasketTest {

    ShoppingBasket shoppingBasket;
    Item item;
    Item item2;
    Item item3;

    @Before
    public void before() {
        shoppingBasket = new ShoppingBasket();
        item = new Item("Chicken", 5.00, 2);
        item2 = new Item("Whiteboard", 50.00, 3);
        item3 = new Item("Gold Egg", 100, 4);
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
        assertEquals(55, shoppingBasket.calculateTotal(), 0.01);
    }

    @Test
    public void canApplyBogofDiscount() {
        shoppingBasket.addItemToCart(item);
        shoppingBasket.addItemToCart(item2);
        shoppingBasket.applyBogofDiscount();
        assertEquals(50, shoppingBasket.calculateTotal(), 0.01);
    }


    @Test
    public void canApplyTenPercentDiscountToOrdersOver20() {
        shoppingBasket.addItemToCart(item2);
        shoppingBasket.calculateTotal();
        shoppingBasket.applyTenPercentDiscountToOrdersOver20();
        assertEquals(45,shoppingBasket.getCartTotal(), 0.01);
    }

    @Test
    public void canGiveCust2PercentOffWithLoyaltyCard() {
        shoppingBasket.addItemToCart(item3);
        shoppingBasket.calculateTotal();
        shoppingBasket.applyLoyaltyDiscount();
        assertEquals(98, shoppingBasket.getCartTotal(), 0.01);
    }

    @Test
    public void allDiscountsCanBeAdded() {
        shoppingBasket.addItemToCart(item3);
        shoppingBasket.addItemToCart(item);
        shoppingBasket.calculateTotal();
        shoppingBasket.applyBogofDiscount();
        shoppingBasket.applyTenPercentDiscountToOrdersOver20();
        shoppingBasket.applyLoyaltyDiscount();
        assertEquals(88.2, shoppingBasket.getCartTotal(), 0.1);
    }

}

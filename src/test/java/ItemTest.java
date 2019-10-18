import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {
    Item item;

    @Before
    public void before() {
        item = new Item("YoYo", 10.00, 1);
    }

    @Test
    public void hasName() {
        assertEquals("YoYo", item.getName());
    }

    @Test
    public void hasPrice() {
        assertEquals(10.00, item.getPrice(), 0.01);
    }

    @Test
    public void hasItemId() {
        assertEquals(1, item.getItemId());
    }
}

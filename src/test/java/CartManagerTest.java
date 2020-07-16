import org.junit.jupiter.api.Test;
import domain.PurchaseItem;
import manager.CartManager;

import static org.junit.jupiter.api.Assertions.*;

public class CartManagerTest {
    @Test
    public void shouldAdd() {
        CartManager manager = new CartManager();

        PurchaseItem first = new PurchaseItem(1, 1, "first", 1, 1);
        PurchaseItem second = new PurchaseItem(2, 2, "second", 1, 1);
        PurchaseItem third = new PurchaseItem(3, 3, "third", 1, 1);
        PurchaseItem forth = new PurchaseItem(4, 4, "forth", 4, 4);
        manager.add(first);
        manager.add(second);
        manager.add(third);

        PurchaseItem[] actual = manager.getAll(3);
        PurchaseItem[] expected = new PurchaseItem[]{third, second, first};

        manager.add(forth);

        PurchaseItem[] actual2 = manager.getAll(4);
        PurchaseItem[] expected2 = new PurchaseItem[]{forth, third, second, first};

        assertArrayEquals(expected2, actual2);
    }

    @Test
    public void shouldGetThree() {
        CartManager manager = new CartManager();

        PurchaseItem first = new PurchaseItem(1, 1, "first", 1, 1);
        PurchaseItem second = new PurchaseItem(2, 2, "second", 1, 1);
        PurchaseItem third = new PurchaseItem(3, 3, "third", 1, 1);
        PurchaseItem forth = new PurchaseItem(4, 4, "forth", 4, 4);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);


        PurchaseItem[] actual = manager.getAll(3);
        PurchaseItem[] expected = new PurchaseItem[]{forth, third, second};

//    assertEquals(expected, actual);
        assertArrayEquals(expected, actual);
    }
}
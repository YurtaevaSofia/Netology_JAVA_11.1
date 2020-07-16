import org.junit.jupiter.api.Test;
import domain.PurchaseItem;
import manager.CartManager;

import static org.junit.jupiter.api.Assertions.*;

public class CartManagerTest {
    @Test
    public void shouldAddWhenNotEmpty() {
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
        assertArrayEquals(expected, actual);

        manager.add(forth);

        PurchaseItem[] actual2 = manager.getAll(4);
        PurchaseItem[] expected2 = new PurchaseItem[]{forth, third, second, first};

        assertArrayEquals(expected2, actual2);
    }

    @Test
    public void shouldGetThreeWhenNotEmpty() {
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


    @Test
    public void shouldAddWhenEmpty() {
        CartManager manager = new CartManager();

        PurchaseItem first = new PurchaseItem(1, 1, "first", 1, 1);

        manager.add(first);


        PurchaseItem[] actual = manager.getAll(1);
        PurchaseItem[] expected = new PurchaseItem[]{first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetWhenWasEmpty() {
        CartManager manager = new CartManager();

        PurchaseItem first = new PurchaseItem(1, 1, "first", 1, 1);

        manager.add(first);

        PurchaseItem[] actual = manager.getAll(1);
        PurchaseItem[] expected = new PurchaseItem[]{first};

//    assertEquals(expected, actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetTen() {
        CartManager manager = new CartManager();

        PurchaseItem first = new PurchaseItem(1, 1, "first", 1, 1);
        PurchaseItem second = new PurchaseItem(2, 2, "second", 1, 1);
        PurchaseItem third = new PurchaseItem(3, 3, "third", 1, 1);
        PurchaseItem forth = new PurchaseItem(4, 4, "forth", 4, 4);
        PurchaseItem fifth = new PurchaseItem(5, 5, "fifth", 1, 1);
        PurchaseItem six = new PurchaseItem(6, 6, "six", 1, 1);
        PurchaseItem sevens = new PurchaseItem(7, 7, "sevens", 1, 1);
        PurchaseItem eigth = new PurchaseItem(8, 8, "eight", 1, 1);
        PurchaseItem nine = new PurchaseItem(9, 9, "nine", 4, 4);
        PurchaseItem ten = new PurchaseItem(10, 10, "ten", 1, 1);
        PurchaseItem eleven = new PurchaseItem(11, 11, "eleven", 1, 1);
        PurchaseItem twelve = new PurchaseItem(12, 12, "twelve", 1, 1);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(six);
        manager.add(sevens);
        manager.add(eigth);
        manager.add(nine);
        manager.add(ten);
        manager.add(eleven);
        manager.add(twelve);

        PurchaseItem[] actual = manager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{twelve ,eleven,ten, nine, eigth, sevens, six, fifth, forth, third};
        assertArrayEquals(expected, actual);


    }


}
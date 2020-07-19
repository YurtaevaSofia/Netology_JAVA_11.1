import domain.PurchaseItem;
import manager.AfishaManager;
import org.junit.jupiter.api.Test;
import repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AfishaRepositoryTest {
    @Test
    public void shouldAddWhenNotEmpty() {
        AfishaRepository repository = new AfishaRepository();

        PurchaseItem first = new PurchaseItem(1, 1, "first", 1, 1);
        PurchaseItem second = new PurchaseItem(2, 2, "second", 1, 1);
        PurchaseItem third = new PurchaseItem(3, 3, "third", 1, 1);
        PurchaseItem forth = new PurchaseItem(4, 4, "forth", 4, 4);
        repository.save(first);
        repository.save(second);
        repository.save(third);

        PurchaseItem[] actual = repository.findAll();
        PurchaseItem[] expected = new PurchaseItem[]{first, second, third};
        assertArrayEquals(expected, actual);

        repository.save(forth);

        PurchaseItem[] actual2 = repository.findAll();
        PurchaseItem[] expected2 = new PurchaseItem[]{first, second, third, forth};

        assertArrayEquals(expected2, actual2);
    }

    @Test
    public void shouldGetThreeWhenNotEmpty() {
        AfishaRepository repository = new AfishaRepository();
        AfishaManager manager = new AfishaManager(repository);

        PurchaseItem first = new PurchaseItem(1, 1, "first", 1, 1);
        PurchaseItem second = new PurchaseItem(2, 2, "second", 1, 1);
        PurchaseItem third = new PurchaseItem(3, 3, "third", 1, 1);
        PurchaseItem forth = new PurchaseItem(4, 4, "forth", 4, 4);
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(forth);


        PurchaseItem[] actual = manager.getAll(3);
        PurchaseItem[] expected = new PurchaseItem[]{forth, third, second};

//    assertEquals(expected, actual);
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldAddWhenEmpty() {
        AfishaRepository repository = new AfishaRepository();


        PurchaseItem first = new PurchaseItem(1, 1, "first", 1, 1);

        repository.save(first);


        PurchaseItem[] actual = repository.findAll();
        PurchaseItem[] expected = new PurchaseItem[]{first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetWhenWasEmpty() {
        AfishaRepository repository = new AfishaRepository();

        PurchaseItem first = new PurchaseItem(1, 1, "first", 1, 1);

        repository.save(first);

        PurchaseItem[] actual = repository.findAll();
        PurchaseItem[] expected = new PurchaseItem[]{first};

//    assertEquals(expected, actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetTen() {
        AfishaRepository repository = new AfishaRepository();

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
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(forth);
        repository.save(fifth);
        repository.save(six);
        repository.save(sevens);
        repository.save(eigth);
        repository.save(nine);
        repository.save(ten);
        repository.save(eleven);
        repository.save(twelve);

        PurchaseItem[] actual = repository.findAll();
        PurchaseItem[] expected = new PurchaseItem[]{twelve, eleven, ten, nine, eigth, sevens, six, fifth, forth, third};
        assertArrayEquals(expected, actual);


    }
}



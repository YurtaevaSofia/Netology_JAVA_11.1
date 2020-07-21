import domain.Film;
import manager.AfishaManager;
import org.junit.jupiter.api.Test;
import repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AfishaRepositoryTest {
    @Test
    public void shouldAddWhenNotEmpty() {
        AfishaRepository repository = new AfishaRepository();

        Film first = new Film(1, 1, "first", 1, 1);
        Film second = new Film(2, 2, "second", 1, 1);
        Film third = new Film(3, 3, "third", 1, 1);
        Film forth = new Film(4, 4, "forth", 4, 4);
        repository.save(first);
        repository.save(second);
        repository.save(third);

        Film[] actual = repository.findAll();
        Film[] expected = new Film[]{first, second, third};
        assertArrayEquals(expected, actual);

        repository.save(forth);

        Film[] actual2 = repository.findAll();
        Film[] expected2 = new Film[]{first, second, third, forth};

        assertArrayEquals(expected2, actual2);
    }

    @Test
    public void shouldGetThreeWhenNotEmpty() {
        AfishaRepository repository = new AfishaRepository();
        AfishaManager manager = new AfishaManager(repository, 3);

        Film first = new Film(1, 1, "first", 1, 1);
        Film second = new Film(2, 2, "second", 1, 1);
        Film third = new Film(3, 3, "third", 1, 1);
        Film forth = new Film(4, 4, "forth", 4, 4);
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(forth);


        Film[] actual = manager.getAll();
        Film[] expected = new Film[]{forth, third, second};

//    assertEquals(expected, actual);
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldAddWhenEmpty() {
        AfishaRepository repository = new AfishaRepository();


        Film first = new Film(1, 1, "first", 1, 1);

        repository.save(first);


        Film[] actual = repository.findAll();
        Film[] expected = new Film[]{first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetWhenWasEmpty() {
        AfishaRepository repository = new AfishaRepository();

        Film first = new Film(1, 1, "first", 1, 1);

        repository.save(first);

        Film[] actual = repository.findAll();
        Film[] expected = new Film[]{first};

//    assertEquals(expected, actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetTen() {
        AfishaRepository repository = new AfishaRepository();

        Film first = new Film(1, 1, "first", 1, 1);
        Film second = new Film(2, 2, "second", 1, 1);
        Film third = new Film(3, 3, "third", 1, 1);
        Film forth = new Film(4, 4, "forth", 4, 4);
        Film fifth = new Film(5, 5, "fifth", 1, 1);
        Film six = new Film(6, 6, "six", 1, 1);
        Film sevens = new Film(7, 7, "sevens", 1, 1);
        Film eigth = new Film(8, 8, "eight", 1, 1);
        Film nine = new Film(9, 9, "nine", 4, 4);
        Film ten = new Film(10, 10, "ten", 1, 1);
        Film eleven = new Film(11, 11, "eleven", 1, 1);
        Film twelve = new Film(12, 12, "twelve", 1, 1);
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

        Film[] actual = repository.findAll();
        Film[] expected = new Film[]{twelve, eleven, ten, nine, eigth, sevens, six, fifth, forth, third};
        assertArrayEquals(expected, actual);


    }
}



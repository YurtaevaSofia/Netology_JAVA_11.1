import domain.Film;
import manager.AfishaManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerTest {
    @Mock
    AfishaRepository repository;
    @InjectMocks
    AfishaManager manager;

    private Film first = new Film(1, 1, "first", 1, 1);
    private Film second = new Film(2, 2, "second", 1, 1);
    private Film third = new Film(3, 3, "third", 1, 1);

    @BeforeEach
    public void setUp() {

        repository.save(first);
        repository.save(second);
        repository.save(third);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;

        Film[] returned = new Film[]{second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        repository.removeById(idToRemove);
        Film[] expected = new Film[]{second, third};
        Film[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

        verify(repository).removeById(idToRemove);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;
        Film[] returned = new Film[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        repository.removeById(idToRemove);
        Film[] expected = new Film[]{first, second, third};
        Film[] actual = repository.findAll();

        assertArrayEquals(expected, actual);

        verify(repository).removeById(idToRemove);
    }
}


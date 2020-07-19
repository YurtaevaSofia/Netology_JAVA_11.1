import domain.PurchaseItem;
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
    AfishaRepository repository = mock(AfishaRepository.class);
    @InjectMocks
    AfishaManager manager;

    private PurchaseItem first = new PurchaseItem(1, 1, "first", 1, 1);
    private PurchaseItem second = new PurchaseItem(2, 2, "second", 1, 1);
    private PurchaseItem third = new PurchaseItem(3, 3, "third", 1, 1);

    @BeforeEach
    public void setUp() {

        repository.save(first);
        repository.save(second);
        repository.save(third);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;

        PurchaseItem[] returned = new PurchaseItem[]{second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        repository.removeById(idToRemove);
        PurchaseItem[] expected = new PurchaseItem[]{second, third};
        PurchaseItem[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

        verify(repository).removeById(idToRemove);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;
        PurchaseItem[] returned = new PurchaseItem[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        repository.removeById(idToRemove);
        PurchaseItem[] expected = new PurchaseItem[]{first, second, third};
        PurchaseItem[] actual = repository.findAll();

        assertArrayEquals(expected, actual);

        verify(repository).removeById(idToRemove);
    }
}


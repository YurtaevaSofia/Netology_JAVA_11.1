package manager;

import domain.PurchaseItem;
import repository.AfishaRepository;

public class AfishaManager {
    private AfishaRepository repository;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public void add(PurchaseItem item) {

        repository.save(item);
    }

    public PurchaseItem[] getAll() {
        PurchaseItem[] items = repository.findAll();
        PurchaseItem[] result = new PurchaseItem[10];

        for (int i = 0; i < 10; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public PurchaseItem[] getAll(int numberOfItems) {

        PurchaseItem[] items = repository.findAll();
        PurchaseItem[] result = new PurchaseItem[numberOfItems];

        for (int i = 0; i < numberOfItems; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public void removeById (int id){
        repository.removeById(id);
    }

}

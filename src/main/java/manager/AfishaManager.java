package manager;

import domain.Film;
import repository.AfishaRepository;

public class AfishaManager {
    private AfishaRepository repository;
    private int numberOfItems = 10;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public AfishaManager() {
    }

    public AfishaManager(AfishaRepository repository, int numberOfItems) {
        this.repository = repository;
        this.numberOfItems = numberOfItems;
    }

    public AfishaManager(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }


    public void add(Film item) {

        repository.save(item);
    }


    public Film[] getAll() {

        Film[] items = repository.findAll();
        Film[] result = new Film[numberOfItems];

        if (items.length > numberOfItems){
        for (int i = 0; i < numberOfItems; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
        }
        else return items;
    }

    public void removeById (int id){
        repository.removeById(id);
    }

}

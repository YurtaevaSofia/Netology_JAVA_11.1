package repository;

import domain.Film;

public class AfishaRepository {

    private Film[] items = new Film[0];

    public void save(Film item) {
        int length = items.length + 1;
        Film[] tmp = new Film[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Film[] findAll() {
        if (items.length > 10){
        Film[] result = new Film[10];

        for (int i = 0; i < 10; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;}

        else return items;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        Film[] tmp = new Film[length];
        int index = 0;
        for (Film item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public  void removeAll (){
        Film[] tmp = new Film[0];
        items = tmp;
    }

    public Film findById(int id) {
        for (Film film: items) {
            if (film.getId() == id) {
                return  film;
            }
        }
        return null;


    }
}

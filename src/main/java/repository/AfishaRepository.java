package repository;

import domain.PurchaseItem;

public class AfishaRepository {

    private PurchaseItem[] items = new PurchaseItem[0];

    public void save(PurchaseItem item) {
        int length = items.length + 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public PurchaseItem[] findAll() {
        if (items.length > 10){
        PurchaseItem[] result = new PurchaseItem[10];

        for (int i = 0; i < 10; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;}

        else return items;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        int index = 0;
        for (PurchaseItem item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public  void removeAll (){
        PurchaseItem [] tmp = new PurchaseItem[0];
        items = tmp;
    }

    public PurchaseItem findById(int id) {
        boolean flag = false;
        PurchaseItem neededItem = new PurchaseItem();
        for (PurchaseItem item : items) {
            if (item.getId() == id) {
                neededItem = item;
                flag = true;
            }}
            if (flag) return neededItem;
            else return  null;


    }
}

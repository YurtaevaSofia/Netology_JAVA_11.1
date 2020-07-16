package manager;

import domain.PurchaseItem;

public class CartManager {
    private PurchaseItem[] items = new PurchaseItem[0];

    public void add(PurchaseItem item) {

        int length = items.length + 1;
        PurchaseItem[] tmp = new PurchaseItem[length];

        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public PurchaseItem[] getAll() {
        PurchaseItem[] result = new PurchaseItem[10];

        for (int i = 0; i < 10; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public PurchaseItem[] getAll(int numberOfItems) {
        PurchaseItem[] result = new PurchaseItem[numberOfItems];

        for (int i = 0; i < numberOfItems; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

}

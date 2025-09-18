package pojo.generic;

public class Cup<T extends Beverage> {
    T item;

    public T getItem() {
        return item;
    }

    public void addItem(T item) {
        this.item = item;
    }
}



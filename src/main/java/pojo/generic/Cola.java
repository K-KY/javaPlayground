package pojo.generic;

public class Cola implements Beverage {
    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}

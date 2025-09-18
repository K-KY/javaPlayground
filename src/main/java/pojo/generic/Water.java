package pojo.generic;

public class Water implements Beverage{
    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}

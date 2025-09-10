package pojo.object_equality;

public class YourCar extends Car {
    private final String owner;

    public YourCar(String carName, String brand, String carType, String owner) {
        super(carName, brand, carType);
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }
}

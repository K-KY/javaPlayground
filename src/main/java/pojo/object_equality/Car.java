package pojo.object_equality;

import java.util.Objects;

public class Car {
    private final String carName;
    private final String brand;
    private final String carType;

    public Car(String carName, String brand, String carType) {
        this.carName = carName;
        this.brand = brand;
        this.carType = carType;
    }

    protected String carName() {
        return carName;
    }

    protected String brand() {
        return brand;
    }

    protected String carType() {
        return carType;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("o.getClass().getName() = " + o.getClass().getName());
        System.out.println("getClass().getName() = " + getClass().getName());
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carName, car.carName) && Objects.equals(brand, car.brand) && Objects.equals(carType, car.carType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, brand, carType);
    }
}

package pojo.object_equality;

import ch.qos.logback.core.pattern.FormatInfo;

public class MyCar extends Car {
    private final String owner;
    public MyCar(String carName, String brand, String carType, String owner) {
        super(carName, brand, carType);
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }
}

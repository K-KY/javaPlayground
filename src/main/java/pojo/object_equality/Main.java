package pojo.object_equality;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Car myCar = new MyCar("봉고", "기아", "승용차", "나");
        Car yourCar = new YourCar("봉고", "기아", "승용차", "나");


        //equals를 재정의 했으나 false가 나온다.
        System.out.println("myCar.equals(yourCar) = " + myCar.equals(yourCar));
        System.out.println("Objects.equals(myCar, yourCar) = " + Objects.equals(myCar, yourCar));

    }
}

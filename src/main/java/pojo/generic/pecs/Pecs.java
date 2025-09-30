package pojo.generic.pecs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pecs {
    public static void main(String[] args) {
        List<? extends Animal> zooProducer = Arrays.asList(new Animal(), new Cat(), new Dog());
        Animal animal = zooProducer.get(0);
//        Dog dog = zooProducer.get(0); animal 을 상속한 어떤 타입이 나올지 모름
//        zooProducer.add(animal); 안에 어떤 타입이 들어있을지 모르니 아무거나 못넣음

        List<? super Animal> zooConsumer = new ArrayList<>(Arrays.asList(new Animal(), new Cat(), new Dog()));
        zooConsumer.add(new Dog());
        zooConsumer.add(new HotDog()); // 상속 하기만 했으면 아무거나 들어감
        Object o = zooConsumer.get(1); // 상속한거 아무거나 다 들어가서 무슨타입인지 모름
//        zooProducer.add(o);
        //Animal을 상속 한거면 Animal 타입으로 받으면 안되나?
        Animal animal1 = (Animal) o; // 이건 가능
        Cat animal2 = (Cat) animal1;// 이거도 되는데 실제 꺼내진 값이 캐스팅 된 타입 이어야함
//        zooConsumer.add(new Creature()); //Animal이 Creature를 상속 했다고 해서 리스트에 넣는건 불가

    }

}

class Creature {
}

class Animal extends Creature {

}

class Dog extends Animal {
}

class HotDog extends Dog {
}

class Cat extends Animal {
}


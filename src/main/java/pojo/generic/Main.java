package pojo.generic;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cola cola = new Cola();
        Water water = new Water();
        Cup<Beverage> cup = new Cup<>();
        cup.addItem(cola);
        List<Beverage> bev = new ArrayList<>();
        bev.add(new Water());


        Beverage item = cup.getItem();
        System.out.println(item.getName());

        cup.addItem(water);

        Beverage item2 = cup.getItem();
        System.out.println(item2.getName());


        Cup<Cola> cup2 = new Cup<>();

        cup2.addItem(cola);
        Beverage item3 = cup2.getItem();
        System.out.println(item3.getName() + "ggg");

        ArrayList<Beverage> beverages = new ArrayList<>();
        beverages.add(cola);
        beverages.add(water);

        for (Beverage beverage : beverages) {
            System.out.println("Main.main.array");
            System.out.println(beverage.getName());
        }


        ArrayList<Water> waters = new ArrayList<>();
        waters.add(water);

        for (Beverage beverage : beverages) {
            System.out.println("Main.main.water");
        }

        ArrayList<Cola> colas = new ArrayList<>();
        colas.add(cola);
        for (Beverage beverage : colas) {
            System.out.println("Main.main.cola");
        }
        generics(beverages);


        printer("Main.main.generic");
        printer(123123);
        printer(0.4);
    }

    public static void generics(ArrayList<? extends Beverage> list) {//특정 타입을 상속받은 클래스만
        System.out.println("Main.generics");
//        list.add(new Cola()); 어떤 하위타입인지 몰라서 못넣음
        for (Beverage beverage : list) {
            System.out.println(beverage.getName());
        }
    }

    public static void generics2(ArrayList<? super Beverage> list) {//
        list.add(new Cola());
        list.add(new Water());
//        list.add(new Integer(1));
        Object object = list.get(0); // 무슨타입 나올지 몰라서 Object로만 받을 수 있음

    }

    public static <T> void printer(T value) {//어떤 타입이든 받아서 출력
        System.out.println(value);
    }


    public static <T> void utilPrinter(T value) {

    }
}

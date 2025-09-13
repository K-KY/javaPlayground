package pojo.thread.first;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        //Runnable을 구현한 클래스
        RunnableThread task = new RunnableThread("runnableThread" + 1);
        Thread runnableThread = new Thread(task);
//        runnableThread.run(); // 이건 그냥 메소드 호출
        runnableThread.start();

        //쓰레드를 상속한 클래스
        ExtendsThread extendsThread = new ExtendsThread("extendsThread" + 1);
        extendsThread.start();


        //못생김 권장하지 않음
        Thread tread = new Thread(() -> {
            while (true) {
            System.out.println("Main.main : Lambda thread" + 1);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        tread.start();


    }

}
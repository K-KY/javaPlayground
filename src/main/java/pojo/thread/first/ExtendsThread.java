package pojo.thread.first;

public class ExtendsThread extends Thread {

    private final String name;

    public ExtendsThread(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        while (true) {
        System.out.println("ExtendsThread.run : " + name);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

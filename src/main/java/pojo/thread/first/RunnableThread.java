package pojo.thread.first;

public class RunnableThread implements Runnable {
    private final String name;

    public RunnableThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("RunnableThread.run : " + name);

            try {
                Thread.sleep(500);//슬립이 없어도 쓰레드는 타임 슬라이스로 번갈아가며 CPU 자원을 가져감
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

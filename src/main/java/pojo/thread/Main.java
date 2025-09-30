package pojo.thread;

import java.util.concurrent.CountDownLatch;

public class Main {
    private static int count = 0; // 공유 자원

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 100;
        int iterations = 10000;

        CountDownLatch latch = new CountDownLatch(threadCount);

        // 10개의 스레드가 동시에 count++ 실행
        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                for (int j = 0; j < iterations; j++) {
                    count++; // 원자적이지 않음 (race condition 발생 가능)
                }
                latch.countDown();
            }).start();
        }

        // 모든 스레드 종료 대기
        latch.await();

        System.out.println("Expected count = " + (threadCount * iterations));
        System.out.println("Actual count   = " + count);
    }

}

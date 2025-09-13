# 쓰레드

## 쓰레드의 사용

### Runnable
- Runnable을 사용해서 쓰레드를 실행 할 수 있다.
- Runnable이 쓰레드인건 아니고 쓰레드가 실행할 작업을 구현 해놓는것
- > Thread t = new Tread(new RunnableImpl());
  - 이렇게 사용한다.

### Extends
- `Tread` 클래스를 상속하여 run 메서드를 재정의 해서 실행 할 수 있다.
    - 코드 생략

### Lambda
- 람다식으로 Runnable을 구현한다.
  - 이건 생긴거 보니 권장되는 패턴은 아닌거같고 그냥 이렇게 할수 있겠는데? 싶어서 해본거
```
        Thread tread = new Thread(() -> {})
```

## 쓰레드는 어떻게 전부 실행되나

```java
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
```
- 나는 이렇게 쓰레드 안에 무한루프 메서드를 만들어놨다.
- 근데 어떻게 다른 쓰레드가 실행이 되나?
```java
        extendsThread.start();
```
- run 메서드를 재정의 했지만 호출하는건 `run`이 아니라 `start`다.
  - `run`을 호출했으면 그냥 무한루프
- start()
  - 이건 `run`을 호출하는게 아니라 새로운 실행 단위를 **운영체제에 등록하는** 동작
    - 자바의 쓰레드는 사용자 레벨 쓰레드가 아닌가?

### 자바의 쓰레드

1. 자바는 실제 커널 쓰레드와 연결됨
   - 옛날에는 사용자 레벨 쓰레드였으나 쓰레드 하나가 블락 당하면 전체가 블락당하는 단점이 있었음
   - 현대의 JVM은 커널 쓰레드와 1:1 매핑한다.
     - `tread.start()` 는 OS커널에 네이티브 쓰레드를 요청 -> 거기에 JVM이 Tread객체를 올려놓고 사용
     - 따라서 자바의 쓰레드는 운영체제가 관리한다.
     - 1:1 연결로 쓰레드의 독립성을 얻었으니 단점도 존재
     - 
2. 사용자 레벨 쓰레드의 빠른 컨텍스트 스위칭
   - 사용자 레벨 쓰레드의 장점은 커널 개입이 없어 빠른 컨텍스트 스위칭이 가능하다는것
   - 그러나 자바는 이런 모델을 사용하지 않는다
   - 컨텍스트 스위칭 비용은 사용자 레벨 쓰레드보다 높음
     - 그러나 `Tread`가 블락되어 JVM전체가 멈춰버리는 문제점 해결
       - 병렬 실행과 블로킹 시스템콜에 독립적

3. 진짜 사용자 레벨 쓰레드는 `VirtualTread`
   - 이건 모르는 내용임 나중에 찾아서 정리할 예정
   - 그냥 느낌상 그런거 같아서 일단 적어봄

------------
00000000000
------------
------------
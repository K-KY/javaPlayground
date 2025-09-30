# pecs principle
- producer - extends, consumer - super

- 컬랙션에서 꺼낸다 -> 생산자 -> extends
- 컬랙션에 넣는다 -> 소비자 -> super

## 어떤 차이가 있나

### 의미
- ? extends T
- 상한 경계 와일드카드
    - 필드 또는 리스트 안에 T이거나 T하위 임을 보장 
    - 그러나 읽기 전용 이므로 새로운 값을 넣는건 불가능
    - `꺼낼 때 최소 T 타입으로 사용 가능`
    - 여기 있는건 T 타입이다.
- ? super T
  - 하한 경계 와일드카드
    - 필드 또는 리스트 안에 T또는 T의 상위 클래스가 들어있을 수 있음
    - 그러나 안전하게 add 가능한건 T또는 T의 하위 클래스
    ````
    class Creature {}
    class Animal extends Creature {}
    class Dog extends Animal {}

    List<Creature> creatures = new ArrayList<>();

    public void t(List<? super Animal> list) {}
    ````
    - 넣을 때 T 타입일걸 보장
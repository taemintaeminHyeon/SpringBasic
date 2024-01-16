package hello.example.core.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }



    private SingletonService() { // 다른 객체가 생기는 것을 막는다 private

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}

package hello.example.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA : A사용자 10000원 주문
        //statefulService1.order("userA",10000);
        int userAPrice = statefulService1.order("userA",10000); // -> 지역변수 사용
        //ThreadB : B사용자 20000원 주문
        //statefulService2.order("userB",20000);
        int userBPrice = statefulService1.order("userB",20000); // -> 지역변수 사용


        //ThreadA : 사용자 A 주문 금액 조회
        //int price = statefulService1.getPrice();
        System.out.println("price = " + userAPrice); //20000원 찍힘  -> 공유 하기 때문

       // Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }

    }

}
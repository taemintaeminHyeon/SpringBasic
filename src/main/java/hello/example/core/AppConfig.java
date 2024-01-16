package hello.example.core;

import hello.example.core.discount.DiscountPolicy;
import hello.example.core.discount.FixDiscountPolicy;
import hello.example.core.discount.RateDiscountPolicy;
import hello.example.core.member.MemberRepository;
import hello.example.core.member.MemberService;
import hello.example.core.member.MemberServiceImpl;
import hello.example.core.member.MemoryMemberRepository;
import hello.example.core.order.OrderService;
import hello.example.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    // @Bean memberService - > new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository()); // 생성자를 통해 구현체 선택 (의존관계 주입)
    }
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(
                memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        System.out.println("call AppConfig.discountPolicy");
        return new RateDiscountPolicy();
    }




}

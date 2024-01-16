package hello.example.core.discount;

import hello.example.core.member.Grade;
import hello.example.core.member.Member;

public class FixDiscountPolicy  implements DiscountPolicy{

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {

        if (member.getGrade() == Grade.VIP){ // enum 타입은 == 로 비교
            return discountFixAmount;
        }
        else {
            return 0;
        }
    }
}

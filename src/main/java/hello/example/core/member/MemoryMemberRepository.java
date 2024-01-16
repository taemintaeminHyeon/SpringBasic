package hello.example.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); // 동시성 이슈 발생 가능
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findByID(Long memberId) {
        return store.get(memberId);
    }
}

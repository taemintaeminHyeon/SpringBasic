package hello.example.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;


    public MemberServiceImpl(MemberRepository memberRepository) { // 구현체에 대한 코드는 없고 인터페이스에 대한 코드만 있어 DIP 만족
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findByID(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

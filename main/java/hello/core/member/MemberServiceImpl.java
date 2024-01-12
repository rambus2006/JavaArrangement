package hello.core.member;

public class MemberServiceImpl implements MemberService{
    //인터페이스 구현
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    @Override
    public void join(Member member){
        memberRepository.save(member);
    }
    @Override
    public Member findMember(Long memberId){
        return memberRepository.findById(memberId);
    }

}

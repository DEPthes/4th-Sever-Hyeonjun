package shoping.study.spring.MyShopingMall.service;

import shoping.study.spring.MyShopingMall.Entity.Member;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shoping.study.spring.MyShopingMall.repository.MemberRepository;

import java.util.List;

@Service
@Transactional
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public Long join(Member member){
        vaildateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void vaildateDuplicateMember(Member member){
        List<Member> members = memberRepository.findByName(member.getName());
        if(!members.isEmpty())
        {
            throw new IllegalStateException("이미 존재하는 회원입니다!!");
        }
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }
}

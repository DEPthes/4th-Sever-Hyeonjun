package hello.hello_spring.controller;

import hello.hello_spring.domain.Member;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller    //스프링 컨테이너라는 통이 스프링을 실행하면 생기게  됨 거기에 Controller가 등록되게됨
public class MemberController {
    //원래는 다음과 같이 사용했음 but 스프링을 사용하게 되면 스프링 컨테이너로 부터 받아서 사용하는것으로 바꿔야함
    //MemberService객체가 특별한 기능이 없기에 하나만 생성해서 사용해도 충분하다.
    // private final MemberService service = new MemberService();
    // 이러한 행위를 DI(의존성 주입(Dependency Injection))
    //스프링 빈을 등록시키는 방법
    // 1. 컴포넌트 스캔 방식 (현재 우리가 다룬 방식) @Component
    // 2. 자바코드를 이용해서 직접
    // hello.hello_spring파일(HelloSpringApplication) 내에 위치한 자바 파일에 컴포넌트 어노테이션을 인식해서 스프링빈을 등록함

    //그냥 아래와 같이 하면 오류가 난다 왜? service class가 springbeen에 등록되지 않았기때문에. 어노테이션을 이용해서 컨테이너에 등록해야한다.

    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/signup")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form)
    {
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);

        return "redirect:/";
    }
    @GetMapping("members")
    public String list(Model model)
    {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }

}

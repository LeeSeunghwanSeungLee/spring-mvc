package hello.servlet.web.springmvc.v1;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SpringMemberListControllerV1 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/springmvc-v1/members")
    public ModelAndView process() {
        List<Member> members = memberRepository.findAll();

        String viewName = "memberes";
        ModelAndView mv = new ModelAndView(viewName); // Response Resolver가 알아서 해결해준다.
        mv.addObject("members", members);
        return mv;
    }
}

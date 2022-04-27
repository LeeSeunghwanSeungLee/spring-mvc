package hello.login.web;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberRepository memberRepository;

//    @GetMapping("/")
    public String home() {
        return "home";
    }

//    @GetMapping("/")
    public String homeLogin(@CookieValue(name = "memberId", required = false) Long memberId, Model model) {
        if (memberId == null)
            return "home";

        // login
        Member loginMember = memberRepository.findById(memberId);
        if (loginMember == null)
            return "home";

        model.addAttribute("member", loginMember);
        return "loginHome";
    }

    public String homeLoginV2(HttpServletRequest reuqest, Model, model) {
        // 세션 관리자에 의해 저장된 회원 정보 조회
    }
}
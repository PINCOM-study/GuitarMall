package PINCOM.GuitarMall.member.controller;

import PINCOM.GuitarMall.member.dto.MemberDto;
import PINCOM.GuitarMall.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("")
    public String homeGET(Model model, HttpServletRequest req) {

        HttpSession session = req.getSession();
        model.addAttribute("username", session.getAttribute("loginInfo"));

        return "main";
    }

    @GetMapping("login")
    public void loginGET() {}

    @PostMapping("login")
    public String loginPOST(MemberDto memberDto, RedirectAttributes re,
                            HttpServletRequest req, @RequestParam(defaultValue = "/") String redirectURL) {

        // 로그인 성공 여부 메세지
        String message = memberService.login(memberDto);
        if (message.equals("username")) {   // 아이디 오류
            message = "아이디가 없습니다";
        }
        else if (message.equals("password")) {  // 비밀번호 오류
            message = "비밀번호가 틀립니다";
        }
        else {  // 로그인 성공
            message = "로그인 성공!";
            HttpSession session = req.getSession();
            session.setAttribute("loginInfo", memberDto.getUsername());
        }

        // 로그인 성공 여부 메세지 전송
        re.addFlashAttribute("message", message);

        return "redirect:" + redirectURL;
    }

    @GetMapping("join")
    public void joinGET() {}

    @PostMapping("join")
    public String joinPOST(MemberDto memberDto, RedirectAttributes re) {
        log.debug("memberDto = " + memberDto);
        String username = memberService.join(memberDto);

        re.addFlashAttribute("username", username);

        return "redirect:/login";
    }
}

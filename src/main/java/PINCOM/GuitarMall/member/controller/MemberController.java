package PINCOM.GuitarMall.member.controller;

import PINCOM.GuitarMall.member.dto.MemberDto;
import PINCOM.GuitarMall.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class MemberController {

    //test용 주석
    private final MemberService memberService;

    @GetMapping("")
    public String homeGET() {
        return "main";
    }

    @GetMapping("login")
    public void loginGET() {}

    @PostMapping("login")
    public String loginPOST(MemberDto memberDto, RedirectAttributes re) {

        re.addFlashAttribute("username", memberDto.getUsername());

        String message = memberService.login(memberDto);
        re.addFlashAttribute("message", message);

        return "redirect:/";
    }

    @GetMapping("join")
    public void joinGET() {}

    @PostMapping("join")
    public String joinPOST(MemberDto memberDto, RedirectAttributes re) {
        System.out.println("memberDto = " + memberDto);
        String username = memberService.join(memberDto);

        re.addFlashAttribute("username", username);

        return "redirect:/login";
    }
}

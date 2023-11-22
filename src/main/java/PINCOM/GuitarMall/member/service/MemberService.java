package PINCOM.GuitarMall.member.service;

import PINCOM.GuitarMall.member.dto.MemberDto;
import PINCOM.GuitarMall.member.model.Member;
import PINCOM.GuitarMall.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public String join(MemberDto memberDto) {
        Member member = Member.builder()
                .username(memberDto.getUsername())
                .password(memberDto.getPassword())
                .email(memberDto.getEmail())
                .build();

        return memberRepository.save(member).getUsername();
    }

    @Transactional(readOnly = true)
    public String login(MemberDto memberDto) {
        Optional<Member> member = memberRepository.findById(memberDto.getUsername());
        if (member.isEmpty()) return "아이디가 없습니다";
        if (member.get().getPassword().equals(memberDto.getPassword())) return "로그인 성공!";
        else return "비밀번호가 틀립니다";
    }
}

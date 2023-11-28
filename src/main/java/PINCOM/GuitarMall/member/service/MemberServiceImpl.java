package PINCOM.GuitarMall.member.service;

import PINCOM.GuitarMall.member.dto.MemberDto;
import PINCOM.GuitarMall.member.model.Member;
import PINCOM.GuitarMall.member.repository.MemberRepository;
import PINCOM.GuitarMall.member.security.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public String join(MemberDto memberDto) {
        String encodedPassword = passwordEncoder.encode(memberDto.getEmail(), memberDto.getPassword());
        Member member = Member.builder()
                .username(memberDto.getUsername())
                .password(encodedPassword)
                .email(memberDto.getEmail())
                .build();

        return memberRepository.save(member).getUsername();
    }

    @Transactional(readOnly = true)
    public String login(MemberDto memberDto) {
        Optional<Member> member = memberRepository.findById(memberDto.getUsername());
        if (member.isEmpty()) return "아이디가 없습니다";
        String encodedPassword = passwordEncoder.encode(member.get().getEmail(), memberDto.getPassword());
        if (member.get().getPassword().equals(encodedPassword)) return "로그인 성공!";
        else return "비밀번호가 틀립니다";
    }
}

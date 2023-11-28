package PINCOM.GuitarMall.member.service;

import PINCOM.GuitarMall.member.dto.MemberDto;


public interface MemberService {

    String join(MemberDto memberDto);

    String login(MemberDto memberDto);
}

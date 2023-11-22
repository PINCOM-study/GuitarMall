package PINCOM.GuitarMall.member.dto;

import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberDto {

    private String username;

    private String password;

    private String email;
}

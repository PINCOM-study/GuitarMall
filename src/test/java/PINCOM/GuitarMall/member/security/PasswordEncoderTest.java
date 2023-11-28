package PINCOM.GuitarMall.member.security;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PasswordEncoderTest {

    //private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("패스워드 해싱 확인")
    void encryptTest() {
        String email = "asdfg@naver.com";
        String password = "asdfg";
        String hashedPassword = passwordEncoder.encode(email, password);

        //log.debug("해쉬 후 패스워드: " + hashedPassword);
        System.out.println("hashedPassword = " + hashedPassword);
    }

    @Test
    @DisplayName("해싱 후 저장된 패스워드와 새로 해싱한 패스워드 비교")
    void passwordLoginTest() {
        String email = "asdfg@naver.com";
        String password = "asdfg";
        String hashedPassword = passwordEncoder.encode(email, password);
        System.out.println("hashedPassword = " + hashedPassword);

        String newHashedPassword = passwordEncoder.encode(email, password);
        System.out.println("newHashedPassword = " + newHashedPassword);

        Assertions.assertThat(hashedPassword).isEqualTo(newHashedPassword);
    }
}
package PINCOM.GuitarMall.member.repository;

import PINCOM.GuitarMall.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {

}

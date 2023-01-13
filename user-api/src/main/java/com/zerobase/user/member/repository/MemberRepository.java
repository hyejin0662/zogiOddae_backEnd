package com.zerobase.user.member.repository;

import com.zerobase.user.member.entity.member.Member;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Transactional
    Long updateInfo(String username, String newName, String email);


    Member findByNickName(String name);

    Optional<Member> findByEmail(String email);

    Optional<Member> findByUuid(String uuid);

    boolean existsByEmail(String email);


    Optional<Member> findByMemberIdAndPassword(String MemberId, String password);
    Page<Member> findAll(Pageable pageable);
}

package com.zerobase.user.member.repository;

import com.zerobase.user.member.entity.common.Notice;
import com.zerobase.user.member.entity.member.Member;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {


    List<Notice> findAllByMember(Member member);
}

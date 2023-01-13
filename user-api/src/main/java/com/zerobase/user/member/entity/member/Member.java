package com.zerobase.user.member.entity.member;

import com.zerobase.user.member.dto.MemberDto;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.zerobase.type.MemberPlatform;
import com.zerobase.type.MemberRole;
import com.zerobase.type.MemberStatus;
import com.zerobase.user.base.entity.BaseEntity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class Member extends BaseEntity {





    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String nickName;
    private String profile;

    @Column(name = "platform", nullable = false)
    @Enumerated(EnumType.STRING)
    private MemberPlatform platform;

    @Setter
    @Column(name = "email", unique = true, nullable = false, length = 64)
    private String email;

    @Setter
    @Column(name = "username", nullable = false, length = 32)
    private String username;

    @Setter
    @Column(name = "password", nullable = false, length = 1024)
    private String password;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    @Column(name = "memberRole", nullable = false)
    @Enumerated(EnumType.STRING)
    private MemberRole memberRole;

    private String zipcode;
    private String address;
    private String addressDetail;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    @OneToMany
    private List<Member> members = new ArrayList<>();



    @Builder
    public Member(String email, String password, String nickName, MemberStatus status,
            MemberRole memberRole) {
        this.email = email;
        this.password = password;
        this.nickName = nickName;
        this.status = status;
        this.memberRole = memberRole;
    }
    public void editNickName(String nickName) {
        this.nickName = nickName;
        this.createdAt = LocalDateTime.now();
    }

    public void resetPassword(String password) {
        this.password = password;
        this.updatedAt = LocalDateTime.now();
    }

    public void changeMemberStatus(MemberStatus status) {
        this.status = status;
        this.updatedAt = LocalDateTime.now();

        if (status == MemberStatus.DELETED) {
            this.updatedAt = LocalDateTime.now();
            this.deletedAt = LocalDateTime.now();
        }

    }

    public MemberDto toMemberDto() {
        return MemberDto.builder()
                .id(this.id)
                .email(this.email)
                .nickName(this.nickName)
                .profile(this.profile)
                .memberRole(this.memberRole)
                .status(this.status)
                .createdAt(this.createdAt)
                .updatedAt(this.updatedAt)
                .build();
    }

        public void editProfile(String profile) {
            this.profile = profile;
            this.updatedAt = LocalDateTime.now();
        }



}
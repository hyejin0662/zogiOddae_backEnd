package com.zerobase.type;

public enum MemberRole {

    ROLE_USER, ROLE_SELLER, ROLE_ADMIN;


    private String authority;

    public String getAuthority() {
        return authority;
    }
}

package com.zerobase.user.member.controller;


import com.zerobase.user.member.service.AuthService;
import com.zerobase.user.member.service.MailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MailService MailService;
    private final AuthService authService;

    @Value("${api.key}")
    private String API_KEY;









}

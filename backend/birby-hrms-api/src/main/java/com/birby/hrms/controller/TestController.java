package com.birby.hrms.controller;

import com.birby.hrms.constant.Roles;
import com.birby.hrms.service.auth.JwtPrincipalService;
import com.birby.hrms.service.cli.ResourceAuthCliService;
import com.birby.hrms.vo.JwtPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(path = "/test")
public class TestController {
    @Autowired
    private ResourceAuthCliService resourceAuthCliService;
    @Autowired
    private JwtPrincipalService jwtPrincipalService;
    @GetMapping(path = "/test1")
    @Secured({Roles.DEFAULT_STAFF})
    public Object test1(Principal principal){
        return principal.getName();
    }
    @GetMapping(path = "/test2")
    @Secured({Roles.DEFAULT_STAFF})
    public Object test2(@AuthenticationPrincipal JwtPrincipal jwtPrincipal){
        return jwtPrincipal;
    }
}

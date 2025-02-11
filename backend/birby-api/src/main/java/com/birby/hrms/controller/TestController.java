package com.birby.hrms.controller;

import com.birby.hrms.constant.Roles;
import com.birby.hrms.service.cli.ResourceAuthCliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(path = "/test")
public class TestController {
    @Autowired
    ResourceAuthCliService resourceAuthCliService;
    @GetMapping()
    @Secured({Roles.DEFAULT_STAFF})
    public Object test1(Principal principal){
        return principal.getName();
    }
}

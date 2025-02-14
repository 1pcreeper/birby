package com.birby.hrms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(path = "/test")
public class TestController {
    @GetMapping()
    public Object test() {
        return "Hlll";
    }
}

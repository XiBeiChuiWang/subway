package com.subway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("center")
public class CeShi {
    @GetMapping("a")
    public String a(){
        return "a";
    }
}

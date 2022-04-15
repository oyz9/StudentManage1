package org.scut.java2022.oyz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class HelloController {
    //测试
    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }
}

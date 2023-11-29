package com.kyy.shop_app.presentation;

import com.kyy.shop_app.domain.dto.HelloDTO;
import com.kyy.shop_app.domain.service.HelloService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService;

    @PostConstruct
    void init() {
        HelloDTO helloDTO = new HelloDTO();
        helloDTO.setUserId("kyy");
        helloDTO.setPassword("1234");
        helloDTO.setName("김용열");
        helloService.register(helloDTO);
    }

    @GetMapping("/hello")
    public String hello(Model model) {

        HelloDTO hello = helloService.getHello(1L);

        model.addAttribute("name", hello.getName());
        model.addAttribute("userId", hello.getUserId());
        model.addAttribute("password", hello.getPassword());

        return "hello";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List list = new ArrayList<>();
        list.add(HelloDTO.builder().name("김용1").build());
        list.add(HelloDTO.builder().name("김용2").build());
        list.add(HelloDTO.builder().name("김용3").build());
        model.addAttribute("helloList", list);
        return "list";
    }
}

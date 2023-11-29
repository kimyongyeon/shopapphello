package com.kyy.shop_app.presentation;

import com.kyy.shop_app.domain.dto.HelloDTO;
import com.kyy.shop_app.domain.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class HelloRestController {
    private final HelloService helloService;

    @GetMapping("/hello/list")
    public List<HelloDTO> getHelloList() {
        return helloService.getHelloList();
    }

    @DeleteMapping("/hello")
    public void deleteHello(Long id) {
        helloService.deleteHello(id);
    }

    @PutMapping("/hello")
    public void updateHello(HelloDTO helloDTO) {
        helloService.updateHello(helloDTO);
    }

    @PostMapping("/hello")
    public void register(HelloDTO helloDTO) {
        helloService.register(helloDTO);
    }

    @GetMapping("/hello")
    public HelloDTO getHello(@RequestParam("id") Long id) {
        System.out.println(String.format("id: %d", id));
        return helloService.getHello(id);
    }
}

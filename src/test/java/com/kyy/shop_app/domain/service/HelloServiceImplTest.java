package com.kyy.shop_app.domain.service;

import com.kyy.shop_app.domain.dto.HelloDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloServiceImplTest {

    @Autowired
    HelloService helloService;

    @BeforeEach
    void setUp() {
        HelloDTO build = HelloDTO.builder()
                .name("test")
                .phone(1234)
                .age(12)
                .userId("test")
                .password("test").build();
        helloService.register(build);
    }

    @Test
    @DisplayName("회원가입 테스트")
    void register() {
        HelloDTO build = HelloDTO.builder()
                .name("test")
                .phone(1234)
                .age(12)
                .userId("test")
                .password("test").build();
        helloService.register(build);

        HelloDTO hello = helloService.getHello(1L);

        Assertions.assertEquals(build.getName(), hello.getName(), "등록한 이름과 같나요?");
    }

    @Test
    @DisplayName("회원조회 테스트")
    void getHello() {
        HelloDTO hello = helloService.getHello(1L);
        Assertions.assertEquals("test", hello.getName(), "이름이 같나요?");
    }
}
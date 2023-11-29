package com.kyy.shop_app.domain.service;

import com.kyy.shop_app.domain.dto.HelloDTO;

import java.util.List;

public interface HelloService {
    void register(HelloDTO helloDTO);
    HelloDTO getHello(Long id);

    List<HelloDTO> getHelloList();

    void deleteHello(Long id);

    void updateHello(HelloDTO helloDTO);
}

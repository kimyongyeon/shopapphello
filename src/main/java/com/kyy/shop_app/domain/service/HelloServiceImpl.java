package com.kyy.shop_app.domain.service;

import com.kyy.shop_app.domain.dto.HelloDTO;
import com.kyy.shop_app.infra.hello.HelloRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class HelloServiceImpl implements HelloService {

    private final HelloRepository helloRepository;

    @Override
    public void register(HelloDTO helloDTO) {
        helloRepository.findByUserId(helloDTO.getUserId()).ifPresent(hello -> {
            throw new IllegalArgumentException("이미 존재하는 ID입니다.");
        });
        helloRepository.save(helloDTO.toEntity());
    }

    @Override
    public HelloDTO getHello(Long id) {
        return helloRepository.findById(id).orElseThrow().toDTO();
    }

    @Override
    public List<HelloDTO> getHelloList() {
        return null;
    }

    @Override
    public void deleteHello(Long id) {

    }

    @Override
    public void updateHello(HelloDTO helloDTO) {

    }
}

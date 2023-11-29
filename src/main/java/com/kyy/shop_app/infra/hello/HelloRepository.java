package com.kyy.shop_app.infra.hello;

import com.kyy.shop_app.domain.model.Hello;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HelloRepository extends JpaRepository<Hello, Long> {
    Optional<Hello> findByUserId(String userId); // select * from hello where user_id = ?
}

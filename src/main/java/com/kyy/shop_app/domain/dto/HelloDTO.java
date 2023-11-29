package com.kyy.shop_app.domain.dto;

import com.kyy.shop_app.domain.model.Hello;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HelloDTO {
    private String name;
    private int phone;
    private int age;
    private String userId;
    private String password;

    public Hello toEntity() {
        return Hello.builder()
                .name(name)
                .phone(phone)
                .age(age)
                .userId(userId)
                .password(password)
                .build();
    }
}

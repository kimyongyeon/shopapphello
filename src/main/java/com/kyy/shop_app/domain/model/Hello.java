package com.kyy.shop_app.domain.model;

import com.kyy.shop_app.domain.dto.HelloDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hello {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int phone;

    private int age;

    private String userId;

    private String password;

    public HelloDTO toDTO() {
        return HelloDTO.builder()
                .name(name)
                .phone(phone)
                .age(age)
                .userId(userId)
                .password(password)
                .build();
    }


}

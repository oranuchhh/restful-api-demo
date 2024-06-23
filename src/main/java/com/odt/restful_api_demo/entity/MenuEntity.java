package com.odt.restful_api_demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class MenuEntity {
    @Id
    String code;
    String name;
    String image;
    BigDecimal price;
}

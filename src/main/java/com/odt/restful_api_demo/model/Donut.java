package com.odt.restful_api_demo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class Donut {
    String code;
    String name;
    String image;
    BigDecimal price;
}

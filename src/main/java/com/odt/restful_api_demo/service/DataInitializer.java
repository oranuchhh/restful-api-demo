package com.odt.restful_api_demo.service;

import com.odt.restful_api_demo.entity.MenuEntity;
import com.odt.restful_api_demo.repository.MenuRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(MenuRepository repository) {
        return (args) -> {

            MenuEntity entity1 = new MenuEntity();
            entity1.setCode("1");
            entity1.setName("Choco Pop");
            entity1.setImage("image1");
            entity1.setPrice(new BigDecimal(20));

            MenuEntity entity2 = new MenuEntity();
            entity2.setCode("2");
            entity2.setName("Blue Soda");
            entity2.setImage("image2");
            entity2.setPrice(new BigDecimal(30));

            MenuEntity entity3 = new MenuEntity();
            entity3.setCode("3");
            entity3.setName("Berry Yam");
            entity3.setImage("image3");
            entity3.setPrice(new BigDecimal(25));

            MenuEntity entity4 = new MenuEntity();
            entity4.setCode("4");
            entity4.setName("Strawberry");
            entity4.setImage("image4");
            entity4.setPrice(new BigDecimal(20));

            MenuEntity entity5 = new MenuEntity();
            entity5.setCode("5");
            entity5.setName("Choco Cream");
            entity5.setImage("image5");
            entity5.setPrice(new BigDecimal(25));

            MenuEntity entity6 = new MenuEntity();
            entity6.setCode("6");
            entity6.setName("Blue Cream");
            entity6.setImage("image6");
            entity6.setPrice(new BigDecimal(30));

            MenuEntity entity7 = new MenuEntity();
            entity7.setCode("7");
            entity7.setName("Vanilla Banana");
            entity7.setImage("image7");
            entity7.setPrice(new BigDecimal(30));

            MenuEntity entity8 = new MenuEntity();
            entity8.setCode("8");
            entity8.setName("Milk Cream");
            entity8.setImage("image8");
            entity8.setPrice(new BigDecimal(20));

            MenuEntity entity9 = new MenuEntity();
            entity9.setCode("9");
            entity9.setName("Cookie Cream");
            entity9.setImage("image9");
            entity9.setPrice(new BigDecimal(25));

            repository.save(entity1);
            repository.save(entity2);
            repository.save(entity3);
            repository.save(entity4);
            repository.save(entity5);
            repository.save(entity6);
            repository.save(entity7);
            repository.save(entity8);
            repository.save(entity9);
        };
    }
}
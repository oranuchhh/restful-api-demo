package com.odt.restful_api_demo.service;

import com.odt.restful_api_demo.model.Donut;
import com.odt.restful_api_demo.model.Menu;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {

    public Menu getMenu() {
        Menu menu = new Menu();
        List<Donut> donutList = new ArrayList<>();
        Donut donut1 = Donut.builder()
                .code("1")
                .name("Choco Pop")
                .image("image1")
                .price(new BigDecimal(20))
                .build();

        Donut donut2 = Donut.builder()
                .code("2")
                .name("Blue Soda")
                .image("image2")
                .price(new BigDecimal(30))
                .build();

        Donut donut3 = Donut.builder()
                .code("3")
                .name("Berry Yam")
                .image("image3")
                .price(new BigDecimal(25))
                .build();

        Donut donut4 = Donut.builder()
                .code("4")
                .name("Strawberry")
                .image("image4")
                .price(new BigDecimal(20))
                .build();

        Donut donut5 = Donut.builder()
                .code("5")
                .name("Choco Cream")
                .image("image1")
                .price(new BigDecimal(25))
                .build();

        Donut donut6 = Donut.builder()
                .code("6")
                .name("Blue Cream")
                .image("image6")
                .price(new BigDecimal(30))
                .build();

        Donut donut7 = Donut.builder()
                .code("7")
                .name("Vanilla Banana")
                .image("image7")
                .price(new BigDecimal(30))
                .build();

        Donut donut8 = Donut.builder()
                .code("8")
                .name("Milk Cream")
                .image("image8")
                .price(new BigDecimal(20))
                .build();

        Donut donut9 = Donut.builder()
                .code("9")
                .name("Cookie Cream")
                .image("image9")
                .price(new BigDecimal(25))
                .build();

        donutList.add(donut1);
        donutList.add(donut2);
        donutList.add(donut3);
        donutList.add(donut4);
        donutList.add(donut5);
        donutList.add(donut6);
        donutList.add(donut7);
        donutList.add(donut8);
        donutList.add(donut9);

        menu.setMenu(donutList);
        return menu;
    }
}

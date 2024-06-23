package com.odt.restful_api_demo.controller;

import com.odt.restful_api_demo.model.DeleteMenuRequest;
import com.odt.restful_api_demo.model.Donut;
import com.odt.restful_api_demo.model.Menu;
import com.odt.restful_api_demo.model.UpdatePriceRequest;
import com.odt.restful_api_demo.service.MenuService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

class MenuControllerTest {
    @InjectMocks
    MenuController menuController;
    @Mock
    MenuService menuService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getMenu_success() {
        doReturn(mockMenu()).when(menuService).getMenu();
        ResponseEntity<Menu> responseEntity = menuController.getMenu();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertEquals(9, responseEntity.getBody().getMenu().size());
    }

    @Test
    void addMenu_success() {
        doReturn(mockMenu()).when(menuService).addMenu(any());
        ResponseEntity<Menu> responseEntity = menuController.addMenu(new ArrayList<>());
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertEquals(9, responseEntity.getBody().getMenu().size());
    }

    @Test
    void updatePrice_success() {
        doReturn(mockMenu()).when(menuService).updateMenu(any());
        UpdatePriceRequest request = new UpdatePriceRequest();
        ResponseEntity<Menu> responseEntity = menuController.updatePrice(request);
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertEquals(9, responseEntity.getBody().getMenu().size());
    }

    @Test
    void removeMenu_success() {
        doReturn(mockMenu()).when(menuService).deleteMenu(any());
        DeleteMenuRequest request = new DeleteMenuRequest();
        ResponseEntity<Menu> responseEntity = menuController.removeMenu(request);
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertEquals(9, responseEntity.getBody().getMenu().size());
    }

    private Menu mockMenu() {
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
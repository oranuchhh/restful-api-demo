package com.odt.restful_api_demo.service;

import com.odt.restful_api_demo.model.DeleteMenuRequest;
import com.odt.restful_api_demo.model.Donut;
import com.odt.restful_api_demo.model.Menu;
import com.odt.restful_api_demo.model.UpdatePriceRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

class MenuServiceTest {

    @InjectMocks
    MenuService menuService;

    @Mock
    MenuDataManagerService menuDataManagerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getMenu_success() {
        doReturn(mockDonutList()).when(menuDataManagerService).getMenuAll();

        Menu menu = menuService.getMenu();
        Assertions.assertEquals(9, menu.getMenu().size());
    }

    @Test
    void addMenu_success() {
        Donut donut10 = Donut.builder()
                .code("10")
                .name("donut10")
                .image("image10")
                .price(new BigDecimal(20))
                .build();
        List<Donut> donutList = mockDonutList();
        donutList.add(donut10);

        doReturn(donut10).when(menuDataManagerService).saveMenu(donut10);
        doReturn(donutList).when(menuDataManagerService).getMenuAll();

        List<Donut> request = new ArrayList<>();
        request.add(donut10);
        Menu menu = menuService.addMenu(request);

        Assertions.assertEquals(10, menu.getMenu().size());
    }

    @Test
    void updateMenu_success() {
        Donut donut1 = Donut.builder()
                .code("1")
                .name("Choco Pop")
                .image("image1")
                .price(new BigDecimal(25))
                .build();

        List<Donut> donutList = mockDonutList();
        donutList.get(1).setPrice(donut1.getPrice());

        doReturn(donut1).when(menuDataManagerService).saveMenu(donut1);
        doReturn(donutList).when(menuDataManagerService).getMenuAll();

        UpdatePriceRequest request = new UpdatePriceRequest();
        request.setCode("1");
        request.setPrice(new BigDecimal(25));
        Menu menu = menuService.updateMenu(request);

        Assertions.assertEquals(9, menu.getMenu().size());
        Assertions.assertEquals(new BigDecimal(25), menu.getMenu().get(1).getPrice());
    }

    @Test
    void deleteMenu_success() {

        List<Donut> donutList = mockDonutList();
        donutList.remove(1);

        doNothing().when(menuDataManagerService).removeMenu(any());
        doReturn(donutList).when(menuDataManagerService).getMenuAll();

        DeleteMenuRequest request = new DeleteMenuRequest();
        request.setCodeList(List.of("1"));
        Menu menu = menuService.deleteMenu(request);

        Assertions.assertEquals(8, menu.getMenu().size());
    }

    private List<Donut> mockDonutList() {
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

        return donutList;
    }
}
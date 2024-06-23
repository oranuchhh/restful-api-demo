package com.odt.restful_api_demo.service;

import com.odt.restful_api_demo.model.DeleteMenuRequest;
import com.odt.restful_api_demo.model.Donut;
import com.odt.restful_api_demo.model.Menu;
import com.odt.restful_api_demo.model.UpdatePriceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuDataManagerService menuDataManagerService;

    public Menu getMenu() {
        Menu menu = new Menu();
        List<Donut> donutList = menuDataManagerService.getMenuAll();
        menu.setMenu(donutList);
        return menu;
    }

    public Menu addMenu(List<Donut> request) {
        Menu menu = new Menu();
        for (Donut donut : request) {
            menuDataManagerService.saveMenu(donut);
        }
        List<Donut> donutList = menuDataManagerService.getMenuAll();
        menu.setMenu(donutList);
        return menu;
    }


    public Menu updateMenu(UpdatePriceRequest request) {
        Menu menu = new Menu();
        List<Donut> donutList = menuDataManagerService.getMenuAll();
        for (Donut donut : donutList) {
            if (donut.getCode().equalsIgnoreCase(request.getCode())) {
                donut.setPrice(request.getPrice());
            }
            menuDataManagerService.saveMenu(donut);
        }
        donutList = menuDataManagerService.getMenuAll();
        menu.setMenu(donutList);
        return menu;
    }

    public Menu deleteMenu(DeleteMenuRequest request) {
        Menu menu = new Menu();
        List<Donut> donutList = menuDataManagerService.getMenuAll();
        for (Donut donut : donutList) {
            if (request.getCodeList().contains(donut.getCode())) {
                menuDataManagerService.removeMenu(donut.getCode());
            }
        }
        donutList = menuDataManagerService.getMenuAll();
        menu.setMenu(donutList);
        return menu;
    }
}

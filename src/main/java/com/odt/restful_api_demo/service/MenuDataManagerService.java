package com.odt.restful_api_demo.service;

import com.odt.restful_api_demo.entity.MenuEntity;
import com.odt.restful_api_demo.model.Donut;
import com.odt.restful_api_demo.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuDataManagerService {
    private final MenuRepository menuRepository;

    public List<Donut> getMenuAll() {
        List<MenuEntity> menuEntities = menuRepository.findAll();
        List<Donut> donutList = new ArrayList<>();
        for (MenuEntity menuEntity : menuEntities) {
            donutList.add(parseMenuEntityToDonut(menuEntity));
        }
        return donutList;
    }

    public Donut saveMenu(Donut donut) {
        MenuEntity menuEntity = parseDonutToMenuEntity(donut);
        MenuEntity saveMenuEntity = saveMenuEntity(menuEntity);
        return parseMenuEntityToDonut(saveMenuEntity);
    }

    public void removeMenu(String code) {
        removeMenuEntity(code);
    }

    private MenuEntity saveMenuEntity(MenuEntity menu) {
        return menuRepository.save(menu);
    }

    private void removeMenuEntity(String code) {
        menuRepository.deleteById(code);
    }

    private static Donut parseMenuEntityToDonut(MenuEntity menuEntity) {
        return Donut.builder()
                .code(menuEntity.getCode())
                .name(menuEntity.getName())
                .image(menuEntity.getImage())
                .price(menuEntity.getPrice())
                .build();
    }

    private static MenuEntity parseDonutToMenuEntity(Donut donut) {
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setCode(donut.getCode());
        menuEntity.setName(donut.getName());
        menuEntity.setImage(donut.getImage());
        menuEntity.setPrice(donut.getPrice());
        return menuEntity;
    }
}

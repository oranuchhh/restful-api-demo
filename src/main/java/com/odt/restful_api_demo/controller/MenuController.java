package com.odt.restful_api_demo.controller;

import com.odt.restful_api_demo.model.DeleteMenuRequest;
import com.odt.restful_api_demo.model.Donut;
import com.odt.restful_api_demo.model.Menu;
import com.odt.restful_api_demo.model.UpdatePriceRequest;
import com.odt.restful_api_demo.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/api/menu")
    ResponseEntity<Menu> getMenu() {
        Menu menu = menuService.getMenu();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok().headers(headers).body(menu);
    }

    @PostMapping("/api/menu/add")
    ResponseEntity<Menu> addMenu(@RequestBody List<Donut> request) {
        Menu response = menuService.addMenu(request);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok().headers(headers).body(response);
    }

    @PutMapping("/api/menu/update/price")
    ResponseEntity<Menu> updatePrice(@RequestBody UpdatePriceRequest request) {
        Menu response = menuService.updateMenu(request);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok().headers(headers).body(response);
    }

    @DeleteMapping("/api/menu/remove")
    ResponseEntity<Menu> removeMenu(@RequestBody DeleteMenuRequest request) {
        Menu response = menuService.deleteMenu(request);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity.ok().headers(headers).body(response);
    }
}

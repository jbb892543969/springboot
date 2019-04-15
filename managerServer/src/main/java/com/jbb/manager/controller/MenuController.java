package com.jbb.manager.controller;

import com.jbb.manager.entity.dto.MenuDTO;
import com.jbb.manager.service.MenuService;
import com.jbb.manager.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName MenuController
 * @Author 金斌斌
 * @Description
 * @Date 2018-07-26 10:00
 **/
@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("getUserMenu")
    public JsonResult getUserMenu(String account) {
        List<MenuDTO> userMenu = menuService.getUserMenu(account);
        return new JsonResult(200, "获取成功", userMenu);
    }

}

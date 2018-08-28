package com.computech.controller;

import com.computech.pojo.Menu;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @GetMapping("/getMenus")
    public List<Menu> getMenus(){
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu("1","fa fa-user fa-fw","用户管理","test1",null));
        menus.add(new Menu("2","fa fa-superpowers fa-fw","角色管理","test2",null));
        menus.add(new Menu("3","fa fa-unlock fa-fw","权限管理","test3",null));
        menus.add(new Menu("4","fa fa-home fa-fw","机构管理","test4",null));

        return menus;
    }
}

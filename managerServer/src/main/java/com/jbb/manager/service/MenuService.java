package com.jbb.manager.service;

import com.jbb.manager.entity.dto.MenuDTO;
import com.jbb.manager.repository.qrepository.QMenuRepository;
import com.jbb.manager.util.treeutils.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName MenuService
 * @Author 金斌斌
 * @Description
 * @Date 2018-07-25 09:08
 **/
@Service
public class MenuService {
    @Autowired
    private QMenuRepository qMenuRepository;

    public List<MenuDTO> getAllMenu() {
        List<MenuDTO> allMenu = qMenuRepository.getAllMenu();
        return allMenu;
    }

    public List<MenuDTO> getUserMenu(String account) {
        List<MenuDTO> menus = qMenuRepository.getUserMenu(account);
        List<MenuDTO> roots = TreeUtils.findRoots(menus);
        TreeUtils.getTree(roots, menus);
        return roots;
    }
}

package com.jbb.manager.repository;

import com.jbb.manager.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName MenuRepository
 * @Author 金斌斌
 * @Description
 * @Date 2018-07-24 11:03
 **/
public interface MenuRepository extends JpaRepository<Menu, Integer> {

}

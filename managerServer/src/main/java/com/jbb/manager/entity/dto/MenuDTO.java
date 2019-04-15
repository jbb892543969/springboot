package com.jbb.manager.entity.dto;

import com.jbb.manager.util.treeutils.Node;

/**
 * @ClassName MenuDTO
 * @Author 金斌斌
 * @Description
 * @Date 2018-07-24 11:17
 **/
public class MenuDTO extends Node {
    private String url;
    private String roleName;
    private String name;
    private String component;
    private String path;

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}

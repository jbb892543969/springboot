package com.jbb.manager.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @ClassName Menu
 * @Author 金斌斌
 * @Description
 * @Date 2018-07-23 16:02
 **/
@Entity
@Table(name = "menu")
public class Menu {
    private int id;
    private String name;
    private String url;
    private String component;
    private String path;
    private String icon;
    private int pid;
    private int status;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "component")
    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    @Basic
    @Column(name = "path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Basic
    @Column(name = "icon")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    @Column(name = "pid")
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return id == menu.id &&
                pid == menu.pid &&
                Objects.equals(name, menu.name) &&
                Objects.equals(url, menu.url) &&
                Objects.equals(component, menu.component) &&
                Objects.equals(path, menu.path) &&
                Objects.equals(icon, menu.icon) &&
                Objects.equals(status, menu.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, url, component, path, icon, pid, status);
    }
}

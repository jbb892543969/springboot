package com.jbb.manager.util.treeutils;

import java.util.List;

/**
 * @ClassName Node
 * @Author 金斌斌
 * @Description 节点类
 * @Date 2018-07-07 09:59
 **/
public class Node {
    private Integer parentID;
    private Integer id;
    private List childrens;

    public Integer getParentID() {
        return parentID;
    }

    public void setParentID(Integer parentID) {
        this.parentID = parentID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List getChildrens() {
        return childrens;
    }

    public void setChildrens(List childrens) {
        this.childrens = childrens;
    }

}

package com.jbb.manager.util.treeutils;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName TreeUtils
 * @Author 金斌斌
 * @Description 树工具类
 * @Date 2018-07-07 10:13
 **/
public class TreeUtils {

    /**
     * @return java.util.List<T> 根节点集合
     * @Author 金斌斌
     * @Description 获取根节点
     * @Date 2018-07-07 10:34
     * @Param [list] 无序集合
     **/
    public static <T extends Node> List<T> findRoots(List<T> list) {
        LinkedList<T> roots = new LinkedList<>();
        for (T t : list) {
            if (t.getParentID() == 0) {//添加父节点
                roots.add(t);
            }
        }
        return roots;
    }

    public static <T extends Node> void getTree(List<T> roots, List<T> list) {
        for (T t : roots) {//遍历所有父节点
            List<T> childList = new LinkedList<>();//子节点集合
            for (T one : list) {
                if (one.getParentID() == t.getId()) {//将子节点加入子节点集合
                    childList.add(one);
                }
            }
            t.setChildrens(childList);//子节点集合计入父节点中
            if (childList.size() != 0) {
                getTree(childList, list);//递归遍历子节点的所有孙子节点
            }
        }
    }
}

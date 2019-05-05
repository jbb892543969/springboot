package com.jbb.manager.util;

import java.util.HashMap;

public class TableResult {
    private HashMap<String, Object> queryMap;//查询条件
    private Integer currPage;//当前页，默认0
    private Long countPage;//总页数
    private Long total;//总记录数
    private Integer currTotal;//每页记录数，默认10
    private Object lists;//当前页数据集合

    public Long getTotalPage(Long total) {
        return total % currTotal == 0 ? total / currTotal : total / currTotal + 1;
    }

    public HashMap<String, Object> getQueryMap() {
        return queryMap;
    }

    public void setQueryMap(HashMap<String, Object> queryMap) {
        this.queryMap = queryMap;
    }

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = (currPage == null ? 0 : currPage);
    }

    public Long getCountPage() {
        return countPage;
    }

    public void setCountPage(Long countPage) {
        this.countPage = countPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getCurrTotal() {
        return currTotal;
    }

    public void setCurrTotal(Integer currTotal) {
        this.currTotal = (currTotal == null ? 10 : currTotal);
    }

    public Object getLists() {
        return lists;
    }

    public void setLists(Object lists) {
        this.lists = lists;
    }
}

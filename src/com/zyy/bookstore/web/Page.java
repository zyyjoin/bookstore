package com.zyy.bookstore.web;

import java.util.List;

/**
 * 封装分页信息的Pages类
 */
public class Page<T> {
    private int pageNo;//当前页码
    private List<T> list;//页面所显示书集合list
    private int pageSize = 3;//每页所能显示记录数
    private long totalItemNumber;//总记录数
    //初始化当前页码
    public Page(int pageNo) {
        this.pageNo = pageNo;
    }
    //返回当前页码（须判断比较）
    public int getPageNo() {
        if (pageNo>getTotalPageNumber()){
            pageNo = getTotalPageNumber();
        }
        if (pageNo<0){
            pageNo = 1;
        }
        return pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public List<T> getList() {
        return list;
    }
    //设置当前页需要显示的书对象的list集合
    public void setList(List<T> list) {
        this.list = list;
    }
    //获取总页数
    public int getTotalPageNumber() {
        int num = (int) (totalItemNumber/pageSize);
        if (totalItemNumber%pageSize!=0){
            num++;
        }
        return num;
    }

    public void setTotalItemNumber(long totalItemNumber) {
        this.totalItemNumber = totalItemNumber;
    }
    //是否有下一页
    public boolean isHasNext(){
        if (getPageNo()>=getTotalPageNumber()){
            return false;
        }
        return true;
    }
    //是否有上一页
    public boolean isHasPrev(){
        if (getPageNo()<=1){
            return false;
        }
        return true;
    }
    //上一页页码
    public int getPrePage(){
        if (!isHasPrev()){
            return getPageNo();
        }
        return getPageNo()-1;
    }
    //下一页页码
    public int getNextPage(){
        if (!isHasNext()){
            return getPageNo();
        }
        return getPageNo()+1;
    }
}

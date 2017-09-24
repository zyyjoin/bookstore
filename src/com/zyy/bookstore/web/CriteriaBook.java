package com.zyy.bookstore.web;

/**
 * 封装查询条件(按书的价格)的类(查询指定区间的书)
 */
public class CriteriaBook {
    private float minPrice = 0;//价格区间最小值0
    private float maxPrice = Integer.MAX_VALUE;//价格区间最大值Integer.MAX_VALUE
    private int pageNo;

    public CriteriaBook() {

    }
    public CriteriaBook(float minPrice,float maxPrice,int pageNo) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.pageNo = pageNo;
    }

    public float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
}

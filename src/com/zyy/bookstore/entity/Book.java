package com.zyy.bookstore.entity;


import java.sql.Date;

/**
 * 书类
 */
public class Book {
    private int id;//书主键id
    private String author;//作者
    private String title;//书名
    private float price;//价格
    private Date publishingDate;//出版日期
    private int salesAmount;//销售额
    private int storeNumber;//库存
    private String remark;//评论

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String anthor) {
        this.author = anthor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Date pulishingDate) {
        this.publishingDate = pulishingDate;
    }

    public int getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(int salesAmount) {
        this.salesAmount = salesAmount;
    }

    public int getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(int storeNumber) {
        this.storeNumber = storeNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", publishingDate=" + publishingDate +
                ", salesAmount=" + salesAmount +
                ", storeNumber=" + storeNumber +
                ", remark='" + remark + '\'' +
                '}'+'\n';
    }
}

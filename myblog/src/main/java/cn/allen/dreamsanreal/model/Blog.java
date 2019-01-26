package cn.allen.dreamsanreal.model;

import java.util.Date;

public class Blog {
    private Integer id;

    private Date createdTime;

    private Date updatedTime;

    private String blogNum;

    private Integer categoryId;

    private Integer author;

    private String remark;

    private String summary;

    public Blog() {}

    public Blog(String blogNum, Integer author, String summary) {
        this.blogNum = blogNum;
        this.author = author;
        this.summary = summary;
    }

    public Blog(String blogNum, Integer categoryId, Integer author, String summary) {
        this.blogNum = blogNum;
        this.categoryId = categoryId;
        this.author = author;
        this.summary = summary;
    }

    public Blog(Integer id, Date createdTime, Date updatedTime, String blogNum, Integer categoryId, Integer author, String remark, String summary) {
        this.id = id;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.blogNum = blogNum;
        this.categoryId = categoryId;
        this.author = author;
        this.remark = remark;
        this.summary = summary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getBlogNum() {
        return blogNum;
    }

    public void setBlogNum(String blogNum) {
        this.blogNum = blogNum == null ? null : blogNum.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }
}
package com.suyang.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_spider")
public class Spider {
    @Id
    private String id = "";
    @Column(nullable = false)
    private String name = "";
    @Column(nullable = false)
    private String keyword = "";
    @Column(nullable = false)
    private double maxPrice = 9999999;
    @Column(nullable = false)
    private double minPrice = 0;
    @Column(nullable = false)
    private Date createTime;
    @Column(nullable = false)
    private Date updateTime;
    @Column(nullable = false)
    private int frequency = 60;

    public Spider() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Spider)) return false;
        Spider spider = (Spider) o;
        return Objects.equals(getId(), spider.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

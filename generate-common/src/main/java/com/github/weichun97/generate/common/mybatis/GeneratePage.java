package com.github.weichun97.generate.common.mybatis;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ApiModel(description = "分页返回对象")
public class GeneratePage<T> implements IPage<T> {


    private static final long serialVersionUID = 8545996863226528798L;

    /**
     * 查询数据列表
     */
    @ApiModelProperty("对象结果集")
    private List<T> records = Collections.emptyList();

    /**
     * 总数
     */
    @ApiModelProperty("总条数")
    private long total = 0;


    @ApiModelProperty(value = "每页显示条数")
    private long pageSize = 10;


    @ApiModelProperty(value = "当前页")
    private long current = 1;


    /**
     * 排序字段信息
     */
    private List<OrderItem> orders = new ArrayList<>();


    @Override
    public List<OrderItem> orders() {
        return this.orders;
    }

    @Override
    public List<T> getRecords() {
        return this.records;
    }

    @Override
    public GeneratePage<T> setRecords(List records) {
        this.records = records;
        return this;
    }

    public static GeneratePage getPage(GeneratePageParam page) {

        GeneratePage<Object> fgocPage = new GeneratePage<>();
        fgocPage.setCurrent(page.getCurrent());
        fgocPage.setSize(page.getSize());
        return fgocPage;
    }

    public GeneratePage() {

    }

    @Override
    public long getTotal() {
        return this.total;
    }

    @Override
    public GeneratePage<T> setTotal(long total) {
        this.total = total;
        return this;
    }


    public long getPageSize() {
        return this.pageSize;
    }

    @Override
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    public long getSize() {
        return this.pageSize;
    }

    @Override
    public GeneratePage<T> setSize(long size) {
        this.pageSize = size;
        return this;
    }

    @Override
    public long getCurrent() {
        return this.current;
    }

    @Override
    public GeneratePage<T> setCurrent(long current) {
        this.current = current;
        return this;
    }

    @Override
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    public boolean isSearchCount() {
        return true;
    }

    @Override
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    public boolean isHitCount() {
        return false;
    }


    @Override
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    public long getPages() {
        if (this.getSize() == 0L) {
            return 0L;
        } else {
            long pages = this.getTotal() / this.getSize();
            if (this.getTotal() % this.getSize() != 0L) {
                ++pages;
            }

            return pages;
        }
    }
}

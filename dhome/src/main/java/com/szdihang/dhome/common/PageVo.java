package com.szdihang.dhome.common;

import java.io.Serializable;
import java.util.List;

/**
 * @author glory
 * @version V1.0
 * @Title: PageVo
 * @Package: com.szdihang.dhome.model
 * @Description: query Vo 需要继承 PageVo
 * @date 2019/4/3 14:42
 **/
public class PageVo<T> implements Serializable {
    private Integer page;//当前页
    private Integer pages;//总页数
    private Integer limit = 20;//每页数据大小

    //总个数
    private Long count;

    private List<T> data;

    @Override
    public String toString() {
        return "PageVo{" +
                "page=" + page +
                ", pages=" + pages +
                ", limit=" + limit +
                ", count=" + count +
                ", data=" + data +
                '}';
    }

    public PageVo() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}

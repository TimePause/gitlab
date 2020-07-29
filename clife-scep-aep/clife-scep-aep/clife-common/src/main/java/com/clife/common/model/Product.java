package com.clife.common.model;

import java.io.Serializable;

/**
 * 产品信息
 *
 * @author caohaiyang
 */
public class Product implements Serializable {

    private static final long serialVersionUID = 16334614178482529L;
    /**
     * 应用ID
     */
    private String appId;
    /**
     * 应用秘钥
     */
    private String appSecret;
    /**
     * 产品ID or 产品名称
     */
    private String searchValue;
    /**
     * 当前页数
     */
    private Integer pageNow;
    /**
     * 每页记录数
     */
    private Integer pageSize;

    public Product() {
    }

    public Product(String appId, String appSecret, String searchValue, Integer pageNow, Integer pageSize) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.searchValue = searchValue;
        this.pageNow = pageNow;
        this.pageSize = pageSize;
    }

    public String getAppId() {
        return appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public Integer getPageNow() {
        return pageNow;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public void setPageNow(Integer pageNow) {
        this.pageNow = pageNow;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
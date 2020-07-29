package com.clife.common.model;

import java.io.Serializable;

/**
 * 设备信息
 *
 * @author caohaiyang
 */
public class Device implements Serializable {

    private static final long serialVersionUID = -7505867530357362345L;
    /**
     * 应用ID
     */
    private String appId;
    /**
     * 应用秘钥
     */
    private String appSecret;
    /**
     * MasterKey 在该设备所属产品的概况中可以查看
     */
    private String masterKey;
    /**
     * 在产品列表接口返回值中可以看到
     */
    private Integer productId;
    /**
     * 产品 id 或者产品名称
     */
    private String searchValue;
    /**
     * 当前页数
     */
    private Integer pageNow;
    /**
     * 每页记录数,最大40
     */
    private Integer pageSize;

    public Device() {
    }

    public Device(String appId, String appSecret, String masterKey, Integer productId, String searchValue, Integer pageNow, Integer pageSize) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.masterKey = masterKey;
        this.productId = productId;
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

    public String getMasterKey() {
        return masterKey;
    }

    public Integer getProductId() {
        return productId;
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

    public void setMasterKey(String masterKey) {
        this.masterKey = masterKey;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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
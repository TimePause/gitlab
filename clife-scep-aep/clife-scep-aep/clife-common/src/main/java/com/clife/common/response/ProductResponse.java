package com.clife.common.response;

/**
 * 产品信息的响应体
 *
 * @author caohaiyang
 */
public class ProductResponse {

    /**
     * 二级分类
     */
    private Integer secondaryType;
    /**
     * 在线设备数量
     */
    private Long onlineDeviceCount;
    /**
     * T-Link 证书认证根证书
     */
    private String rootCert;
    /**
     * 产品ID
     */
    private Integer productId;
    /**
     * MasterKey
     */
    private String apiKey;
    /**
     * 设备总数
     */
    private Integer deviceCount;
    /**
     * 更新时间
     */
    private Long updateTime;
    /**
     * 省电模式：1.PSM 2.DRX 3.eDRX
     */
    private Integer powerModel;
    /**
     * 产品协议：1.T-LINK协议 2.MQTT 协 议 3.LWM2M 协 议 4.TUP 协议5.HTTP 协议6.JT/T8087.TCP 协议 8.私有 TCP(网关
     * 子设备协议) 9.私有 UDP(网关子设备协议)10.网关产品MQTT(网关产品协议) 11.南向云
     */
    private Integer productProtocol;
    /**
     * 消息类型 1:json，2:紧凑二进制
     */
    private Integer payloadFormat;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * Endpoint 格 式:1.IMEI 2.URN:IMEI: 3.URN:IMEI-IMSI:
     */
    private Integer endpointFormat;
    /**
     * 三级分类名称
     */
    private String thirdTypeValue;
    /**
     * 产品分类名称
     */
    private String productTypeValue;
    /**
     * 产品描述
     */
    private String productDesc;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 二级分类名称
     */
    private String secondaryTypeValue;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 更新者
     */
    private String updateBy;
    /**
     * 租户ID
     */
    private Long tenantId;
    /**
     * 认证方式 1:特征串认证，2:sm9 认证，3:dtls 双向认证,4:IMEI认证,5:SIMID认证,6:sm2 认 证
     */
    private Integer authType;
    /**
     * 网络类型:1.wifi2.移动蜂窝数据3.NB-IoT4.以太网
     */
    private Integer networkType;
    /**
     * 三级分类
     */
    private Integer thirdType;
    /**
     * 产品类别
     */
    private Integer productType;

    public ProductResponse() {
    }

    public ProductResponse(Integer secondaryType, Long onlineDeviceCount, String rootCert, Integer productId, String apiKey,
                           Integer deviceCount, Long updateTime, Integer powerModel, Integer productProtocol, Integer payloadFormat,
                           String productName, Integer endpointFormat, String thirdTypeValue, String productTypeValue, String productDesc,
                           String createBy, String secondaryTypeValue, Long createTime, String updateBy, Long tenantId, Integer authType, Integer networkType, Integer thirdType, Integer productType) {
        this.secondaryType = secondaryType;
        this.onlineDeviceCount = onlineDeviceCount;
        this.rootCert = rootCert;
        this.productId = productId;
        this.apiKey = apiKey;
        this.deviceCount = deviceCount;
        this.updateTime = updateTime;
        this.powerModel = powerModel;
        this.productProtocol = productProtocol;
        this.payloadFormat = payloadFormat;
        this.productName = productName;
        this.endpointFormat = endpointFormat;
        this.thirdTypeValue = thirdTypeValue;
        this.productTypeValue = productTypeValue;
        this.productDesc = productDesc;
        this.createBy = createBy;
        this.secondaryTypeValue = secondaryTypeValue;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.tenantId = tenantId;
        this.authType = authType;
        this.networkType = networkType;
        this.thirdType = thirdType;
        this.productType = productType;
    }

    public Integer getSecondaryType() {
        return secondaryType;
    }

    public Long getOnlineDeviceCount() {
        return onlineDeviceCount;
    }

    public String getRootCert() {
        return rootCert;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public Integer getDeviceCount() {
        return deviceCount;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public Integer getPowerModel() {
        return powerModel;
    }

    public Integer getProductProtocol() {
        return productProtocol;
    }

    public Integer getPayloadFormat() {
        return payloadFormat;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getEndpointFormat() {
        return endpointFormat;
    }

    public String getThirdTypeValue() {
        return thirdTypeValue;
    }

    public String getProductTypeValue() {
        return productTypeValue;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public String getCreateBy() {
        return createBy;
    }

    public String getSecondaryTypeValue() {
        return secondaryTypeValue;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public Integer getAuthType() {
        return authType;
    }

    public Integer getNetworkType() {
        return networkType;
    }

    public Integer getThirdType() {
        return thirdType;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setSecondaryType(Integer secondaryType) {
        this.secondaryType = secondaryType;
    }

    public void setOnlineDeviceCount(Long onlineDeviceCount) {
        this.onlineDeviceCount = onlineDeviceCount;
    }

    public void setRootCert(String rootCert) {
        this.rootCert = rootCert;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setDeviceCount(Integer deviceCount) {
        this.deviceCount = deviceCount;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public void setPowerModel(Integer powerModel) {
        this.powerModel = powerModel;
    }

    public void setProductProtocol(Integer productProtocol) {
        this.productProtocol = productProtocol;
    }

    public void setPayloadFormat(Integer payloadFormat) {
        this.payloadFormat = payloadFormat;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setEndpointFormat(Integer endpointFormat) {
        this.endpointFormat = endpointFormat;
    }

    public void setThirdTypeValue(String thirdTypeValue) {
        this.thirdTypeValue = thirdTypeValue;
    }

    public void setProductTypeValue(String productTypeValue) {
        this.productTypeValue = productTypeValue;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public void setSecondaryTypeValue(String secondaryTypeValue) {
        this.secondaryTypeValue = secondaryTypeValue;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public void setAuthType(Integer authType) {
        this.authType = authType;
    }

    public void setNetworkType(Integer networkType) {
        this.networkType = networkType;
    }

    public void setThirdType(Integer thirdType) {
        this.thirdType = thirdType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }
}



package com.clife.common.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 查询设备列表的响应体
 *
 * @author caohaiyang
 */
public class DeivceResponse {

    /**
     * 设备编号
     */
    private String  deviceSn;
    /**
     * 设备ID
     */
    private String deviceId;
    /**
     * 终端名称
     */
    private String  deviceName;
    /**
     * 用户ID
     */
    private String tenantId;
    /**
     * 产品ID
     */
    private Integer productId;
    /**
     * 版本信息
     */
    private String firmwareVersion;
    /**
     * 设备状态
     */
    private Integer deviceStatus;
    /**
     *创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    /**
     * 更新时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;
    /**
     *激活时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date activeTime;
    /**
     * 注销时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date logoutTime;
    /**
     * 设备在线状态
     */
    private Integer netStatus;
    /**
     * 设备最后上线时间
     */
    private Long onlineAt;
    /**
     * 设备最后下线时间
     */
    private Long offlineAt;
    /**
     * 设备所在产品协议
     */
    private Integer productProtocol;

    public DeivceResponse() { }

    public DeivceResponse(String deviceSn, String deviceId, String deviceName, String tenantId, Integer productId, String firmwareVersion,
                          Integer deviceStatus, Date createTime, Date updateTime, Date activeTime, Date logoutTime, Integer netStatus, Long onlineAt, Long offlineAt, Integer productProtocol) {
        this.deviceSn = deviceSn;
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.tenantId = tenantId;
        this.productId = productId;
        this.firmwareVersion = firmwareVersion;
        this.deviceStatus = deviceStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.activeTime = activeTime;
        this.logoutTime = logoutTime;
        this.netStatus = netStatus;
        this.onlineAt = onlineAt;
        this.offlineAt = offlineAt;
        this.productProtocol = productProtocol;
    }

    public String getDeviceSn() {
        return deviceSn;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getTenantId() {
        return tenantId;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public Integer getDeviceStatus() {
        return deviceStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Date getActiveTime() {
        return activeTime;
    }

    public Date getLogoutTime() {
        return logoutTime;
    }

    public Integer getNetStatus() {
        return netStatus;
    }

    public Long getOnlineAt() {
        return onlineAt;
    }

    public Long getOfflineAt() {
        return offlineAt;
    }

    public Integer getProductProtocol() {
        return productProtocol;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    public void setDeviceStatus(Integer deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    public void setNetStatus(Integer netStatus) {
        this.netStatus = netStatus;
    }

    public void setOnlineAt(Long onlineAt) {
        this.onlineAt = onlineAt;
    }

    public void setOfflineAt(Long offlineAt) {
        this.offlineAt = offlineAt;
    }

    public void setProductProtocol(Integer productProtocol) {
        this.productProtocol = productProtocol;
    }
}
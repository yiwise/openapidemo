package com.yiwise.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

public class RobotCallJobPO implements Serializable {
    /**
     * BIGINT(19) 必填
     * 任务id
     */
    private Long robotCallJobId;

    /**
     * BIGINT(19) 必填
     * 租户id
     */
    private Long tenantId;

    /**
     * BIGINT(19) 必填
     * 话术id
     */
    private Long dialogFlowId;

    /**
     * VARCHAR(50) 必填
     * 任务名
     */
    private String name;

    /**
     * TINYINT(3) 必填
     * 启动方式 1: 自动任务 2: 手动任务
     */
    private String mode;

    /**
     * INTEGER(10) 必填
     * 占用机器人坐席总数
     */
    private Integer robotCount;

    /**
     * INTEGER(10)
     * 短信模板id。
     */
    private Long smsTemplateId;

    private String phoneType;

    /**
     * TIME(8) 必填
     * 每天开始的时间
     */
    private LocalTime dailyStartTime;

    /**
     * TIME(8) 必填
     * 每天结束的时间
     */
    private LocalTime dailyEndTime;

    /**
     * TIME(8) 默认值[00:00:00] 必填
     * 每天午休暂停开始时间
     */
    private LocalTime inactiveStartTime;

    /**
     * TIME(8) 默认值[00:00:00] 必填
     * 每天午休暂停结束时间
     */
    private LocalTime inactiveEndTime;

    /**
     * VARCHAR(1000)
     * 任务描述信息
     */
    private String description;

    /**
     * VARCHAR(20) 默认值[[]] 必填
     * 微信提醒等级。
     */
    private Set<String> wechatAlertLevel;

    /**
     * VARCHAR(20) 默认值[[]] 必填
     * 短信提醒等级。
     */
    private Set<String> smsAlertLevel;

    /**
     * VARCHAR(20) 默认值[[]] 必填
     * 微信、短信推送至的人的id列表
     */
    private Set<Long> alertUsers;

    /**
     * int(5) 默认值[0] 必填
     * 微信推送方式（0全推送/1单推送/2不推送）
     */
    private String wechatSendMethod;

    /**
     * TINYINT(3) 必填
     * 任务状态
     */
    private String status;

    /**
     * TINYINT(4) 必填
     * 任务是否删除
     */
    private Boolean deleted;

    /**
     * TIMESTAMP(19)
     * 任务开始时间 1. 手动任务，就是手动任务点击开始的时间 2. 自动任务，就是用户设置的开始日期
     */
    private LocalDateTime startTime;

    /**
     * BIGINT(19) 必填
     * 创建人id
     */
    private Long createdByUserId;

    /**
     * BIGINT(19)
     * 更新人id
     */
    private Long lastModifiedByUserId;

    /**
     * VARCHAR(32)
     * 任务运行所在服务器IP地址
     */
    private String ipAddress;

    /**
     * VARCHAR(32)
     * 任务运行所在服务器主机名
     */
    private String hostname;

    /**
     * TIME(8) 必填
     * 任务下次开始时间，默认值为daily_start_time
     */
    private LocalTime nextStartTime;

    /**
     * INTEGER(10) 默认值[0] 必填
     * 任务抢占版本号
     */
    private Integer versionNumber;

    /**
     * TIMESTAMP(19)
     * 任务首次运行时间
     */
    private LocalDate firstStartDate;

    /**
     * TIMESTAMP(19) 默认值[CURRENT_TIMESTAMP]
     * 任务最后一次更新心跳的时间
     */
    private LocalDateTime lastHeartBeatTime;
    /**
     * 创建时间
     */
    private LocalDateTime creationTime;
    /**
     * 最近修改时间
     */
    private LocalDateTime lastModifiedTime;

    /**
     * VARCHAR(100) 默认值[[]]
     * 行业预警推送至的人的id列表
     */
    private Set<Long> earlyWarningAlertUsers;

    public Long getRobotCallJobId() {
        return robotCallJobId;
    }

    public void setRobotCallJobId(Long robotCallJobId) {
        this.robotCallJobId = robotCallJobId;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getDialogFlowId() {
        return dialogFlowId;
    }

    public void setDialogFlowId(Long dialogFlowId) {
        this.dialogFlowId = dialogFlowId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Integer getRobotCount() {
        return robotCount;
    }

    public void setRobotCount(Integer robotCount) {
        this.robotCount = robotCount;
    }

    public Long getSmsTemplateId() {
        return smsTemplateId;
    }

    public void setSmsTemplateId(Long smsTemplateId) {
        this.smsTemplateId = smsTemplateId;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public LocalTime getDailyStartTime() {
        return dailyStartTime;
    }

    public void setDailyStartTime(LocalTime dailyStartTime) {
        this.dailyStartTime = dailyStartTime;
    }

    public LocalTime getDailyEndTime() {
        return dailyEndTime;
    }

    public void setDailyEndTime(LocalTime dailyEndTime) {
        this.dailyEndTime = dailyEndTime;
    }

    public LocalTime getInactiveStartTime() {
        return inactiveStartTime;
    }

    public void setInactiveStartTime(LocalTime inactiveStartTime) {
        this.inactiveStartTime = inactiveStartTime;
    }

    public LocalTime getInactiveEndTime() {
        return inactiveEndTime;
    }

    public void setInactiveEndTime(LocalTime inactiveEndTime) {
        this.inactiveEndTime = inactiveEndTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<String> getWechatAlertLevel() {
        return wechatAlertLevel;
    }

    public void setWechatAlertLevel(Set<String> wechatAlertLevel) {
        this.wechatAlertLevel = wechatAlertLevel;
    }

    public Set<String> getSmsAlertLevel() {
        return smsAlertLevel;
    }

    public void setSmsAlertLevel(Set<String> smsAlertLevel) {
        this.smsAlertLevel = smsAlertLevel;
    }

    public Set<Long> getAlertUsers() {
        return alertUsers;
    }

    public void setAlertUsers(Set<Long> alertUsers) {
        this.alertUsers = alertUsers;
    }

    public String getWechatSendMethod() {
        return wechatSendMethod;
    }

    public void setWechatSendMethod(String wechatSendMethod) {
        this.wechatSendMethod = wechatSendMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Long getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(Long createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public Long getLastModifiedByUserId() {
        return lastModifiedByUserId;
    }

    public void setLastModifiedByUserId(Long lastModifiedByUserId) {
        this.lastModifiedByUserId = lastModifiedByUserId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public LocalTime getNextStartTime() {
        return nextStartTime;
    }

    public void setNextStartTime(LocalTime nextStartTime) {
        this.nextStartTime = nextStartTime;
    }

    public Integer getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(Integer versionNumber) {
        this.versionNumber = versionNumber;
    }

    public LocalDate getFirstStartDate() {
        return firstStartDate;
    }

    public void setFirstStartDate(LocalDate firstStartDate) {
        this.firstStartDate = firstStartDate;
    }

    public LocalDateTime getLastHeartBeatTime() {
        return lastHeartBeatTime;
    }

    public void setLastHeartBeatTime(LocalDateTime lastHeartBeatTime) {
        this.lastHeartBeatTime = lastHeartBeatTime;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public LocalDateTime getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(LocalDateTime lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public Set<Long> getEarlyWarningAlertUsers() {
        return earlyWarningAlertUsers;
    }

    public void setEarlyWarningAlertUsers(Set<Long> earlyWarningAlertUsers) {
        this.earlyWarningAlertUsers = earlyWarningAlertUsers;
    }
}
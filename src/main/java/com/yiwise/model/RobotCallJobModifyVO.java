package com.yiwise.model;

import java.util.List;

/**
 * @Author zqy
 * @Date 2018/7/26
 **/
public class RobotCallJobModifyVO {
    private RobotCallJobPO robotCallJob;
    private List<LongStringBO> jobPhoneNumberList;      // key为tenant_phone_number_id， val是线路号码

    public RobotCallJobPO getRobotCallJob() {
        return robotCallJob;
    }

    public void setRobotCallJob(RobotCallJobPO robotCallJob) {
        this.robotCallJob = robotCallJob;
    }

    public List<LongStringBO> getJobPhoneNumberList() {
        return jobPhoneNumberList;
    }

    public void setJobPhoneNumberList(List<LongStringBO> jobPhoneNumberList) {
        this.jobPhoneNumberList = jobPhoneNumberList;
    }
}

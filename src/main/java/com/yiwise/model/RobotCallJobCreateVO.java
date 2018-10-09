package com.yiwise.model;

/**
 * @author annpeter.it@gmail.com
 * @date 24/07/2018
 */
public class RobotCallJobCreateVO extends RobotCallJobModifyVO {
    private String jobTasksFileUrl;

    public String getJobTasksFileUrl() {
        return jobTasksFileUrl;
    }

    public void setJobTasksFileUrl(String jobTasksFileUrl) {
        this.jobTasksFileUrl = jobTasksFileUrl;
    }
}

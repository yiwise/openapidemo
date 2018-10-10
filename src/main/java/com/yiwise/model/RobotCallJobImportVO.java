package com.yiwise.model;


import java.util.List;

/**
 * @Author zqy
 * @Date 2018/10/8
 **/
public class RobotCallJobImportVO {
    private Long tenantId;
    private Long robotCallJobId;
    private List<CustomerPersonImportVO> customerPersons;

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getRobotCallJobId() {
        return robotCallJobId;
    }

    public void setRobotCallJobId(Long robotCallJobId) {
        this.robotCallJobId = robotCallJobId;
    }

    public List<CustomerPersonImportVO> getCustomerPersons() {
        return customerPersons;
    }

    public void setCustomerPersons(List<CustomerPersonImportVO> customerPersons) {
        this.customerPersons = customerPersons;
    }
}

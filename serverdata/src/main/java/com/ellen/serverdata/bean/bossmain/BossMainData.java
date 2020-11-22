package com.ellen.serverdata.bean.bossmain;

import java.util.List;

public class BossMainData {
    /**
     * 公司职位类型
     */
    private String jobType;
    /**
     * 公司标签
     */
    private List<String> tags;
    /**
     * 公司名
     */
    private String companyName;
    /**
     * 公司融资状态
     */
    private String status;
    /**
     * 公司规模
     */
    private String scale;
    /**
     * 工资下限
     * 8k
     */
    private int wageLowerLimit;
    /**
     * 工资上限
     */
    private int wageUpperLimit;
    /**
     * 公司地址
     */
    private String address;


    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public int getWageLowerLimit() {
        return wageLowerLimit;
    }

    public void setWageLowerLimit(int wageLowerLimit) {
        this.wageLowerLimit = wageLowerLimit;
    }

    public int getWageUpperLimit() {
        return wageUpperLimit;
    }

    public void setWageUpperLimit(int wageUpperLimit) {
        this.wageUpperLimit = wageUpperLimit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

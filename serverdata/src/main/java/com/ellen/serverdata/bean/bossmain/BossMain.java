package com.ellen.serverdata.bean.bossmain;

import java.util.List;

public class BossMain {
    private List<BossMainData> company;
    private int isHaveNextPage;

    public List<BossMainData> getCompany() {
        return company;
    }

    public void setCompany(List<BossMainData> company) {
        this.company = company;
    }

    public int getIsHaveNextPage() {
        return isHaveNextPage;
    }

    public void setIsHaveNextPage(int isHaveNextPage) {
        this.isHaveNextPage = isHaveNextPage;
    }
}

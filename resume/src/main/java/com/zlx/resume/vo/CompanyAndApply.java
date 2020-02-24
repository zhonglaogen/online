package com.zlx.resume.vo;

import com.zlx.resume.entity.Company;
import com.zlx.resume.myentity.CompanyApply;

/**
 * @Description: 公司和申请的包装类
 * @author: zhonglianxi
 * @date: 2020-02-20
 */

public class CompanyAndApply {
    private Company company;
    private CompanyApply companyApply;

    public CompanyAndApply() {
    }

    public CompanyAndApply(Company company, CompanyApply companyApply) {
        this.company = company;
        this.companyApply = companyApply;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public CompanyApply getCompanyApply() {
        return companyApply;
    }

    public void setCompanyApply(CompanyApply companyApply) {
        this.companyApply = companyApply;
    }
}

package com.zlx.resume.mymapper;

import com.zlx.resume.entity.Companyuser;
import com.zlx.resume.myentity.CompanyApply;

import java.util.List;

public interface ApplyMapper {
    /**
     * 插入关联申请
     * @param companyApply
     */
    void insertApply(CompanyApply companyApply);

    /**
     * 查看本人所有申请结果,本人会提交很多次申请
     * @param companyuser
     * @return
     */
    List<CompanyApply> findApply(Companyuser companyuser);

}

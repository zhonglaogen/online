package com.zlx.resume.mapper;

import com.zlx.resume.entity.Companyuser;
import com.zlx.resume.entity.CompanyuserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyuserMapper {
    int countByExample(CompanyuserExample example);

    int deleteByExample(CompanyuserExample example);

    int deleteByPrimaryKey(Integer cuId);

    int insert(Companyuser record);

    int insertSelective(Companyuser record);

    List<Companyuser> selectByExample(CompanyuserExample example);

    Companyuser selectByPrimaryKey(Integer cuId);

    int updateByExampleSelective(@Param("record") Companyuser record, @Param("example") CompanyuserExample example);

    int updateByExample(@Param("record") Companyuser record, @Param("example") CompanyuserExample example);

    int updateByPrimaryKeySelective(Companyuser record);

    int updateByPrimaryKey(Companyuser record);
}
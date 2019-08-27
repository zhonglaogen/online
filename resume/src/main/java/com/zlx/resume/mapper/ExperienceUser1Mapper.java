package com.zlx.resume.mapper;

import com.zlx.resume.entity.ExperienceUser1;
import com.zlx.resume.entity.ExperienceUser1Example;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExperienceUser1Mapper {
    int countByExample(ExperienceUser1Example example);

    int deleteByExample(ExperienceUser1Example example);

    int deleteByPrimaryKey(Integer eId);

    int insert(ExperienceUser1 record);

    int insertSelective(ExperienceUser1 record);

    List<ExperienceUser1> selectByExample(ExperienceUser1Example example);

    ExperienceUser1 selectByPrimaryKey(Integer eId);

    int updateByExampleSelective(@Param("record") ExperienceUser1 record, @Param("example") ExperienceUser1Example example);

    int updateByExample(@Param("record") ExperienceUser1 record, @Param("example") ExperienceUser1Example example);

    int updateByPrimaryKeySelective(ExperienceUser1 record);

    int updateByPrimaryKey(ExperienceUser1 record);
}
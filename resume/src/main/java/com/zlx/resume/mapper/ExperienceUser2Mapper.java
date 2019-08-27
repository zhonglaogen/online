package com.zlx.resume.mapper;

import com.zlx.resume.entity.ExperienceUser2;
import com.zlx.resume.entity.ExperienceUser2Example;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExperienceUser2Mapper {
    int countByExample(ExperienceUser2Example example);

    int deleteByExample(ExperienceUser2Example example);

    int deleteByPrimaryKey(Integer eId);

    int insert(ExperienceUser2 record);

    int insertSelective(ExperienceUser2 record);

    List<ExperienceUser2> selectByExample(ExperienceUser2Example example);

    ExperienceUser2 selectByPrimaryKey(Integer eId);

    int updateByExampleSelective(@Param("record") ExperienceUser2 record, @Param("example") ExperienceUser2Example example);

    int updateByExample(@Param("record") ExperienceUser2 record, @Param("example") ExperienceUser2Example example);

    int updateByPrimaryKeySelective(ExperienceUser2 record);

    int updateByPrimaryKey(ExperienceUser2 record);
}
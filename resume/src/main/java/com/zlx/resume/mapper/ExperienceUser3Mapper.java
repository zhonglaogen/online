package com.zlx.resume.mapper;

import com.zlx.resume.entity.ExperienceUser3;
import com.zlx.resume.entity.ExperienceUser3Example;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExperienceUser3Mapper {
    int countByExample(ExperienceUser3Example example);

    int deleteByExample(ExperienceUser3Example example);

    int deleteByPrimaryKey(Integer eId);

    int insert(ExperienceUser3 record);

    int insertSelective(ExperienceUser3 record);

    List<ExperienceUser3> selectByExample(ExperienceUser3Example example);

    ExperienceUser3 selectByPrimaryKey(Integer eId);

    int updateByExampleSelective(@Param("record") ExperienceUser3 record, @Param("example") ExperienceUser3Example example);

    int updateByExample(@Param("record") ExperienceUser3 record, @Param("example") ExperienceUser3Example example);

    int updateByPrimaryKeySelective(ExperienceUser3 record);

    int updateByPrimaryKey(ExperienceUser3 record);
}
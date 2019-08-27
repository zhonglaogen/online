package com.zlx.resume.mapper;

import com.zlx.resume.entity.User3;
import com.zlx.resume.entity.User3Example;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface User3Mapper {
    int countByExample(User3Example example);

    int deleteByExample(User3Example example);

    int deleteByPrimaryKey(Integer uId);

    int insert(User3 record);

    int insertSelective(User3 record);

    List<User3> selectByExample(User3Example example);

    User3 selectByPrimaryKey(Integer uId);

    int updateByExampleSelective(@Param("record") User3 record, @Param("example") User3Example example);

    int updateByExample(@Param("record") User3 record, @Param("example") User3Example example);

    int updateByPrimaryKeySelective(User3 record);

    int updateByPrimaryKey(User3 record);
}
package com.zlx.resume.mapper;

import com.zlx.resume.entity.User1;
import com.zlx.resume.entity.User1Example;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface User1Mapper {
    int countByExample(User1Example example);

    int deleteByExample(User1Example example);

    int deleteByPrimaryKey(Integer uId);

    int insert(User1 record);

    int insertSelective(User1 record);

    List<User1> selectByExample(User1Example example);

    User1 selectByPrimaryKey(Integer uId);

    int updateByExampleSelective(@Param("record") User1 record, @Param("example") User1Example example);

    int updateByExample(@Param("record") User1 record, @Param("example") User1Example example);

    int updateByPrimaryKeySelective(User1 record);

    int updateByPrimaryKey(User1 record);
}
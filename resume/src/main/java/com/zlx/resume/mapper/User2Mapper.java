package com.zlx.resume.mapper;

import com.zlx.resume.entity.User2;
import com.zlx.resume.entity.User2Example;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface User2Mapper {
    int countByExample(User2Example example);

    int deleteByExample(User2Example example);

    int deleteByPrimaryKey(Integer uId);

    int insert(User2 record);

    int insertSelective(User2 record);

    List<User2> selectByExample(User2Example example);

    User2 selectByPrimaryKey(Integer uId);

    int updateByExampleSelective(@Param("record") User2 record, @Param("example") User2Example example);

    int updateByExample(@Param("record") User2 record, @Param("example") User2Example example);

    int updateByPrimaryKeySelective(User2 record);

    int updateByPrimaryKey(User2 record);
}
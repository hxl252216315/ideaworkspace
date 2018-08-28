package com.computech.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.computech.pojo.User;

@Mapper
@Repository
public interface UserMapper {
    
    int deleteByPrimaryKey(Integer custNo);
    
    int insert(User record);
    
    int insertSelective(User record);
   
    User selectByPrimaryKey(Integer custNo);

    int updateByPrimaryKeySelective(User record);
    
    int updateByPrimaryKey(User record);
    
    List<User> selectByUser(@Param("index") int index, @Param("pageSize") int pageSize);
}
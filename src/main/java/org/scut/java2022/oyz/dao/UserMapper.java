package org.scut.java2022.oyz.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.scut.java2022.oyz.entity.User;

public interface UserMapper {
    @Select("select * from sys_user where user_name=#{userName}")
    @Results({
            @Result(property="userName", column="user_name"),
            @Result(property="password", column="password"),
            @Result(property="nickName", column="nick_name")
    })
    User queryUserByName(String userName);

    @Insert("insert into sys_user(user_name,password,nick_name) values(#{userName},#{password},#{nickName})")
    void insertUser(User user);
}

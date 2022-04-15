package org.scut.java2022.oyz.service.impl;

import org.scut.java2022.oyz.dao.UserMapper;
import org.scut.java2022.oyz.dto.Result;
import org.scut.java2022.oyz.entity.User;
import org.scut.java2022.oyz.service.UserService;
import org.scut.java2022.oyz.util.Jwt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {
    /**
     * 状态码
     * 1000: 成功
     * 1001: token过期, 1002: 非法token
     * 2001: 用户密码错误, 2002: 用户不存在, 2003: 用户参数缺失
     * 3001: 信息不存在
     */
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;


    public Result login(User user) {
        Result result = new Result();

        if (user != null) {
            User queryUser = userMapper.queryUserByName(user.getUserName());

            if (queryUser != null ) {
                logger.debug("found user: {}", queryUser);
                // 数据库密码字段为空表示不需要密码登录
                // 若不为空则比较密码是否正确
                if (queryUser.getPassword() == null || queryUser.getPassword().equals(user.getPassword())) {
                    HashMap<String, String> map =  new HashMap  <>();
                    map.put("userName", user.getUserName());
                    map.put("password", user.getPassword());
                    map.put("nickName", user.getNickName());
                    String token  = Jwt.getToken(map);
                    logger.debug("userName:"+user.getUserName()+",userName:"+token);
                    result.setCode("1000");
                    result.setMsg(user+"登录成功");
                    result.setData(user);
                    result.setToken(token);
                } else {
                    logger.error("wrong password");
                    result.setCode("2001");
                    result.setMsg("密码错误");
                }
            } else {
                logger.error("user not exists: {}", user);
                result.setCode("2002");
                result.setMsg("用户不存在");
            }
        } else {
            logger.error("null pointer user");
            result.setCode("2003");
            result.setMsg("请求用户参数缺失");
        }



        return result;
    }


    public Result register(User user) {
        Result result = new Result();
        if(userMapper.queryUserByName(user.getUserName())!=null){
            result.setCode("2004");
            result.setMsg(user+"已存在");
            result.setData(user);
            logger.error("User already exist: {}", user);
            return result;
        }
        userMapper.insertUser(user);
        if (userMapper.queryUserByName(user.getUserName()) != null) {
            result.setCode("1000");
            result.setMsg(user+"注册成功");
            result.setData(user);
            logger.debug("register user: {}", user);
        }
        else {
            result.setCode("3001");
            result.setMsg(user+"注册失败");
            logger.error("register default user: {}", user);
        }

        return result;
    }
}

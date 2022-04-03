package org.scut.java2022.oyz.service;

import org.scut.java2022.oyz.dto.Result;
import org.scut.java2022.oyz.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    //用户登录
    public Result login(User user);

    public Result register(User user);
}

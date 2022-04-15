package org.scut.java2022.oyz.interceptor;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.scut.java2022.oyz.dto.Result;
import org.scut.java2022.oyz.util.Jwt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@Component
public class JwtTokenInterceptor implements HandlerInterceptor {
    /**
     * 状态码
     * 1000: 成功
     * 1001: token过期, 1002: 非法token
     * 2001: 用户密码错误, 2002: 用户不存在, 2003: 用户参数缺失
     * 3001: 信息不存在
     */

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 在拦截器中，如果请求为OPTIONS请求，则返回true，表示可以正常访问，然后就会收到真正的GET/POST请求
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            System.out.println("OPTIONS请求，放行");
            return true;
        }
        // 验证token
        String token = request.getHeader("token");

        Result rs = new Result();
        try {
            // 验证token
            DecodedJWT jwt = Jwt.verify(token);
            jwt.equals(token);
            return true;
        } catch (TokenExpiredException e) {
            rs.setCode("1001");
            rs.setMsg("token过期");
            logger.warn("token过期");
        } catch (Exception e) {
            rs.setCode("1002");
            rs.setMsg("非法token");
            logger.warn("token无效");
        }
        response.setStatus(403);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(rs.toString());
        return false;
    }

}

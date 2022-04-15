package org.scut.java2022.oyz.config;
import org.scut.java2022.oyz.interceptor.JwtTokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class JwtTokenInterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private JwtTokenInterceptor authorizationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截规则
        InterceptorRegistration ir = registry.addInterceptor(authorizationInterceptor);
        // 不拦截路径，如：注册、登录等
        ir.excludePathPatterns("/api/user/login", "/api/user/register");
        // 拦截路径，开放api请求的路径都拦截
        ir.addPathPatterns("/api/**");
    }
}

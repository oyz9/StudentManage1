package org.scut.java2022.oyz.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Map;

public class Jwt {

    private static final Logger logger = LoggerFactory.getLogger(Jwt.class);

    //通过有效时间
    private static int days = 1;

    //密钥
    private static String SecretKey = "oyz";

    /**
     *  生成token header.payload.sing
     */
    public static String getToken(Map<String,String> map){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE,days);
        //创建jwt builder
        JWTCreator.Builder builder = JWT.create();
        //payload
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });
        //生成token，头部默认jwt和Base64编码
        String token = builder.withExpiresAt(instance.getTime())   //设置过期时间
                .sign(Algorithm.HMAC256(SecretKey));		//加密算法和密钥
        return token;
    }

    /**
     * 验证 token 合法性
     */
    public static DecodedJWT verify(String token){
        logger.debug("verify token:"+token);
        return JWT.require(Algorithm.HMAC256(SecretKey)).build().verify(token);
    }

}


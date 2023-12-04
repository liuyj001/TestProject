package com.xxx.jwt;

import com.alibaba.fastjson.JSON;
import com.xxx.entity.UserSub;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author lei
 * @version 1.0
 * @date 2020/11/28 17:43
 * @desc
 */
@Service
public class JwtSupport {
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expireTime}")
    private Long expireTime;

    /**
     * 生成token
     *
     * @param payload 载荷
     * @return 返回token
     */
    public String buildToken(UserSub payload) {
//        JWTCreator.Builder jwt = JWT.create();
//        // 设置payload
//        jwt.withSubject(JSON.toJSONString(payload));
//        // 设置过期时间
//        jwt.withExpiresAt(new Date(System.currentTimeMillis() + expireTime * 60 * 60 * 1000));
//        return jwt.sign(Algorithm.HMAC256(secret));

        // 生成 JWT
        return Jwts.builder()
                .setSubject(JSON.toJSONString(payload))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expireTime * 60 * 60 * 1000))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    /**
     * 验证token
     *
     * @param token
     * @return
     */
    public Claims verify(String token)  {
        //        JWT.require(Algorithm.HMAC256(secret)).build().verify(token);
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return claims;
    }

    /**
     * 获取token中payload
     *
     * @param jwt
     * @return
     */
    public UserSub parseJwt(String jwt) throws Exception {
//        DecodedJWT decodedJwt = JWT.require(Algorithm.HMAC256(secret)).build().verify(jwt);
//        String subject = decodedJwt.getSubject();

        // 解码 JWT
        Claims claims = verify(jwt);
        return JSON.parseObject(claims.getSubject(), UserSub.class);
    }
}

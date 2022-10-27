package boke.boke.util;

import com.alibaba.druid.util.StringUtils;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import javax.servlet.http.Cookie;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * 此类是一个工具类
 * JwtUtil是生成、解析、验证token的工具类
 */
public class JWTUtil {
    // 过期时间 6分钟
    private static final long EXPIRE_TIME = 60 * 60 * 1000;
    // 密钥
    private static final String SECRET = "SHIRO+JWT";

    /**
     * 生成 token,  6min后过期
     * @param subject 用户id
     * @param password 密码
     * @return 加密的token
     */
    public static String createToken(String subject,String name,String password) {
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(SECRET);

            JWTCreator.Builder builder = JWT.create()
                    .withIssuer(UtilTools.JWT_ISSUER)
                    .withClaim("username",name)
                    .withClaim("pwass",password)
                    .withSubject(subject)
                    //到期时间
                    .withExpiresAt(date);
            //创建一个新的JWT，并使用给定的算法进行标记
            return builder.sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 校验 token 是否正确
     *
     * @param token    密钥
     * @param userName 用户名
     * @return 是否正确
     */
    public static boolean verify(String token, String userName,String password) {
    /*        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            //在token中附带了userName信息
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(UtilTools.JWT_ISSUER)
                    .build();
            //验证 token
            verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }*/
        try {
            // Algorithm algorithm = Algorithm.HMAC256(SECRET);
            DecodedJWT jwt = JWT.decode(token);
            String uname = jwt.getClaim("username").asString();
            String upwd = jwt.getClaim("pwass").asString();
            Date expiresAt = jwt.getExpiresAt();
            //判断token是否过期
            if (new Date().getTime()>expiresAt.getTime()){
                return false;
            }
            if (uname.equals(userName) && upwd.equals(password)){
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 校验 token的密码是否正确
     * @param token
     * @param password
     * @return
     */
    public static boolean verifyon2(String token,String password) {
        try {
            // Algorithm algorithm = Algorithm.HMAC256(SECRET);
            DecodedJWT jwt = JWT.decode(token);//解析token
            String upwd = jwt.getClaim("pwass").asString();//获取token中的密码
            if (upwd.equals(password)){
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 获得token中的信息，无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getUsername(String token,String key) {
        try {
           // Algorithm algorithm = Algorithm.HMAC256(SECRET);
            DecodedJWT jwt = JWT.decode(token);
            System.out.print("当前用户id="+jwt.getSubject());
            return jwt.getClaim(key).asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
    //获取token中的用户编号
    public static String getUserid(String token) {
        try {
            // Algorithm algorithm = Algorithm.HMAC256(SECRET);
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getSubject();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 检测token是否过期
     * @param token
     * @return
     */
    public static boolean getexceedmin(String token) {
        if (!StringUtils.isEmpty(token)){
        DecodedJWT jwt = JWT.decode(token);
        Date expiresAt = jwt.getExpiresAt();
        //判断token是否过期
        if (new Date().getTime()>expiresAt.getTime()){
            return false;
        }
        }
        return true;
    }

    /***
     *查找指定名称的 Cookie 对象
     * @param name
     * @param cookies
     * @return
     *  */
    public static Cookie findCookie(String name , Cookie[] cookies){
        if (name == null || cookies == null || cookies.length == 0) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }

}

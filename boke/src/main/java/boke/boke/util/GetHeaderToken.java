package boke.boke.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class GetHeaderToken {


    //获得当前HttpServletRequest对象
    public static HttpServletRequest getRequest(){
        return ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
    }

    //获取heard中的参数
    //getRequestHeaderMap.get("xxx")方法获取请求头中的参数;
    public static Map<String, String> getRequestHeaderMap() {
        HttpServletRequest request = getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        Map<String, String> headerMap = new HashMap<>(8);
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            headerMap.put(name, request.getHeader(name));
        }
        return headerMap;
    }
    //获取cookie中的参数
    public static String getRequestCookie(String tokenname) {
        HttpServletRequest request = getRequest();
        Cookie baitoken = JWTUtil.findCookie("baitoken", request.getCookies());
        String token= baitoken.getValue();
        return token;
    }



}

package boke.boke.util;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

public class logUtil {
    /**
     * 描述：获取IP地址
     */
    public static String getIpAddress() {
        HttpServletRequest request = GetHeaderToken.getRequest();
        String ip = request.getHeader("x-forwarded-for");

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

            ip = request.getRemoteAddr();
        }
        return ip;
    }
}

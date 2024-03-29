package boke.boke.JWT;

import boke.boke.realm.UserRealm;
import boke.boke.util.JWTUtil;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Enumeration;

/**
 * 此类是实现BasicHttpAuthenticationFilter类的过滤器
 * 过滤器中主要实现了这四个方法isLoginAttempt、executeLogin、isAccessAllowed、preHandle
 */
public class JwtFilter extends BasicHttpAuthenticationFilter{
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 判断用户是否想要登入。
     * 检测 header 里面是否包含 Token 字段
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        //改为cookie存储获取token 2022-10-20改
        //String token = req.getHeader("baitoken");
        Cookie baitoken = JWTUtil.findCookie("baitoken", req.getCookies());
        String token= baitoken.getValue();
        //判断token是否过期(为空或过期时会返回false)
        return JWTUtil.getexceedmin(token);
    }
    /**z
     * 执行登录操作
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        //改为cookie存储获取token 2022-10-20改
        //String token = httpServletRequest.getHeader("baitoken");
        Cookie baitoken = JWTUtil.findCookie("baitoken", req.getCookies());
        String token= baitoken.getValue();
        JwtToken jwtToken = new JwtToken(token);
        // 提交给realm进行登入，如果错误他会抛出异常并被捕获
        getSubject(request, response).login(jwtToken);
        // 如果没有抛出异常则代表登入成功，返回true
        return true;
    }

     /**
      * 验证权限，登录成功即表示拥有访问系统资源的权限，具体的资源权限会在shiro中进行鉴权
      * 如果带有 token，则对 token 进行检查，否则直接通过
      * ===========================================================
      * 这里我们详细说明下为什么最终返回的都是true，即允许访问
      *  例如我们提供一个地址 GET /article
      * 登入用户和游客看到的内容是不同的
      * 如果在这里返回了false，请求会被直接拦截，用户看不到任何东西
      * 所以我们在这里返回true，Controller中可以通过 subject.isAuthenticated() 来判断用户是否登入
      * 如果有些资源只有登入用户才能访问，我们只需要在方法上面加上 @RequiresAuthentication 注解即可
      * 但是这样做有一个缺点，就是不能够对GET,POST等请求进行分别过滤鉴权(因为我们重写了官方的方法)，但实际上对应用影响不大
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        //放行该请求
        if(httpServletRequest.getMethod().equalsIgnoreCase("OPTIONS")) {
            return true;
        }
        //判断请求的请求头是否带上 "Token"
        if (isLoginAttempt(request, response)) {
            //如果存在，则进入 executeLogin 方法执行登入，检查 token 是否正确
            try {
                executeLogin(request, response);
                return true;

            } catch (Exception e) {
                e.printStackTrace();
                //token 错误
                responseError(response, e.getMessage());
            }
        }
        //如果请求头不存在 Token，则可能是执行登陆操作或者是游客状态访问，无需检查 token，直接返回 true
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        try {
            httpServletResponse.sendRedirect("/login");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * 对跨域提供支持
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }
    /**
     * 将非法请求跳转到 错误页面
     */
    private void responseError(ServletResponse response, String message) {
        try {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            //设置编码，否则中文字符在重定向时会变为空字符串
            message = URLEncoder.encode(message, "UTF-8");
            httpServletResponse.sendRedirect("/errors/" + message);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

}

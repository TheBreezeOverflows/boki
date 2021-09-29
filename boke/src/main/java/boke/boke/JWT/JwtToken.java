package boke.boke.JWT;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * 此类实现AuthenticationToken这个类
 * 作用是：Shiro的用户验证token替换为基于JWT生成的toekn
 */
public class JwtToken implements AuthenticationToken {
    private  String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}

package boke.boke.realm;

import boke.boke.JWT.JwtToken;
import boke.boke.entity.User;
import boke.boke.service.UserInfo;
import boke.boke.util.JWTUtil;
import boke.boke.util.UtilTools;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.AllowAllCredentialsMatcher;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserRealm extends AuthorizingRealm {


    @Autowired
    private UserInfo UserService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    public  UserRealm() {
        //因为数据库中的密码做了散列，所以使用shiro的散列Matcher
        this.setCredentialsMatcher(new HashedCredentialsMatcher(Sha256Hash.ALGORITHM_NAME));
    }


    /**
     * 授权
     * @param principalCollection 当前用户对象
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("————权限认证————");
        String username = JWTUtil.getUsername(principalCollection.toString(),"username");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获得该用户权限
        String permission = UserService.UserPermission(username);
        //每个用户可以设置新的权限
        Set<String> permissionSet = new HashSet<>();
        //需要将 role, permission 封装到 Set 作为 info.setRoles(), info.setStringPermissions() 的参数
        permissionSet.add(permission);
        //设置该用户拥有的角色和权限
        info.setStringPermissions(permissionSet);
        return info;
    }


    /**
     * 验证
     * @param authenticationToken 前端验证对象
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("---登录验证---");
        String token = (String) authenticationToken.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUsername(token,"username");
        String password = new String(UserService.Userpwass(username).toCharArray());
        if (password == null || !JWTUtil.verify(token, username,password)) {
            throw new AuthenticationException("token认证失败！");
        }
        //根据用户名和密码查询用户
        User user = UserService.login(username,password);
        return new SimpleAuthenticationInfo(user, user.getUserUserPassword(), ByteSource.Util.bytes(UtilTools.Salt()), this.getName());
    }
    @Override
    protected void assertCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo info) throws AuthenticationException {
        CredentialsMatcher cm = this.getCredentialsMatcher();
        if (cm != null) {
            String token=(String) authenticationToken.getCredentials();
            String pwd=info.getCredentials().toString();
            if (!JWTUtil.verifyon2(token,pwd)) {//这里是调用了自定义方法验证验证密码
                String msg = "Submitted credentials for token [" + token + "] did not match the expected credentials.";
                throw new IncorrectCredentialsException(msg);
            }
        } else {
            throw new AuthenticationException("A CredentialsMatcher must be configured in order to verify credentials during authentication.  If you do not wish for credentials to be examined, you can configure an " + AllowAllCredentialsMatcher.class.getName() + " instance.");
        }
    }

}


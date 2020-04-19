package com.xt.realm;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SaltedAuthenticationInfo;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.xt.pojo.Users;
import com.xt.service.UsersService;

public class UserRealm extends AuthorizingRealm{
	@Autowired
	UsersService service;
	
	@Override
    public String getName() {
    	return "UserRealm";
    }
	//获取用户的密码信息的方法
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = token.getPrincipal().toString();
		//根据用户名获取用户对象信息(加密密码和盐值)
		Users user = service.selectByName(username);
		if(user==null) {
			throw new UnknownAccountException();//账号不正确的异常
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getU_name(), user.getU_password(),
                ByteSource.Util.bytes(user.getSalt()), getName());
		return info;
	}
	
	//获取用户权限和角色的方法
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//1:获取当前用户的用户名
		String username = principals.getPrimaryPrincipal().toString();
		//2:根据用户名访问数据库，获取用户拥有的所有的权限名称，类别为1表的CURD
		List<String> permissions = service.selectPermissions(username);
		//3:封装成权限信息对象返回
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		info.addStringPermissions(permissions);
		return info;		
	}
}

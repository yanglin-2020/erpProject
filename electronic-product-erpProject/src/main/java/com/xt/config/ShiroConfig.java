package com.xt.config;

import java.util.LinkedHashMap;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.xt.realm.UserRealm;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

@Configuration
public class ShiroConfig {

	@Bean(name = "shirFilter")
	public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		// 必须设置 SecurityManager,Shiro的核心安全接口
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// 这里的/login是后台的接口名,非页面，如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
		shiroFilterFactoryBean.setLoginUrl("/Userlogin");
		// 这里的/index是后台的接口名,非页面,登录成功后要跳转的链接
		//shiroFilterFactoryBean.setSuccessUrl("/index");
		// 未授权界面,该配置无效，并不会进行页面跳转
		//shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");
		// 自定义拦截器限制并发人数,参考博客：
		// LinkedHashMap<String, Filter> filtersMap = new LinkedHashMap<>();
		// 限制同一帐号同时在线的个数
		// filtersMap.put("kickout", kickoutSessionControlFilter());
		// shiroFilterFactoryBean.setFilters(filtersMap);
		// 配置访问权限 必须是LinkedHashMap，因为它必须保证有序
		// 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 一定要注意顺序,否则就不好使了
		LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
		// 配置不登录可以访问的资源，anon 表示资源都可以匿名访问
		filterChainDefinitionMap.put("/Userlogin", "anon");
		filterChainDefinitionMap.put("/loginUser", "anon");
		filterChainDefinitionMap.put("/durid/login.html", "anon");
		filterChainDefinitionMap.put("/css/**", "anon");
		filterChainDefinitionMap.put("/forget.html", "anon");
		filterChainDefinitionMap.put("/register.html", "anon");
		filterChainDefinitionMap.put("/js/**", "anon");
		filterChainDefinitionMap.put("/images/**", "anon");
		filterChainDefinitionMap.put("/lib/**", "anon");
		filterChainDefinitionMap.put("/fonts/**", "anon");
		// 其他资源都需要认证 authc 表示需要认证才能进行访问
		filterChainDefinitionMap.put("/**", "user");
		// logout是shiro提供的过滤器
		//filterChainDefinitionMap.put("/logout", "logout");
		// 此时访问/userInfo/del需要del权限,在自定义Realm中为用户授权。
		// filterChainDefinitionMap.put("/userInfo/del", "perms[\"userInfo:del\"]");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}
	/*
	 * 凭证匹配器 （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
	 * 所以我们需要修改下doGetAuthenticationInfo中的代码; )
	 */
	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName("md5");// 散列算法:这里使用MD5算法;
		hashedCredentialsMatcher.setHashIterations(2);// 散列的次数，比如散列两次，相当于md5(md5(""));
		return hashedCredentialsMatcher;
	}

	@Bean
	public UserRealm myShiroRealm() {
		UserRealm myShiroRealm = new UserRealm();
		myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		return myShiroRealm;
	}

	@Bean
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		// 注入自定义的realm;
		securityManager.setRealm(myShiroRealm());
		return securityManager;
	}

	/*
	 * 开启shiro aop注解支持 使用代理方式;所以需要开启代码支持;
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
			DefaultWebSecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

	/**
	 * DefaultAdvisorAutoProxyCreator，Spring的一个bean，由Advisor决定对哪些类的方法进行AOP代理。
	 */
	@Bean
	@ConditionalOnMissingBean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
		defaultAAP.setProxyTargetClass(true);
		return defaultAAP;
	}
	/**
	 * cookie对象;会话Cookie模板 ,默认为: JSESSIONID 问题: 与SERVLET容器名冲突,重新定义为sid或rememberMe，自定义
	 * @return
	 */
	@Bean
	public SimpleCookie rememberMeCookie(){
	    //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
	    SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
	    //setcookie的httponly属性如果设为true的话，会增加对xss防护的安全系数。它有以下特点：
	    //setcookie()的第七个参数
	    //设为true后，只能通过http访问，javascript无法访问
	    //防止xss读取cookie
	    simpleCookie.setHttpOnly(true);
	    simpleCookie.setPath("/");
	    //<!-- 记住我cookie生效时间30天 ,单位秒;-->
	    simpleCookie.setMaxAge(2592000);
	    return simpleCookie;
	}
	/**
	 * cookie管理对象;记住我功能,rememberMe管理器
	 * @return
	 */
	@Bean
	public CookieRememberMeManager rememberMeManager(){
	    CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
	    cookieRememberMeManager.setCookie(rememberMeCookie());
	    //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
	    cookieRememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
	    return cookieRememberMeManager;
	}
	/**
	 * FormAuthenticationFilter 过滤器 过滤记住我
	 * @return
	 */
	@Bean
	public FormAuthenticationFilter formAuthenticationFilter(){
	    FormAuthenticationFilter formAuthenticationFilter = new FormAuthenticationFilter();
	    //对应前端的checkbox的name = rememberMe
	    formAuthenticationFilter.setRememberMeParam("rememberMe");
	    return formAuthenticationFilter;
	}
	/**
	 * 配置核心安全事务管理器
	 * @param shiroRealm
	 * @return
	 */
	@Bean(name="securityManager")
	public SecurityManager securityManager(@Qualifier("userRealm") UserRealm userRealm) {
	    DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
	    //设置自定义realm.
	    securityManager.setRealm(userRealm);
	    //配置记住我 参考博客：
	    securityManager.setRememberMeManager(rememberMeManager());
	    //配置 redis缓存管理器 参考博客：
	    //securityManager.setCacheManager(getEhCacheManager());
	    //配置自定义session管理，使用redis 参考博客：
	    //securityManager.setSessionManager(sessionManager());
	    return securityManager;
	}
	 @Bean(name = "shiroDialect")
	    public ShiroDialect shiroDialect(){
	        return new ShiroDialect();
	    }
}

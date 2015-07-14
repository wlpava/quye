/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.system.realm;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.google.common.base.Objects;
import com.wlpava.system.entity.User;
import com.wlpava.system.service.LogService;
import com.wlpava.system.service.PasswordHelper;
import com.wlpava.system.service.UserService;

/**
 * 用户验证类
 * 
 * @author wenlp
 */
public class UserRealm extends AuthorizingRealm {

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private LogService logService;

	public void setLogService(LogService logService) {
		this.logService = logService;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String loginName = (String) token.getPrincipal();
		// UsernamePasswordToken token = (UsernamePasswordToken) authToken;
		User user = userService.findByLoginName(loginName);
		if (user == null) {
			user = userService.findByPhone(loginName);
			if (user == null) {
				throw new UnknownAccountException();// 没找到帐号
			}
		}
		if (Boolean.TRUE.equals(user.getStatus() == 0)) {
			throw new LockedAccountException(); // 帐号锁定
		}

		// logService.save(new Log(loginName, new Date(), "login", IpUtil.getIpAddr(token), "login"));

		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(new ShiroUser(user.getId(), user.getLoginName(), user.getUserName(), user.getType()), // 用户名
				user.getPassword(), // 密码
				ByteSource.Util.bytes(user.getCredentialsSalt()), // salt
				getName() // realm name
		);
		return authenticationInfo;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(userService.findRoles(shiroUser.loginName));
		authorizationInfo.setStringPermissions(userService.findPermissions(shiroUser.loginName));
		return authorizationInfo;
	}

	/**
	 * 设定Password校验的Hash算法与迭代次数.
	 */
	@PostConstruct
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(PasswordHelper.ALGORITHM_NAME);
		matcher.setHashIterations(PasswordHelper.HASH_ITERATIONS);
		setCredentialsMatcher(matcher);
	}

	/**
	 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
	 */
	public static class ShiroUser implements Serializable {
		private static final long serialVersionUID = -1373760761780840081L;
		public Integer id;
		public String loginName;
		public String userName;
		public Integer type;

		public ShiroUser(Integer id, String loginName, String userName, Integer type) {
			this.id = id;
			this.loginName = loginName;
			this.userName = userName;
			this.type = type;
		}

		/**
		 * 本函数输出将作为默认的<shiro:principal/>输出.
		 */
		@Override
		public String toString() {
			return loginName;
		}

		/**
		 * 重载hashCode,只计算loginName;
		 */
		@Override
		public int hashCode() {
			return Objects.hashCode(loginName);
		}

		/**
		 * 重载equals,只计算loginName;
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			ShiroUser other = (ShiroUser) obj;
			if (loginName == null) {
				if (other.loginName != null) {
					return false;
				}
			} else if (!loginName.equals(other.loginName)) {
				return false;
			}
			return true;
		}
	}

	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}

	@Override
	public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}

	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}

	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}

}

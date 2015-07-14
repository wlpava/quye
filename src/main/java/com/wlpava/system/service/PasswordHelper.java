/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.system.service;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

import com.wlpava.system.entity.User;

/**
 * 密码加密类
 * 
 * @author wenlp
 */
@Service
public class PasswordHelper {
	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

	public static final String ALGORITHM_NAME = "MD5"; // SHA-1
	public static final int HASH_ITERATIONS = 2; // 1024;

	public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
		this.randomNumberGenerator = randomNumberGenerator;
	}

	public void encryptPassword(User user) {
		user.setSalt(randomNumberGenerator.nextBytes().toHex());
		String newPassword = new SimpleHash(ALGORITHM_NAME, user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()), HASH_ITERATIONS).toHex();
		user.setPassword(newPassword);
	}
}

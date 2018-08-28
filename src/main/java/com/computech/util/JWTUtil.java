package com.computech.util;

import java.sql.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTUtil {

	private static final long EXPIRE_TIME=7*24*60*60*1000;
	
	/**
     * 校验token是否正确
     * @param token 密钥
     * @param secret 用户的密码
     * @return 是否正确
     */
	public static boolean verify(String token,String loginName,String secret) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			JWTVerifier verifier = JWT.require(algorithm)
					.withClaim("loginName", loginName)
					.build();
			verifier.verify(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
     * 获得token中的信息无需secret解密也能获得
     * @return token中包含的用户名
     */
	public static String getLoginName(String token) {
		try {
			
			DecodedJWT jwt = JWT.decode(token);
			return jwt.getClaim("loginName").asString();
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String sign(String loginName,String userName,String secret){
		
		try {
			Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
			Algorithm algorithm = Algorithm.HMAC256(secret);
			
			return JWT.create()
					.withClaim("loginName", loginName)
					.withClaim("userName", userName)
					.withExpiresAt(date)
					.sign(algorithm);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void main(String[] args) {

	}
}

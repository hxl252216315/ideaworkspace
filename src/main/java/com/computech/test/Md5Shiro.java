package com.computech.test;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5Shiro {

	public static void main(String[] args) {
		String pwd = "123456";
		String userName = "hexiaolong";
		
		Md5Hash md5 = new Md5Hash(pwd,userName+"admin",3);
		System.out.println(md5);
	}
}

package com.computech.test;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class MyRealm extends AuthorizingRealm{

	@Override
	public String getName() {
		
		return "MyRealm";
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		String userName =(String)token.getPrincipal();
		if(userName!="hexiaolong") {
			return null;
		}
		String password = "863047d9d42645d094a22490e17a196a";
		
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName, password,ByteSource.Util.bytes(userName+"admin"), getName());
		
		return info;
	}

}

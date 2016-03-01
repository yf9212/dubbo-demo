package com.jaking.dubbo.manager.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaking.dubbo.api.dto.User;
import com.jaking.dubbo.api.service.IUserApi;
import com.jaking.dubbo.manager.IUserManager;
import com.jaking.dubbo.service.IUserService;

@Service("userManagerImpl")
public class UserManagerImpl  implements IUserManager,IUserApi {
	
	@Resource
	private IUserService userService;

	public void addUser(User user) {
		userService.addUser(user);
	}

	public void updateUser(User user) {
		userService.updateUser(user);
	}

	public List<User> getUserList(Map<String, Object> params) {
		return userService.getUserList(params);
	}

}

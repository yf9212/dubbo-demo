package com.jaking.dubbo.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.jaking.dubbo.api.dto.User;
import com.jaking.dubbo.dal.IUserMapper;
import com.jaking.dubbo.service.IUserService;

public class UserServiceImpl implements IUserService {

	@Resource
	private IUserMapper userMapper;
	
	public void addUser(User user) {
		userMapper.addUser(user);
	}

	public List<User> getUserList(Map<String, Object> params) {
		return userMapper.getUserList(params);
	}

	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

}

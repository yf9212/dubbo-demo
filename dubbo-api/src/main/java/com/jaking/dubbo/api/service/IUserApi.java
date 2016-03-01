package com.jaking.dubbo.api.service;

import java.util.List;
import java.util.Map;

import com.jaking.dubbo.api.dto.User;


/**
 * 用户api
 * @author user
 *
 */
public interface IUserApi {
	public  void  addUser(User  user);
	
	public void updateUser(User user);
	
	public List<User> getUserList(Map<String,Object> params);
}

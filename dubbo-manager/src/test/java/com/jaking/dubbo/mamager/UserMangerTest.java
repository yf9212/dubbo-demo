package com.jaking.dubbo.mamager;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.jaking.dubbo.api.dto.User;
import com.jaking.dubbo.api.service.IUserApi;

public class UserMangerTest  extends  BaseManagerTest {
	@Resource
	private IUserApi  userApi;
	
	@Test
	public void addUserTest(){
		User user=new User();
		user.setId("1");
		user.setAge(20);
		user.setSex("男");
		user.setUserName("张三");
		userApi.addUser(user);
	}
	
	@Test
	public void getUserListTest(){
		List<User>	list=userApi.getUserList(null);
		System.out.println(list.size());
	}
}

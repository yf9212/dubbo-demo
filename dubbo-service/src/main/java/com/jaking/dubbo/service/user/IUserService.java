package com.jaking.dubbo.service.user;

import java.util.List;
import java.util.Map;

import com.jaking.dubbo.api.dto.User;

public interface IUserService {

	void addUser(User user);

	List<User> getUserList(Map<String, Object> params);

	void updateUser(User user);

}

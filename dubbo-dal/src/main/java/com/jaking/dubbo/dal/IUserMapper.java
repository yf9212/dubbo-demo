package com.jaking.dubbo.dal;

import java.util.List;
import java.util.Map;

import com.jaking.dubbo.api.dto.User;

public interface IUserMapper {

	void addUser(User user);

	List<User> getUserList(Map<String, Object> params);

	void updateUser(User user);

}

package com.jaking.dubbo.mamager.redis;

import org.junit.Test;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;

import com.jaking.dubbo.api.dto.User;
import com.jaking.dubbo.dal.cache.RedisTemplateExtension;
import com.jaking.dubbo.mamager.BaseManagerTest;

public class RedisTest extends BaseManagerTest{

	 
	@Test
	@SuppressWarnings("unchecked")
	public void addUser(){
		RedisTemplateExtension<String, User> redisTemplate =applicationContext.getBean("redisCache", RedisTemplateExtension.class);
		User  user=new User();
		user.setUserName("王五");
		user.setAge(20);
		user.setId("A102");
		user.setSex("男");
		redisTemplate.setValueSerializer(new JacksonJsonRedisSerializer<User>(User.class));
		redisTemplate.getTemplate().opsForValue().set(user.getId(),user);
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void getUser(){
		RedisTemplateExtension<String, User> redisTemplate =applicationContext.getBean("redisCache", RedisTemplateExtension.class);
		User  user =redisTemplate.getTemplate().opsForValue().get("A102");
		System.out.println(user.getUserName());
	}
	
}

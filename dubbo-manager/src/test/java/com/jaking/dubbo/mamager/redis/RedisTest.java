package com.jaking.dubbo.mamager.redis;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;

import com.jaking.dubbo.api.dto.User;
import com.jaking.dubbo.dal.cache.RedisTemplateExtension;
import com.jaking.dubbo.mamager.BaseManagerTest;
import com.jaking.dubbo.service.utils.SpringContextUtil;

public class RedisTest extends BaseManagerTest{
	public static  final Logger log=Logger.getLogger(RedisTest.class);
	 
	@Test
	@SuppressWarnings("unchecked")
	public void addUser(){
		RedisTemplateExtension<String, User>  redisTemplate= SpringContextUtil.context.getBean("redisCache", RedisTemplateExtension.class);
		redisTemplate.setValueSerializer(new JacksonJsonRedisSerializer<User>(User.class));
		String key="userList";
		for (int i = 0; i < 15; i++) {
			User  user=new User();
			user.setUserName("王五"+i);
			user.setAge(20);
			user.setId("A"+i);
			user.setSex("男");
			redisTemplate.lPush(key, user);
		}
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void getUser(){
		RedisTemplateExtension<String, User> redisTemplate =applicationContext.getBean("redisCache", RedisTemplateExtension.class);
		User  user =redisTemplate.getTemplate().opsForValue().get("A102");
		System.out.println(user.getUserName());
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void getUserList(){
		RedisTemplateExtension<String, User>  redisTemplate= SpringContextUtil.context.getBean("redisCache", RedisTemplateExtension.class);
		redisTemplate.setValueSerializer(new JacksonJsonRedisSerializer<User>(User.class));
		String key="userList";
		List<User>  users= redisTemplate.lAll(key);
		for (User user : users) {
			log.info(user.getUserName());
		}
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void clearUserList(){
		RedisTemplateExtension<String, User>  redisTemplate= SpringContextUtil.context.getBean("redisCache", RedisTemplateExtension.class);
		redisTemplate.setValueSerializer(new JacksonJsonRedisSerializer<User>(User.class));
		//String key="userList";
		String oldKey="userList";
		String newKey="bb";
		redisTemplate.renameIfAbsent(oldKey, newKey);
	}
	
}

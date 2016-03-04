package com.jaking.dubbo.mamager.redis;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;

import com.jaking.dubbo.api.dto.User;
import com.jaking.dubbo.dal.cache.RedisTemplateExtension;
import com.jaking.dubbo.mamager.BaseManagerTest;
import com.jaking.dubbo.service.utils.SpringContextUtil;

public class RedisTest extends BaseManagerTest{
	public static  final Logger log=Logger.getLogger(RedisTest.class);
	 
	RedisTemplateExtension<String, User> redisTemplate;
	/**
	 * 在@test方法执行之前执行
	 */
	@SuppressWarnings("unchecked")
	@Before
	public void init(){
		redisTemplate= SpringContextUtil.context.getBean("redisCache", RedisTemplateExtension.class);
	}
	
	
	@Test
	public void addUser(){
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
	public void getUser(){
		redisTemplate.setValueSerializer(new JacksonJsonRedisSerializer<User>(User.class));
		User  user =redisTemplate.getTemplate().opsForValue().get("A102");
		log.info(user.getUserName());
	}
	
	@Test
	public void getUserList(){
		redisTemplate.setValueSerializer(new JacksonJsonRedisSerializer<User>(User.class));
		String key="userList";
		List<User>  users= redisTemplate.lAll(key);
		log.info("list size:"+users.size());
		for (User user : users) {
			log.info(user.getUserName());
		}
	}
	
	@Test
	public void clearUserList(){
		redisTemplate.setValueSerializer(new JacksonJsonRedisSerializer<User>(User.class));
		String oldKey="userList";
		String newKey="bb";
		redisTemplate.renameIfAbsent(oldKey, newKey);
	}
	
}

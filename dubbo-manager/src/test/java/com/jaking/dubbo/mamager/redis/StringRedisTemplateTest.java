package com.jaking.dubbo.mamager.redis;

import org.junit.Before;
import org.junit.Test;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.jaking.dubbo.mamager.BaseManagerTest;
import com.jaking.dubbo.service.utils.SpringContextUtil;

public class StringRedisTemplateTest  extends BaseManagerTest{
	
	private StringRedisTemplate  stringRedis;
	
	@Before
	public void init(){
		stringRedis=SpringContextUtil.context.getBean("stringRedisTemplate", StringRedisTemplate.class);
	}
	
	@Test
	public void test(){
		stringRedis.opsForList().leftPush("StringRedis", "测试数据123");
	}
}

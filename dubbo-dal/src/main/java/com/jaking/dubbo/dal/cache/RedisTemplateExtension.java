package com.jaking.dubbo.dal.cache;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisTemplateExtension<K, V> {
	private RedisTemplate<K, V> redisTemplate;

	public RedisTemplateExtension(RedisTemplate<K, V> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	private RedisTemplate<K, V> getTemplate() {
		return this.redisTemplate;
	}
	
	private ListOperations<K, V> opList(){
		return this.redisTemplate.opsForList();
	}
	
	private Long size(K key){
		return opList().size(key);
	}
	
}

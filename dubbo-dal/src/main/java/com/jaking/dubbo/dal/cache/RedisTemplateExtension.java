package com.jaking.dubbo.dal.cache;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;

public class RedisTemplateExtension<K, V> {
	private RedisTemplate<K, V> redisTemplate;

	public RedisTemplateExtension(RedisTemplate<K, V> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public RedisTemplate<K, V> getTemplate() {
		return this.redisTemplate;
	}
	
	public void setKeySerializer(RedisSerializer<?> serializer){
		getTemplate().setKeySerializer(serializer);
	}
	
	public void setValueSerializer(RedisSerializer<?> serializer){
		getTemplate().setValueSerializer(serializer);
	}
	
	
	public ListOperations<K, V> opsList(){
		return this.redisTemplate.opsForList();
	}
	
	public ValueOperations<K, V> opsObject(){
		return this.redisTemplate.opsForValue();
	}
	
	public HashOperations<K, Object, Object> opsHash(){
		return this.redisTemplate.opsForHash();
	}
	
	/**
	 * 获取列表大小
	 * @param key
	 * @return
	 */
	public Long lSize(K key){
		return opsList().size(key);
	}
	
	/**
	 * List增加在左边
	 * @param k
	 * @param v
	 * @return
	 */
	public Long lPush(K k,V v){
		return opsList().leftPush(k, v);
	}
	
	/**
	 * List增加在最后
	 * @param k
	 * @param v
	 */
	public Long rPush(K k,V v){
		return opsList().rightPush(k, v);
	}
	
	/**
	 * List指定位置插入
	 * @param k
	 * @param v
	 * @param index
	 */
	public  void push(K k,V v,Long index){
		opsList().set(k, index, v);
	}
	
	public  V getValue(K k,Long index){
		return opsList().index(k, index);
	}
	
	
}

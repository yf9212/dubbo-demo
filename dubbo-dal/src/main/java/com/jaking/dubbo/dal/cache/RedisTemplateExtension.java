package com.jaking.dubbo.dal.cache;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
	 * 删除指定key
	 * @param k
	 */
	public void delete(K k){
		redisTemplate.delete(k);
	}
	
	/**
	 * 
	 * @param key 
	 * @param timeout
	 * @param unit
	 */
	public void expire(K key,long timeout,TimeUnit unit){
		redisTemplate.expire(key, timeout, unit);
	}
	
	/**
	 * 重命名
	 * @param oldKey
	 * @param newKey
	 */
	public void rename(K oldKey,K newKey){
		redisTemplate.rename(oldKey, newKey);
	}
	
	/**
	 * 重命名如果不存在的数据
	 * @param oldKey
	 * @param newKey
	 */
	public void renameIfAbsent(K oldKey,K newKey){
		redisTemplate.renameIfAbsent(oldKey, newKey);
	}
	
	/**
	 * 过期时间,单位分钟
	 * @param key
	 * @param timeout
	 */
	public void expire(K key,long timeout){
		expire(key, timeout, TimeUnit.MINUTES);
	}
	
	/**
	 * 设置K过期,60分钟
	 * @param k
	 */
	public  void expire(K k){
		expire(k, 60);
	}
	
	/**-----------------------operate List---------------------*/
	
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
	 * @param k key值
	 * @param v value值
	 * @param index
	 */
	public  void lSet(K k,V v,Long index){
		opsList().set(k, index, v);
	}
	
	/**
	 * 获取list列表指定列表的值
	 * @param k
	 * @param index
	 * @return
	 */
	public  V lGet(K k,Long index){
		return opsList().index(k, index);
	}
	
	/**
	 * 获取整个列表List
	 * @param k
	 * @return
	 */
	public List<V> lAll(K k){
		return opsList().range(k, 0, lSize(k));
	}
	
}

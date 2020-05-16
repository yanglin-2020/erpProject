package com.xt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
/**
 * Reids配置类，通过类创建RedisTemplate的对象，并交给IOC容器管理
 * @author meimei
 */
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
/**
 * redis缓存类
 * @author yl
 *
 */
@Configuration
public class RedisConfig {
	@Bean
	public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory connectionFactory){
		//创建redis的模板对象
		RedisTemplate<String,Object> redisTemplate=new RedisTemplate<String, Object>();
		//关联的redis数据库
		redisTemplate.setConnectionFactory(connectionFactory);
		//为key设置序列化
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		//为value设置序列化
		redisTemplate.setValueSerializer(new StringRedisSerializer());
		return redisTemplate;
	}
}

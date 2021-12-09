package com.yunxi.mall.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @description: TODO 自定义 RedisTemplate 类
 * @author: qpf
 * @date: 2021/10/23
 * @version: 1.0
 */
@Configuration
public class RedisConfig {

    @Bean
    @ConditionalOnMissingBean(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) throws Exception {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        //采用 Jackson2JsonRedisSerializer 序列化方式
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY); //序列化
        //反序列化,有漏洞,已不再使用,参考链接    		https://www.cxyzjd.com/article/shizheng_Li/107125663
        // om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance ,  ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);//反序列化
        jackson2JsonRedisSerializer.setObjectMapper(om);
        //采用 StringRedisSerializer 序列化方式
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // 参考 RedisTemplate 的序列化内容
        //key值采用String方式序列化
        template.setKeySerializer(stringRedisSerializer);
        //HashKey 采用String方式序列化
        template.setHashKeySerializer(stringRedisSerializer);
        //value 采用 jackson 方式序列化
        template.setValueSerializer(jackson2JsonRedisSerializer);
        //hashValue采用jackson方式序列化
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();//设置后直接用
        return template;
    }

    @Bean
    @ConditionalOnMissingBean//经常使用StringRedisTemplate 这个类,所以默认创建了一个
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory)  throws Exception {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
}
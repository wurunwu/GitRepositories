package wu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisCommands;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 完成对Redis的整合的一些配置
 */
@Configuration  //springboot启动会扫描该类，及类中标有@Bean的方法
public class RedisConfig {

    /**
     * 1、创建一个JedisPoolConfig对象，在该对象完成一些连接池的配置
     */
    /*@Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig config=new JedisPoolConfig();    //不配置会走默认路线
        //配置最大空闲数
        config.setMaxIdle(10);
        //配置最小空闲数
        config.setMinIdle(5);
        //配置最大连接数
        config.setMaxTotal(20);
        return config;
    }*/

    /**
     * 2、创建一个JedisConnectionFactory对象，通过它来配置我们redis的连接参数
     */
    /*@Bean
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig){
        //关联连接池的配置信息
        JedisConnectionFactory factory=new JedisConnectionFactory(jedisPoolConfig);
        //配置连接Redis的信息
        factory.setHostName("47.107.254.104");
        factory.setPort(6380);
        factory.setPassword("Wurunwu199805");
        return factory;
    }*/

    /**
     * 3、创建RedisTemplate模板对象:用于执行Redis操作的方法
     */
    /*@Bean
    public RedisTemplate<String,Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory){
        RedisTemplate<String,Object> rt=new RedisTemplate<String,Object>();
        //关联
        rt.setConnectionFactory(jedisConnectionFactory);
        //为key设置序列化器
        rt.setKeySerializer(new StringRedisSerializer());
        //为value设置序列化器
        rt.setValueSerializer(new StringRedisSerializer());
        return rt;
    }*/
}








package com.wu.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 通过配置链接池来链接redis
 */
public class RedisUtil1 {

    //获取redis连接
    public static JedisPool getConnection(){
        //创建一个Jedis配置对象
        JedisPoolConfig config=new JedisPoolConfig();
        //配置相关信息
        config.setMaxTotal(36);
        config.setMaxIdle(3);
        config.setMaxWaitMillis(-1);

        //创建Jedis连接池对象，传入我们的配置对象，以及 ip,超时时间，端口，(密码)
        JedisPool pool=new JedisPool(config,"47.107.254.104",6380,60,"Wurunwu199805");
        //Jedis jedis=pool.getResource();
        System.out.println("连接成功******************");
        return pool;
    }

    public static void closeConnection(JedisPool pool){
        pool.close();
        System.out.println("关闭redis连接池******************");
    }

    public static  void closeJedis(Jedis jedis){
        jedis.close();
        System.out.println("关闭单个redis******************");
    }
}

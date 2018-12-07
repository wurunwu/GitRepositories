package com.wu.test;

import redis.clients.jedis.Jedis;

/**
 * 通过new Jedis对象来建立连接
 */
public class RedisUtil {

    //获取redis连接
    public static Jedis getConnection(){
        Jedis jedis=new Jedis("47.107.254.104",6380);
        jedis.auth("Wurunwu199805");
        System.out.println("成功获取redis链接**********");
        return jedis;
    }

    //关闭redis了解
    public static void closeConnection(Jedis jedis){
        jedis.close();
        System.out.println("成功关闭redis链接************");
    }
}

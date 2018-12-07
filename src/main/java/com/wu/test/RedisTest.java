package com.wu.test;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 通过new Jedis对象的方式操作redis
 */
public class RedisTest {

    private Jedis jedis;
    @Test
    public void add(){
        System.out.println("进入添加单个值*********");
        jedis=RedisUtil.getConnection();
        jedis.set("name","first");
        String name = jedis.get("name");
        System.out.println("单个变量name:"+name);
        RedisUtil.closeConnection(jedis);
    }

    @Test
    public void addObject(){
        System.out.println("进入添加一个对象*************");
        Users users=new Users("毛毛","1666");
        //序列化对象
        byte[] bytes=RedisCache.Xu(users);
        //获取连接
        jedis=RedisUtil.getConnection();
        jedis.set("users".getBytes(),bytes);
        byte[] bytes1 = jedis.get("users".getBytes());
        //反序列化
        Users users1=(Users) RedisCache.Fxu(bytes1);
        System.out.println("单个对象users:"+users1);
        RedisUtil.closeConnection(jedis);
    }

    //添加个集合
    @Test
    public void addList(){
        System.out.println("进入添加一个集合****************");
        List<Users>  usersList=new ArrayList<Users>();
        usersList.add(new Users("三毛","333"));
        usersList.add(new Users("五角","555"));
        //序列化 对象转二进制
        byte[] bytes=RedisCache.Xu(usersList);
        //获取连接，添加数据
        jedis=RedisUtil.getConnection();
        jedis.set("usersList".getBytes(),bytes);
        byte[] bytes1 = jedis.get("usersList".getBytes());
        //反序列化 二进制转对象
        List<Users> usersList1= (List<Users>) RedisCache.Fxu(bytes1);
        System.out.println("单个集合usersList:"+usersList1);
        RedisUtil.closeConnection(jedis);
    }
}

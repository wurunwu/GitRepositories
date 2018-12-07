package com.wu.test;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;

/**
 * 通过jedispool池来操作redis
 */
public class RedisTest1 {

    private JedisPool pool=RedisUtil1.getConnection();
    private Jedis jedis;
    @Test
    public void add(){
        System.out.println("进入添加单个变量***************");
        jedis=pool.getResource();
        jedis.set("name","first");
        String name = jedis.get("name");
        System.out.println("添加单个值name:"+name);
        RedisUtil1.closeJedis(jedis);
        RedisUtil1.closeConnection(pool);
    }

    @Test
    public void addObject(){
        System.out.println("进入添加单个对象******************");
        //获取连接
        jedis=pool.getResource();
        Users users=new Users("毛毛","1888");
        //序列化存值
        byte[] bytes = RedisCache.Xu(users);
        jedis.set("users".getBytes(),bytes);
        //反序列化取值
        byte[] bytes1 = jedis.get("users".getBytes());
        Users users1= (Users) RedisCache.Fxu(bytes1);
        System.out.println("单个变量users:"+users1);
        RedisUtil1.closeJedis(jedis);
        RedisUtil1.closeConnection(pool);
    }

    @Test
    public void addList(){
        System.out.println("进入添加单个集合*****************");
        //获取连接
        jedis=pool.getResource();
        System.out.println("jedis:"+jedis);
        List<Users> usersList=new ArrayList<Users>();
        usersList.add(new Users("三毛","333"));
        usersList.add(new Users("五角","555"));
        //序列化存值
        byte[] bytes = RedisCache.Xu(usersList);
        jedis.set("usersList".getBytes(),bytes);
        //反序列化取值
        byte[] bytes1 = jedis.get("usersList".getBytes());
        List<Users> usersList1= (List<Users>) RedisCache.Fxu(bytes1);
        System.out.println("添加单个集合usersList;"+usersList1);
        RedisUtil1.closeJedis(jedis);
        //RedisUtil1.closeConnection(pool);
    }
}

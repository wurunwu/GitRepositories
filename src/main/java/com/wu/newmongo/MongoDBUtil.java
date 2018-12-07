package com.wu.newmongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * mongodb连接数据库工具类
 * 连接封装类包括需要认证，以及不需要认证
 */
public class MongoDBUtil {

    //不通过认证获取mongodb连接对象
    public static MongoDatabase getConnect(){
        //连接到mongodb服务
        MongoClient mongo=new MongoClient("47.107.254.104",27017);
        //连接到数据库
        MongoDatabase database=mongo.getDatabase("test");
        //返回连接数据库对象
        System.out.println("数据库连接成功**********************");
        return database;
    }

    //需要密码认证方式连接
    public static MongoDatabase getConnect2(){
        List<ServerAddress>  adds=new ArrayList<>();
        //ServerAddress()两个参数分别为 服务器地址 和 端口
        ServerAddress serverAddress=new ServerAddress("47.107.254.104",27017);
        adds.add(serverAddress);

        List<MongoCredential> credentials=new ArrayList<>();
        //MongoCredential.createScramshalCredential()三个参数分别为用户名，数据库名称，密码，
        MongoCredential mongoCredential=MongoCredential.createScramSha1Credential("testwr","test","testwr".toCharArray());
        credentials.add(mongoCredential);

        //通过连接认证获取MongoDB连接服务
        MongoClient mongo=new MongoClient(adds,credentials);
        //连接到数据库
        MongoDatabase database=mongo.getDatabase("test");
        //返回连接对象
        System.out.println("数据库连接成功*********************");
        return database;
    }
}

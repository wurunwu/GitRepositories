package com.wu.config;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoOptions;

public class MongoDBUtil {
    private static Mongo mongo=null;
    private static String DBString="test";   //数据库名
    private static String hostName="47.107.254.104";   //ip地址
    private static int port=27017;     //端口号
    private static int poolSize=10;    //连接池的大小

    private MongoDBUtil(){

    }

    //获取数据库连接
    public static DB getDB(){
        if(mongo==null){
            init();
        }
        System.out.println("进来了***********"+mongo.getDB(DBString));
        return mongo.getDB(DBString);
    }

    //初始化数据库
    private static void init(){
        try {
            //实例化Mongo
            mongo=new Mongo(hostName,port);
            MongoOptions opt=mongo.getMongoOptions();
            //设置连接池大小
            opt.connectionsPerHost=poolSize;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

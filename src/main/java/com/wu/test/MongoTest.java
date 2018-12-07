package com.wu.test;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;

import java.util.Date;
import java.util.List;

public class MongoTest {

    public static void main(String[] args) {
       /* BaseDaoImpl bdi=new BaseDaoImpl();
        //查询操作
        BasicDBObject db=new BasicDBObject();
        List<DBObject> list=bdi.find("test",db);
        for(DBObject i:list){
            System.out.println(i.get("id")+"\t"+i.get("name")+"\t"+i.get("age"));
        }
        System.out.println("查询完成*************************");*/

        System.out.println("===========================================================");
        MongoClient mongo=new MongoClient("47.107.254.104",27017);
        System.out.println("连接成功================="+mongo);
        //安全认证
        DB db=mongo.getDB("test");

        //获取数据库
        MongoDatabase database=mongo.getDatabase("test");
        System.out.println("test数据库:"+database.getName());
        //显示所有数据库
        MongoIterable<String> dbs=mongo.listDatabaseNames();
        for(String dbd:dbs){
            System.out.println("数据库名："+dbd);
        }
        System.out.println("-----------开始操作---------------");
        System.out.println("进入保存数据**********************");
        DBCollection table=db.getCollection("foo");
        BasicDBObject document=new BasicDBObject();
        document.put("sex","妖兽");
        document.put("age","五百年");
        document.put("createDate",new Date());
        table.insert(document);
        System.out.println("保存成功*********************");
        System.out.println("进入查询集合*******************");
        DBCollection foo = db.getCollection("foo");
        DBCursor dbObjects = foo.find();
        while(dbObjects.hasNext()){
            System.out.println("foo集合中的内容："+dbObjects.next());
        }
        System.out.println("查询的集合:"+foo.find());
        System.out.println("进入更新******************");
        DB test = mongo.getDB("test");
        System.out.println("当前数据库名："+test.getName());
        DBCollection tab = test.getCollection("foo");
        BasicDBObject query=new BasicDBObject();
        query.put("sex","妖兽");

        BasicDBObject newDocment=new BasicDBObject();
        newDocment.put("age","100");

        BasicDBObject updateObj=new BasicDBObject();
        updateObj.put("$set" ,newDocment);

        tab.update(query,updateObj);
        DBCursor dbObjects1 = tab.find(query);
        while(dbObjects1.hasNext()){
            System.out.println("查询："+dbObjects1.next());
        }
        System.out.println("查找到的set:"+dbObjects1);
        WriteResult remove = tab.remove(query);
        System.out.println("删除结果:"+remove);
        System.out.println("修改成功*******************");
    }
}

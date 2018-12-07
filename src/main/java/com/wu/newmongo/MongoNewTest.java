package com.wu.newmongo;

import com.mongodb.Mongo;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.jupiter.api.Test;

import javax.print.Doc;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试
 */
public class MongoNewTest {

    //插入一个文档
    @Test
    public void insertOneTest(){
        //获取数据库连接对象
        MongoDatabase database=MongoDBUtil.getConnect2();
        System.out.println(database==null);
        //获取要操作的集合即表
        MongoCollection<Document> users = database.getCollection("student");
        //要插入的数据
        Document document=new Document("name","张三").append("age","18").append("sex","男");
        //插入一个文档
        users.insertOne(document);
        System.out.println("插入单个成功***********************");
    }
    //插入多个文档
    @Test
    public void insertManyTest(){
        //获取数据库连接对象
        MongoDatabase database=MongoDBUtil.getConnect2();
        //获取要操作的集合即表
        MongoCollection<Document> collections=database.getCollection("student");
        //要插入的数据
        List<Document> list=new ArrayList<>();
        for(int i=1;i<=3;i++){
            Document document=new Document("name","四毛")
            .append("sex","男")
            .append("age",18);
            list.add(document);
        }
        //插入多个文档
        collections.insertMany(list);
        System.out.println("插入多个成功**************************");
    }

    //删除文档
    @Test
    public void deleteOneTest(){
        //获取数据库连接对象
        MongoDatabase database=MongoDBUtil.getConnect2();
        //获取集合
        MongoCollection<Document> collections=database.getCollection("student");
        //申明删除条件  筛选器
        Bson filter= Filters.eq("age",18);
        //删除与筛选器匹配的单个文档  有多个时默认删除第一个
        collections.deleteOne(filter);
        System.out.println("删除单个成功**************************");
    }

    //删除多个文档
    @Test
    public void deleteManyTest(){
        //获取数据库连接对象
        MongoDatabase database=MongoDBUtil.getConnect2();
        //获取集合
        MongoCollection<Document> collections=database.getCollection("student");
        //申明删除条件  筛选器
        Bson filter= Filters.eq("age",18);
        //删除与筛选器匹配的多个文档
        collections.deleteMany(filter);
        System.out.println("删除多个成功****************************");
    }

    //修改单个文档
    @Test
    public void updateOneTest(){
        //获取数据库连接对象
        MongoDatabase database=MongoDBUtil.getConnect2();
        //获取要操作的集合
        MongoCollection<Document> student = database.getCollection("student");
        //修改过滤器  即按该条件修改
        Bson filter=Filters.eq("name","张三");
        //指定修改的更新文档
        Document document=new Document("$set",new Document("age",100));
        //修改单个文档   多个修改第一个
        student.updateOne(filter,document);
        System.out.println("修改单个成功*********************************");
    }

    //修改多个文档
    @Test
    public void updateManyTest(){
        //获取数据库连接对象
        MongoDatabase database=MongoDBUtil.getConnect2();
        //获取要操作的集合
        MongoCollection<Document> student = database.getCollection("student");
        //修改过滤器  即按该条件修改
        Bson filter=Filters.eq("name","张三");
        //指定修改的更新文档
        Document document=new Document("$set",new Document("age",111));
        //修改多个文档
        student.updateMany(filter,document);
        System.out.println("修改多个成功*************************************");
    }

    //查询文档
    @Test
    public void findTest(){
        //获取数据库连接对象
        MongoDatabase database=MongoDBUtil.getConnect2();
        //获取集合
        MongoCollection<Document> collections = database.getCollection("student");
        //查找集合中的所有文档
        FindIterable<Document> documents = collections.find();
        MongoCursor<Document> iterator = documents.iterator();
        while(iterator.hasNext()){
            System.out.println("当前内容："+iterator.next());
        }
        System.out.println("第一个内容："+documents.first());
        System.out.println("查询所有成功****************************");
    }

    //根据条件查询
    @Test
    public void FilterFindTest(){
        //获取数据库连接对象
        MongoDatabase database=MongoDBUtil.getConnect2();
        //获取集合
        MongoCollection<Document> collections = database.getCollection("student");
        //编写过滤器  按条件筛选
        Bson filter=Filters.eq("sex",null);
        //按条件查询
        FindIterable<Document> documents = collections.find(filter);
        MongoCursor<Document> iterator = documents.iterator();
        while(iterator.hasNext()){
            System.out.println("当前内容:"+iterator.next());
        }
        System.out.println("按条件查询成功*************************");
    }
}

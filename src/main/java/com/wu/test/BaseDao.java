package com.wu.test;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.omg.CORBA.Object;

import java.util.*;

public interface BaseDao {

    //数据库基本操作
    //添加
    public boolean insert(String collectionName, BasicDBObject bean);
    public boolean insert(String collectionName,Object bean);

    //删除
    public boolean delete(String collectionName,BasicDBObject bean);
    public boolean delete(String collectionName,Object bean);

    //查询
    public List<DBObject> find(String collectionName, BasicDBObject bean);
    public List<DBObject> find(String collectionName,Object bean);

    //修改
    public boolean update(String collectionName,BasicDBObject bean);
    public boolean update(String collectionName,Object bean);

    //查询总数
    public long query(String collectionName, DBObject params);
    public List<Map<String, Object>> query(String collectionName,BasicDBObject param,int startRow,int rows);  //分页
}

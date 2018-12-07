package com.wu.test;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.wu.config.BeanUtil;
import com.wu.config.MongoDBUtil;
import org.omg.CORBA.Object;

import java.util.List;
import java.util.Map;

public class BaseDaoImpl implements BaseDao{
    @Override
    public boolean insert(String collectionName, BasicDBObject bean) {
        DB db= MongoDBUtil.getDB();
        db.getCollection(collectionName).insert(bean);
        return false;
    }


    @Override
    public boolean insert(String collectionName, Object bean) {
        DB db=MongoDBUtil.getDB();
        try {
            BasicDBObject obj=(BasicDBObject)bean;
            db.getCollection(collectionName).insert(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean delete(String collectionName, BasicDBObject bean) {
        DB db=MongoDBUtil.getDB();
        db.getCollection(collectionName).remove(bean);
        return false;
    }

    @Override
    public boolean delete(String collectionName, Object bean) {
        return false;
    }

    @Override
    public List<DBObject> find(String collectionName, BasicDBObject bean) {
        return null;
    }

    @Override
    public List<DBObject> find(String collectionName, Object bean) {
        DB db=MongoDBUtil.getDB();
        List<DBObject> list= null;
        try {
            list=db.getCollection(collectionName).find(BeanUtil.bean2DBObject(bean)).toArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean update(String collectionName, BasicDBObject bean) {
        return false;
    }

    @Override
    public boolean update(String collectionName, Object bean) {
        return false;
    }

    @Override
    public long query(String collectionName, DBObject params) {
        return 0;
    }

    @Override
    public List<Map<String, Object>> query(String collectionName, BasicDBObject param, int startRow, int rows) {
        return null;
    }
}

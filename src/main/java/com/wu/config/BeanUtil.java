package com.wu.config;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * 对
 */
public class BeanUtil {

    public static<T> DBObject bean2DBObject(T bean){
        if(bean==null)
            return null;
        DBObject db=new BasicDBObject();
        //或1对象对应类中的所有属性域
        Field[] Fileds=bean.getClass().getDeclaredFields();
        for(Field field:Fileds){
            //获取属性名
            String varName=field.getName();
            //修改访问控制权限  能否修改
            boolean flag=field.isAccessible();
            if(!flag){
                field.setAccessible(true);
            }
            //获取属性值
            Object param= null;
            try {
                param = field.get(bean);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if(param==null){
                continue;
            }else if(param instanceof Integer){
                db.put(varName,((Integer)param).intValue());
            }else if(param instanceof  String){
                db.put(varName,(String)param);
            }else if(param instanceof Double){
                db.put(varName,((Double)param).doubleValue());
            }else if(param instanceof Float){
                db.put(varName,((Float)param).floatValue());
            }else if(param instanceof Long){
                db.put(varName,((Long)param).longValue());
            }else if(param instanceof Boolean){
                db.put(varName,((Boolean)param).booleanValue());
            }else if(param instanceof Date){
                db.put(varName,(Date)param);
            }
            //恢复访问控制权限
            field.setAccessible(flag);
        }
        return db;
    }
}

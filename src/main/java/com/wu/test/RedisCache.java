package com.wu.test;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.io.*;

/**
 * 通过序列化和反序列化 来进行redis中对象，集合等的读写
 */
public class RedisCache {

    /**
     * 将对象序列化成byte[]
     * @param obj
     */
    public static byte[] Xu(Object obj){
        ObjectOutputStream oos=null;
        ByteArrayOutputStream bao=null;
        try {
            bao=new ByteArrayOutputStream();
            oos=new ObjectOutputStream(bao);
            oos.writeObject(obj);
            byte[] bytes=bao.toByteArray();
            return bytes;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(oos!=null){
                    oos.close();
                }
                if(bao!=null){
                    bao.close();
                }
            }catch (Exception e){

            }
        }
        return null;
    }

    /**
     * 将byte[]反序列化成对象
     */
    public static Object Fxu(byte[] bytes){
        ByteArrayInputStream bis=null;
        ObjectInputStream ois=null;
        try {
            bis=new ByteArrayInputStream(bytes);
            ois=new ObjectInputStream(bis);
            return  ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if(ois!=null){
                    ois.close();
                }
                if(bis!=null){
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  null;
    }
}

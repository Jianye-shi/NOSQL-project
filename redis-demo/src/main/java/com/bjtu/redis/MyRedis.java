package com.bjtu.redis;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
封装redis
 */
public class MyRedis {
    Jedis jedis;
    public MyRedis(){}
    private Jedis connection(){
        this.jedis=JedisInstance.getInstance().getResource();
        return jedis;
    }
    public void set(String key,String value){
        this.jedis.set(key, value);
    }
    public String get(String key){
        return this.jedis.get(key);
    }
    public void sadd(String key, Set<String> value){
        for(String string:value){
            this.jedis.sadd(key,string);
        }
    }
    public void append(String key,String value){
        this.jedis.append(key, value);
    }
    public void srem (String key,Set<String> value){
        Iterator<String> iterator=value.iterator();
        while(iterator.hasNext()){
            String string =iterator.next();
            this.jedis.srem(key,string);
        }
    }

    public double scard(String key){
        return this.jedis.scard(key);
    }

    public Set<String> smembers(String key){
        return this.jedis.smembers(key);
    }

    public boolean sismember(String key, String value){
        return this.jedis.sismember(key,value);
    }

    public String srandmember(String key) {
        return this.jedis.srandmember(key);
    }


    public void lpush(String key, List<String> list) throws Exception {
        for(String s: list){
            this.jedis.lpush(key,s);
        }
    }

    public List<String> lrange(String key, Integer start, Integer end)
            throws Exception {
        return this.jedis.lrange(key, start, end);
    }

    public void del(String key) throws Exception {
        this.jedis.del(key);
    }

    public void hset(String key,String field,String value){
        this.jedis.hset(key,field,value);
    }

    public String hget(String key,String field){
        return this.jedis.hget(key,field);
    }

    public void hmset(String key, Map<String, String> map) throws Exception {
        this.jedis.hmset(key,map);
    }

    public Long hlen(String key) throws Exception {
        return this.jedis.hlen(key);
    }

    public Set<String> hkeys(String key) throws Exception {
        return this.jedis.hkeys(key);
    }

    public List<String> hvals(String key) throws Exception {
        return this.jedis.hvals(key);
    }

    public List<String> hmget(String key, String... params) throws Exception {
        if (null == params || params.length == 0) {
            throw new RuntimeException(this.getClass().getSimpleName()+  "::"
                    + new Exception().getStackTrace()[0].getMethodName()+"参数不能为空");
        }
        return this.jedis.hmget(key,params);
    }

    public Map<String, String> hgetAll(String key) throws Exception {
        return this.jedis.hgetAll(key);
    }

    public void hdel(String key, String... params) throws Exception {
        if (null == params || params.length == 0) {
            throw new RuntimeException(this.getClass().getSimpleName()+  "::"
                    + new Exception().getStackTrace()[0].getMethodName()+"参数不能为空");
        }
        this.jedis.hdel(key,params);
    }

}

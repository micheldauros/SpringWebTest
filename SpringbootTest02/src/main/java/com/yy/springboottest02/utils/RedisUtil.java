package com.yy.springboottest02.utils;

import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {
    private  RedisTemplate redisTemplate;

    private RedisUtil(RedisTemplate redisTemplate){
        this.redisTemplate=redisTemplate;
    }

    public <T>ValueOperations<String, T> setCacheObject(String key, T value){
        ValueOperations<String, T> operation= redisTemplate.opsForValue();
        operation.set(key, value);
        return operation;
    }

    public <T> ValueOperations<String, T> setCacheObject(String key, T value, Integer timeout, TimeUnit timeUnit)
    {
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        operation.set(key, value, timeout, timeUnit);
        return operation;
    }
    public <T> T getCacheObject(String key)
    {
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        return operation.get(key);
    }
    public void deleteObject(String key)
    {
        redisTemplate.delete(key);
    }
    public void deleteObject(Collection collection)
    {
        redisTemplate.delete(collection);
    }
    public <T> ListOperations<String, T> setCacheList(String key, List<T> dataList)
    {
        ListOperations listOperation = redisTemplate.opsForList();
        if (null != dataList)
        {
            for (T t : dataList) {
                listOperation.leftPush(key, t);
            }
        }
        return listOperation;
    }
    public <T> List<T> getCacheList(String key)
    {
        List<T> dataList = new ArrayList<T>();
        ListOperations<String, T> listOperation = redisTemplate.opsForList();
        Long size = listOperation.size(key);

        for (int i = 0; i < size; i++)
        {
            dataList.add(listOperation.index(key, i));
        }
        return dataList;
    }
    public <T> BoundSetOperations<String, T> setCacheSet(String key, Set<T> dataSet)
    {
        BoundSetOperations<String, T> setOperation = redisTemplate.boundSetOps(key);
        Iterator<T> it = dataSet.iterator();
        while (it.hasNext())
        {
            setOperation.add(it.next());
        }
        return setOperation;
    }
    public <T> Set<T> getCacheSet(String key)
    {
        Set<T> dataSet = new HashSet<T>();
        BoundSetOperations<String, T> operation = redisTemplate.boundSetOps(key);
        dataSet = operation.members();
        return dataSet;
    }
    public <T> HashOperations<String, String, T> setCacheMap(String key, Map<String, T> dataMap)
    {
        HashOperations hashOperations = redisTemplate.opsForHash();
        if (null != dataMap)
        {
            for (Map.Entry<String, T> entry : dataMap.entrySet())
            {
                hashOperations.put(key, entry.getKey(), entry.getValue());
            }
        }
        return hashOperations;
    }
    public <T> Map<String, T> getCacheMap(String key)
    {
        Map<String, T> map = redisTemplate.opsForHash().entries(key);
        return map;
    }
    public Collection<String> keys(String pattern)
    {
        return redisTemplate.keys(pattern);
    }
}

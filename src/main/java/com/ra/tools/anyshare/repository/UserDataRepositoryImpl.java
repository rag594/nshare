package com.ra.tools.anyshare.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDataRepositoryImpl implements UserRepository {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private SetOperations listOperations;

    public UserDataRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        listOperations = redisTemplate.opsForSet();
    }

    @Override
    public void saveLink(String id, String url) {
        listOperations.add(id, url);
    }

    @Override
    public List<String> getAllById(String id) {
        List<String> urlList = new ArrayList<>();
        urlList.addAll(listOperations.members(id));
        return urlList;
    }

    @Override
    public String getLatestById(String id) {
        return null;
    }
}

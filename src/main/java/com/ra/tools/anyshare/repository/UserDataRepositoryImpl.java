package com.ra.tools.anyshare.repository;

import com.ra.tools.anyshare.models.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserDataRepositoryImpl implements UserRepository {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private SetOperations setOperations;

    public UserDataRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        setOperations = redisTemplate.opsForSet();
    }

    @Override
    public void saveLink(String id, String url) {
        setOperations.add(id, url);
    }

    @Override
    public List<Link> getAllById(String id) {
        List<String> urlList = new ArrayList<>();
        urlList.addAll(setOperations.members(id));
        return urlList.stream().map(url -> new Link(url)).collect(Collectors.toList());
    }

    @Override
    public String getLatestById(String id) {
        return null;
    }
}

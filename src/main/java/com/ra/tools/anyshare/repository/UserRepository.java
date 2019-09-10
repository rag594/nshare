package com.ra.tools.anyshare.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    void saveLink(String id, String url);

    List<String> getAllById(String id);

    String getLatestById(String id);
}

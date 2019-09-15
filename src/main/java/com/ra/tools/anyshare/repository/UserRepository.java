package com.ra.tools.anyshare.repository;

import com.ra.tools.anyshare.models.Link;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    void saveLink(String id, String url);

    List<Link> getAllById(String id);

    String getLatestById(String id);
}

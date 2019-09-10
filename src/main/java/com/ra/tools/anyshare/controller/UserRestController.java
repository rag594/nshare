package com.ra.tools.anyshare.controller;

import com.ra.tools.anyshare.models.User;
import com.ra.tools.anyshare.repository.UserDataRepositoryImpl;
import com.ra.tools.anyshare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
public class UserRestController {

    @Autowired
    private UserDataRepositoryImpl userDataRepository;

    @RequestMapping(value = "/url/newURL", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> persistUer(@RequestBody User user) {
        userDataRepository.saveLink(user.getId(), user.getUrl());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(value = "/url", method = RequestMethod.GET)
    @ResponseBody
    public Map persistUer(@RequestParam("id")String id) {
        return Collections.singletonMap("url",userDataRepository.getAllById(id));
    }
}

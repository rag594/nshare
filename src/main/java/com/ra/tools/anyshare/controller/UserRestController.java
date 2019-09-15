package com.ra.tools.anyshare.controller;

import com.ra.tools.anyshare.models.Link;
import com.ra.tools.anyshare.models.User;
import com.ra.tools.anyshare.repository.UserDataRepositoryImpl;
import com.ra.tools.anyshare.service.AuthService;
import com.ra.tools.anyshare.utils.Utils;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRestController {

    @Autowired
    private UserDataRepositoryImpl userDataRepository;

    @Autowired
    private AuthService authService;

    @RequestMapping(
            value = "/user/signup",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> signUpUser(@RequestBody User user) throws Exception {
            HttpResponse signUpResponse = authService.signUpUser(user);
            return Utils.prepareResponseFromHttpResponse(signUpResponse);
    }

    @RequestMapping(
            value = "/user/signin",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> signInUser(@RequestBody User user) throws Exception {
        HttpResponse signUpResponse = authService.signInUser(user);
        return Utils.prepareResponseFromHttpResponse(signUpResponse);
    }

    @RequestMapping(
            value = "/url",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> addUrl(@RequestBody Link link,
                                         @RequestHeader(value = "Authorization") String accessToken) throws Exception {
        if(accessToken == null || accessToken.isEmpty()) {
            return Utils.prepareErrorResponse("Unauthorized", HttpStatus.UNAUTHORIZED);
        }
        HttpResponse verifyAccessTokenResponse = authService.verifyAccessToken(accessToken);
        if(verifyAccessTokenResponse.getStatusLine().getStatusCode() != 200) {
            return Utils.prepareErrorResponse("Unauthorized", HttpStatus.UNAUTHORIZED);
        }
        String email = Utils.Decode(accessToken).getEmail();
        userDataRepository.saveLink(email, link.getUrl());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(
            value = "/url",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> getAllURL(@RequestHeader("Authorization") String accessToken) throws Exception {
        if(accessToken == null || accessToken.isEmpty()) {
            return Utils.prepareErrorResponse("Unauthorized", HttpStatus.UNAUTHORIZED);
        }
        HttpResponse verifyAccessTokenResponse = authService.verifyAccessToken(accessToken);
        if(verifyAccessTokenResponse.getStatusLine().getStatusCode() != 200) {
            return Utils.prepareErrorResponse("Unauthorized", HttpStatus.UNAUTHORIZED);
        }
        String email = Utils.Decode(accessToken).getEmail();
        return new ResponseEntity<Object>(new User(email, userDataRepository.getAllById(email)), HttpStatus.OK);
    }
}

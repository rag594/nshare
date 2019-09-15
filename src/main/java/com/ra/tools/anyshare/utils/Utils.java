package com.ra.tools.anyshare.utils;

import com.google.gson.Gson;
import com.ra.tools.anyshare.models.ErrorResponse;
import com.ra.tools.anyshare.models.JWTDecodeBody;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.Arrays;

public class Utils {
    public static JWTDecodeBody Decode(String token) {
        Gson gson = new Gson()
;       String[] jwtToken = token.split("\\.");
        Base64 base64Url = new Base64(true);
        String body = new String(base64Url.decode(jwtToken[1]));
        return gson.fromJson(body, JWTDecodeBody.class);
    }

    public static ResponseEntity<Object> prepareResponseFromHttpResponse(HttpResponse httpResponse) throws IOException {
        String json = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        if(httpResponse.getStatusLine().getStatusCode() == 200) {
            return new ResponseEntity<>(json, HttpStatus.OK);
        } else {
            HttpStatus httpStatus = Arrays.stream(HttpStatus.values())
                    .filter(status -> status.value() == httpResponse.getStatusLine().getStatusCode())
                    .findAny()
                    .orElse(HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(json, httpStatus);
        }
    }

    public static ResponseEntity<Object> prepareErrorResponse(String msg, HttpStatus httpStatus) {
        Gson gson = new Gson();
        return new ResponseEntity<>(gson.toJson(new ErrorResponse(msg)), httpStatus);
    }
}

package com.blog.blog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;


@Component
public class GetHeader {

    public List<String> getAuthHeaderInfo(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        List<String> list=new ArrayList<>();

        if (authorizationHeader != null && authorizationHeader.startsWith("Basic ")) {
            // Extract and decode the Base64 encoded credentials
            String base64Credentials = authorizationHeader.substring(6);
            String credentials = new String(java.util.Base64.getDecoder().decode(base64Credentials));

            // Split the credentials into username and password
            String[] usernameAndPassword = credentials.split(":");

            if (usernameAndPassword.length == 2) {
            	
                String username = usernameAndPassword[0];
                list.add(username);
                String password = usernameAndPassword[1];
                list.add(password);

                return list;
            }
        }

        return  list;
    }
}

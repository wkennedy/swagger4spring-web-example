package com.knappsack.swagger4springweb.controllers.api;


import com.knappsack.swagger4springweb.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/users", produces = {"application/json", "application/xml"})
public class UserController {

    @RequestMapping(value = "/{id}")
    public ResponseEntity<User> findUserById(@PathVariable long id) {
        User user = new User();
        user.setID(id);
        user.setEmail("email@example.com");
        return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
    }
}

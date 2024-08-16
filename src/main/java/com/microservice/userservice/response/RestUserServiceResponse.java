package com.microservice.userservice.response;

import com.microservice.userservice.modal.User;
import com.microservice.userservice.modal.UserMockData;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/JSON", produces="application/json")
@CrossOrigin(origins="*")
public class RestUserServiceResponse {
    @GetMapping("/users")
    public List<User> get() {
        return UserMockData.getUsers();
    }

    @GetMapping()
    public Boolean authenticate(@RequestParam(name= "userName",required = true)  String userName,
                                             @RequestParam(name="password", required = true) String password) {
        List<User> userList = UserMockData.getUsers();
        for(User user : userList) {
            if(user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}

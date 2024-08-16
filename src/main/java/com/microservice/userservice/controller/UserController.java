package com.microservice.userservice.controller;

import com.microservice.userservice.modal.User;
import com.microservice.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/check")
    public String check() {
        return "Hello World!";
    }

    @GetMapping("/userCheck")
    /*public Boolean getUserAuthentication(@PathVariable("userName") String userName,
                                         @PathVariable("password") String password) throws IOException {*/
    /*public Boolean getUserAuthentication(@RequestParam(name= "userName",required = true)  String userName,
                                        @RequestParam(name="password", required = true) String password) throws IOException {
    */
    public Boolean getUserAuthentication(@RequestBody  User user) throws IOException {

        List<User> users = userService.getUserFromFile();
        /*for(User u : users) {
            if(u.getUserName().equals(user.getUserName()) && u.getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;*/

        return users.stream().anyMatch(u -> (user.getUserName()==null || u.getUserName().equals(user.getUserName())) && (user.getPassword()==null || u.getPassword().equals(user.getPassword())));

    }

}

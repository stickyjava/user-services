package com.microservice.userservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.userservice.modal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private ResourceLoader resourceLoader;

    public List<User> getUserFromFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        // Load the resource using ResourceLoader
        Resource resource = resourceLoader.getResource("classpath:userData.json");
        return objectMapper.readValue(resource.getFile(), new TypeReference<List<User>>(){});
    }

    /*

     List<User> users = List.of(
            new User("John Doe", 30),
            new User("Jane Smith", 25)
        );

        return users.stream()
            .filter(user -> (name == null || user.getName().equals(name)) &&
                            (age == null || user.getAge() == age))
            .collect(Collectors.toList());
    }

     */
}

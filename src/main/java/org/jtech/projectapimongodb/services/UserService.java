package org.jtech.projectapimongodb.services;

import java.util.List;

import org.jtech.projectapimongodb.domain.User;
import org.jtech.projectapimongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;
    
    public List<User> findAll(){
        return repo.findAll();
    }
}

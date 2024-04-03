package com.java.pawsome.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.pawsome.Model.*;
import com.java.pawsome.Repository.*;


@Service
public class UserService {
    @Autowired
    private Userrepo repo;

    public User createuser(User a){
        return repo.save(a);
    }

    public List<User> getAllusers(){
        return repo.findAll();
    }

    public Optional<User> getuserById(Integer userId){
        return repo.findById(userId);
    }
    public User updateUser(User updatedUser){
        return repo.save(updatedUser);
    }
    
    public boolean deleteUser(Integer userId) {
        if (repo.existsById(userId)) {
            repo.deleteById(userId);
            return true;
        }
        return false;
    }

}
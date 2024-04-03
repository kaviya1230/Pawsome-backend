package com.java.pawsome.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.pawsome.Model.*;
@Repository
public interface Userrepo extends JpaRepository<User, Integer> {    
}
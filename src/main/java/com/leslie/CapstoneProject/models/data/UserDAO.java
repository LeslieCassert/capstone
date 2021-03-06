package com.leslie.CapstoneProject.models.data;

import com.leslie.CapstoneProject.models.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UserDAO extends CrudRepository<Users, Integer> {

    public List<Users> findByUsername(String username);
}
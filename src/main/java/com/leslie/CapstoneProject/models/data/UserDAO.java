package com.leslie.CapstoneProject.models.data;

import com.leslie.CapstoneProject.models.Users;
import com.leslie.CapstoneProject.models.Users;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDAO {


    @Repository
    @Transactional
    public interface UserDao extends CrudRepository<Users, Integer> {

        public List<Users> findByUsername(String username);

    }
}

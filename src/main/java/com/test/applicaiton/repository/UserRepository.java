package com.test.applicaiton.repository;

import com.test.applicaiton.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "SELECT u.* FROM usertable u WHERE u.first_name LIKE %:name%", nativeQuery = true)
    List<User> fetchUsersByUserName(@Param("name") String userName);

    User findByFirstName(String userName);
}

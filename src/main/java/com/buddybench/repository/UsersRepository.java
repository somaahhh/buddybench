package com.buddybench.repository;

import com.buddybench.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long > {
    Optional<Users> findByEmailId(String emailId);

    Map<Object, Object> findByuserName(String username);
}

package com.buddybench.repository;

import com.buddybench.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    long findRoleIdByRoleName(String roleName);

    List<Long> findRespnsbilitiesByRoleId(long id);

    String[] findAllByRoleName();
}

package com.matrimonyproject.matrimony.repository;

import com.matrimonyproject.matrimony.customEnum.AppRole;
import com.matrimonyproject.matrimony.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query("SELECT r FROM Role r WHERE r.roleName=?1 and r.DEL_FLG=0")
    Optional<Role> findByRoleName(String roleName);
}

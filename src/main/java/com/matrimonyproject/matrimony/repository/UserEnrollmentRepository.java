package com.matrimonyproject.matrimony.repository;

import com.matrimonyproject.matrimony.entity.UserEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserEnrollmentRepository extends JpaRepository<UserEnrollment,Long> {
    @Query("SELECT c FROM UserEnrollment c WHERE  (c.mobileNo=?1 OR c.email=?2) AND c.DEL_FLG=0")
    Optional<UserEnrollment> findByMobileNoOrEmailId(String mobileNo, String email);
}

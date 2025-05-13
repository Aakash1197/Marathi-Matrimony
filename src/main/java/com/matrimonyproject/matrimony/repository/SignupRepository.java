package com.matrimonyproject.matrimony.repository;

import com.matrimonyproject.matrimony.constant.MatrimonyConstant;
import com.matrimonyproject.matrimony.entity.UserRegister;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SignupRepository extends JpaRepository<UserRegister,Long> {

    @Query("SELECT c FROM UserRegister c\n" +
            "WHERE c.username =?1\n" +
            "   AND (c.mobileNumber = ?2 OR c.email = ?3 )AND c.DEL_FLG=0")
    Optional< UserRegister> findByUsernameAndMobileNoOrEmailId(String username, String mobileNumber, String email);

    @Query(value = "SELECT c FROM UserRegister c WHERE (c.mobileNumber = ?1 OR c.email = ?2) AND c.DEL_FLG = 0")
    Optional< UserRegister> findByMobileNoOrEmailId(@Param("mobileNumber") String mobileNumber, @Param("email")  String email);



    @Query("SELECT COUNT(c) > 0 FROM UserRegister c WHERE c.username = ?1 AND c.DEL_FLG=0")
    boolean existsByUsername(String username);
    @Query("SELECT COUNT(c) > 0  FROM UserRegister c WHERE c.email = ?1 AND c.DEL_FLG=0")
    boolean existsByEmail(String email);
    @Query("SELECT COUNT(c) > 0   FROM UserRegister c WHERE c.mobileNumber = ?1 AND c.DEL_FLG=0")
    boolean existsByMobileNumber(String mobileNumber);

    @Query("SELECT c FROM UserRegister c WHERE c.username = ?1 AND c.DEL_FLG=0")
    Optional<UserRegister> findByUsername(@NotBlank(message = MatrimonyConstant.USERNAME_BLANK_MESSAGE) @Pattern(regexp = "^[a-zA-Z]{1,5}[$@_]{1}[0-9]{4}[0-9]{4}$", message = MatrimonyConstant.USERNAME_FORMAT_MESSAGE) @Size( min=12, max=50,message = MatrimonyConstant.USERNAME_SIZE_MESSAGE) String userName);
}

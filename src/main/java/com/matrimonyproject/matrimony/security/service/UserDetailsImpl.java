package com.matrimonyproject.matrimony.security.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.matrimonyproject.matrimony.entity.UserRegister;
import com.matrimonyproject.matrimony.security.jwt.AuthEntryPointJwt;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
public class UserDetailsImpl implements UserDetails {
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsImpl.class);
    private static final long serialVersionUID = 1L;


    @Getter
    private Long id;

    private String username;
    private String firstName;
    private String middleName;
    private String lastName;
    @Getter
    private String email;
    @Getter
    private String mobile;
    private String gender;
    private String plans;
    private String passwordExpirationDate;
    private int failedLoginAttempts;
    private String lockTime;
    private boolean accountNonLocked;

    private String ADD_TIME;
    private String     ADD_DATE;
    private String        ADD_BY_USER;
    private String MDF_TIME;
    private String     MDF_DATE;
    private String        MDF_BY_USER;
    private String DEL_TIME;
    private String     DEL_DATE;
    private String        DEL_BY_USER;
    private Integer       DEL_FLG;

    @JsonIgnore
    private String password;




    private Collection<? extends GrantedAuthority> authorities;

/*    public UserDetailsImpl(Long id, String username, String email, String mobile, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.authorities = authorities;
    }*/

    public UserDetailsImpl(Long userRegisterId,String username, String mobileNumber, String email, String password, List<GrantedAuthority> authorities) {
        this.id = userRegisterId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.mobile = mobileNumber;
        this.authorities = authorities;
    }

    public UserDetailsImpl(Long userRegisterId, String username, String firstName, String middleName, String lastName, String email, String mobile, String gender, String plans, String passwordExpirationDate, int failedLoginAttempts, String lockTime, boolean accountNonLocked, String ADD_TIME, String ADD_DATE, String ADD_BY_USER, String MDF_TIME, String MDF_DATE, String MDF_BY_USER, String DEL_TIME, String DEL_DATE, String DEL_BY_USER, Integer DEL_FLG, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = userRegisterId;
        this.username = username;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.gender = gender;
        this.plans = plans;
        this.passwordExpirationDate = passwordExpirationDate;
        this.failedLoginAttempts = failedLoginAttempts;
        this.lockTime = lockTime;
        this.accountNonLocked = accountNonLocked;
        this.ADD_TIME = ADD_TIME;
        this.ADD_DATE = ADD_DATE;
        this.ADD_BY_USER = ADD_BY_USER;
        this.MDF_TIME = MDF_TIME;
        this.MDF_DATE = MDF_DATE;
        this.MDF_BY_USER = MDF_BY_USER;
        this.DEL_TIME = DEL_TIME;
        this.DEL_DATE = DEL_DATE;
        this.DEL_BY_USER = DEL_BY_USER;
        this.DEL_FLG = DEL_FLG;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(UserRegister user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(
                user.getUserRegisterId(),
                user.getUsername(),
                user.getFirstName(),
                user.getMiddleName(),
                user.getLastName(),
                user.getEmail(),
                user.getMobileNumber(),
                user.getGender(),
                user.getPlans(),
                user.getPasswordExpirationDate(),
                user.getFailedLoginAttempts(),
                user.getLockTime(),
                user.getAccountNonLocked(),
                user.getADD_TIME(),
                user.getADD_DATE(),
                user.getADD_BY_USER(),
                user.getMDF_TIME(),
                user.getMDF_DATE(),
                user.getMDF_BY_USER(),
                user.getDEL_TIME(),
                user.getDEL_DATE(),
                user.getDEL_BY_USER(),
                user.getDEL_FLG(),
                user.getPassword(),
                authorities);
    }
/*
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.authorities;
}*/

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        boolean result;
        String localDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        if(localDate.equals(this.getPasswordExpirationDate())|| this.getPasswordExpirationDate().isEmpty() || this.getPasswordExpirationDate().isBlank()){
            result=false;
        }
        else{
            result= true;
        }
 /*       result= Long.parseLong(this.getPasswordExpirationDate()) > Long.parseLong(localDate);
        logger.info("Password Expiration Date : "+this.getPasswordExpirationDate()+" Local Date : "+localDate+" Result : "+result);*/
         return result;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        boolean result;
        String localDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        result= Long.parseLong(this.getPasswordExpirationDate()) > Long.parseLong(localDate);
        return result;
    }

    @Override
    public boolean isEnabled() {

        return this.getDEL_FLG()==0?true:false;
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }


}

package com.matrimonyproject.matrimony.security.response;

import com.matrimonyproject.matrimony.entity.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Setter
@Getter
@ToString
public class UserInfoResponse {
    private Long registrationId;
    private String username;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
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
    private String jwt;
    private List<Role> roles;


    public UserInfoResponse(Long registrationId, String username, String email, String mobile, String jwt, List<Role> roles) {
        this.registrationId = registrationId;
        this.username = username;
        this.email = email;
        this.mobile = mobile;
        this.jwt = jwt;
        this.roles = roles;
    }


    public UserInfoResponse(Long registrationId, String username, String email, String mobile, List<Role> roles) {
        this.registrationId = registrationId;
        this.username = username;
        this.email = email;
        this.mobile = mobile;
        this.jwt = jwt;
        this.roles = roles;
    }

    public UserInfoResponse(Long registrationId, String username, String firstName,
                            String middleName, String lastName,
                            String email, String mobile, String gender,
                            String plans, String passwordExpirationDate,
                            int failedLoginAttempts, String lockTime,
                            boolean accountNonLocked, String addTime,
                            String addDate, String addByUser, String mdfTime,
                            String mdfDate, String mdfByUser, String delTime,
                            String delDate, String delByUser, int delFlg,
                            List<Role> roles) {
        this.registrationId = registrationId;
        this.username=username;
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
        this.ADD_TIME = addTime;
        this.ADD_DATE = addDate;
        this.ADD_BY_USER = addByUser;
        this.MDF_TIME = mdfTime;
        this.MDF_DATE = mdfDate;
        this.MDF_BY_USER = mdfByUser;
        this.DEL_TIME = delTime;
        this.DEL_DATE = delDate;
        this.DEL_BY_USER = delByUser;
        this.DEL_FLG = this.getDEL_FLG();
        this.roles = roles;


    }
}

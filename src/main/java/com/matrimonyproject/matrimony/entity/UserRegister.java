package com.matrimonyproject.matrimony.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.matrimonyproject.matrimony.constant.MatrimonyConstant;
import com.matrimonyproject.matrimony.customEnum.AppRole;
import com.matrimonyproject.matrimony.customEnum.Plans;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="UserRegister",uniqueConstraints = {
        @UniqueConstraint(columnNames = "userRegisterId"),
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "mobileNumber")
})
@Data
@NoArgsConstructor
public class UserRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRegisterId;
    @NotBlank

    @Column(name = "username")
    private String username;


    @NotBlank
    private String firstName;
    private String middleName;
    @NotBlank
    private String lastName;

    @NotBlank
    private String gender;

    @NotBlank
    private String email;

    @NotBlank
    private String mobileNumber;
    @ToString.Exclude
    @NotBlank
    private String password;

    @Column(name="plan",nullable = false)
    private String plans;
    @Column(name = "password_expiration_date")
    private String passwordExpirationDate;


    @Column(name = "failed_login_attempts",nullable = false)
    private int failedLoginAttempts;
    @Column(name = "lock_Time",nullable = true)
    private String lockTime;
    @Column(name = "account_Non_Locked")
    private boolean accountNonLocked;
    @ToString.Exclude
    @OneToOne(mappedBy = "userRegister")
    private UserEnrollment userEnrollment;

    @Getter
    @Setter
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.EAGER)
    @JoinTable(name="user_role",
            joinColumns=@JoinColumn(name="userRegisterId"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @ToString.Exclude  // Exclude roles to avoid recursion
    @JsonManagedReference
    private Set<Role> roles = new HashSet<>();







    @Column(name="ADD_TIME")
    private String ADD_TIME;
    @Column(name="ADD_DATE")
    private String     ADD_DATE;
    @Column(name="ADD_BY_USER")
    private String        ADD_BY_USER;
    @Column(name="MDF_TIME")
    private String MDF_TIME;
    @Column(name="MDF_DATE")
    private String     MDF_DATE;
    @Column(name="MDF_BY_USER")
    private String        MDF_BY_USER;
    @Column(name="DEL_TIME")
    private String DEL_TIME;
    @Column(name="DEL_DATE")
    private String     DEL_DATE;
    @Column(name="DEL_BY_USER")
    private String        DEL_BY_USER;
    @Column(name="DEL_FLG")
    private Integer       DEL_FLG;

    public UserRegister(String username, String firstName,String middleName, String lastName,
                        String gender, String email, String mobileNumber,String password) {
        this.username = username;
        this.middleName = middleName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.plans = Plans.ADMIN.getPlanName();


        this.failedLoginAttempts = 0;
        this.accountNonLocked = true;
        this.lockTime = null;
        this.passwordExpirationDate = LocalDate.now().plusDays(90).format(DateTimeFormatter.ofPattern("yyyyMMdd")) ;
        this.ADD_TIME = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss"));
        this.ADD_DATE = LocalDate.now().toString();
        this.ADD_BY_USER = AppRole.ROLE_DEVELOPER.getRoleName() ;
        this.MDF_TIME ="000000";
        this.MDF_DATE ="000000";
        this.MDF_BY_USER = null;
        this.DEL_TIME ="000000";
        this.DEL_DATE = "000000";
        this.DEL_BY_USER = null;
        this.DEL_FLG = 0;

    }


    public boolean getAccountNonLocked() {
        return this.accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }
}

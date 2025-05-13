package com.matrimonyproject.matrimony.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.matrimonyproject.matrimony.customEnum.AppRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private Long roleId;

    @ToString.Exclude
    @Column(length=20,name="role_name",unique = true,nullable = false)
    /*@Enumerated(EnumType.STRING)*/
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    @ToString.Exclude  // Exclude users to avoid recursion
    @JsonBackReference
    private Set<UserRegister> users = new HashSet<>();

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

   public Role(AppRole roleName,String username) {
       this.roleName = roleName.getRoleName();
       this.ADD_TIME = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss"));
       this.ADD_DATE = LocalDate.now().toString();
       this.ADD_BY_USER=username;
       this.MDF_TIME ="000000";
       this.MDF_DATE ="000000";
       this.MDF_BY_USER = null;
       this.DEL_TIME ="000000";
       this.DEL_DATE = "000000";
       this.DEL_BY_USER = null;
       this.DEL_FLG = 0;
   }




    // Override hashCode to only use roleId (stable field)
    @Override
    public int hashCode() {
        return Objects.hash(roleId);  // Only use roleId as it's stable and won't cause issues
    }

    // Override equals to compare roleId for uniqueness
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Role role = (Role) obj;
        return roleId != null && roleId.equals(role.roleId);  // Compare roleId to ensure uniqueness
    }



}
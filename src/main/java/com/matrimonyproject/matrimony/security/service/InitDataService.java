package com.matrimonyproject.matrimony.security.service;

import com.matrimonyproject.matrimony.customEnum.AppRole;
import com.matrimonyproject.matrimony.entity.Role;
import com.matrimonyproject.matrimony.entity.UserRegister;
import com.matrimonyproject.matrimony.repository.RoleRepository;
import com.matrimonyproject.matrimony.repository.SignupRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class InitDataService {


    @Autowired
    private EntityManager entityManager;

/*    @Autowired
    private SignupRepository signupRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;*/






    @Transactional
    public void initializeData(RoleRepository roleRepository, SignupRepository userRepository, PasswordEncoder passwordEncoder) {

        // Retrieve or create roles

        Role userRole = roleRepository.findByRoleName(AppRole.ROLE_USER.getRoleName()).orElseGet(() -> {
            Role newUserRole = new Role(AppRole.ROLE_USER, "Developer");
            return roleRepository.save(newUserRole);
        });

        Role guestRole = roleRepository.findByRoleName(AppRole.ROLE_GUEST.getRoleName()).orElseGet(() -> {
            Role newGuestRole = new Role(AppRole.ROLE_GUEST, "Developer");
            return roleRepository.save(newGuestRole);  // Use merge() to ensure it's managed
        });

        Role developerRole = roleRepository.findByRoleName(AppRole.ROLE_DEVELOPER.getRoleName()).orElseGet(() -> {
            Role newDeveloperRole = new Role(AppRole.ROLE_DEVELOPER, "Developer");
            return roleRepository.save(newDeveloperRole);
        });

        Role adminRole = roleRepository.findByRoleName(AppRole.ROLE_ADMIN.getRoleName()).orElseGet(() -> {
            Role newAdminRole = new Role(AppRole.ROLE_ADMIN, "Developer");
            return roleRepository.save(newAdminRole);
        });

        Role supportRole = roleRepository.findByRoleName(AppRole.ROLE_SUPPORT.getRoleName()).orElseGet(() -> {
            Role newSupportRole = new Role(AppRole.ROLE_SUPPORT, "Developer");
            return roleRepository.save(newSupportRole);
        });

        Role moderateReviwerRole = roleRepository.findByRoleName(AppRole.ROLE_MODERATOR_REVIWER.getRoleName()).orElseGet(() -> {
            Role newModerateReviewerRole = new Role(AppRole.ROLE_MODERATOR_REVIWER, "Developer");
            return roleRepository.save(newModerateReviewerRole);
        });

        Role premiumUserRole = roleRepository.findByRoleName(AppRole.ROLE_PREMIUM_USER.getRoleName()).orElseGet(() -> {
            Role newPremiumUserRole = new Role(AppRole.ROLE_PREMIUM_USER, "Developer");
            return roleRepository.save(newPremiumUserRole);
        });


        Set<Role> userRoles = Set.of(userRole);
        Set<Role> guestRoles = Set.of(guestRole);
        Set<Role> moderatorRoles = Set.of(moderateReviwerRole);
        Set<Role> premiumUserRoles = Set.of(premiumUserRole);
        Set<Role> developerRoles = Set.of(developerRole);
        Set<Role> supportRoles = Set.of(supportRole);
        Set<Role> adminRoles = Set.of(adminRole);
        Set<Role> allRoles = Set.of(userRole, guestRole, developerRole, adminRole, supportRole, moderateReviwerRole, premiumUserRole);


        // Create users if not already present

        if (!userRepository.existsByUsername("Sharm@86548492") && (!userRepository.existsByEmail("mohan.sharma@gmail.com") || !userRepository.existsByMobileNumber("9922334455"))) {

            UserRegister user1 = new UserRegister("Sharm@86548492", "Mohan", "Shrikant", "Sharama", "Male",  "mohan.sharma@gmail.com","9922334455", passwordEncoder.encode("Mohan@123"));
            // before save:

            user1.setRoles(userRoles);
         /*   entityManager.merge(user1);*/
            userRepository.save(user1);
        }

        if (!userRepository.existsByUsername("Verma_11223344") && (!userRepository.existsByEmail("mohan.verma@gmail.com") || !userRepository.existsByMobileNumber("9922334456"))) {
            UserRegister guest1 = new UserRegister("Verma_11223344", "Mohan", "Bansilal", "Verma", "Male", "mohan.verma@gmail.com", "9922334456", passwordEncoder.encode("Verma@123"));
            // before save:

            guest1.setRoles(guestRoles);

          /*  entityManager.merge(guest1);*/
            userRepository.save(guest1);
        }

        if (!userRepository.existsByUsername("Ali@11321132") && (!userRepository.existsByEmail("mia.ali@gmail.com" )|| !userRepository.existsByMobileNumber("9922334457"))) {
            UserRegister admin1 = new UserRegister("Ali6@11321132", "Mai", "Iftikar", "Ali", "Male", "mia.ali@gmail.com", "9922334457", passwordEncoder.encode("Ali@123"));
            admin1.setRoles(adminRoles);
           /* entityManager.merge(admin1);*/
            userRepository.save(admin1);
        }

      /*      // Update roles for existing users
            userRepository.findByUsername("user1").ifPresent(user -> {
                user.setRoles(userRoles);
                userRepository.save(user);
            });

            userRepository.findByUsername("seller1").ifPresent(seller -> {
                seller.setRoles(sellerRoles);
                userRepository.save(seller);
            });

            userRepository.findByUsername("admin").ifPresent(admin -> {
                admin.setRoles(adminRoles);
                userRepository.save(admin);
            });*/
    };




}

package com.matrimonyproject.matrimony.security.config;

import com.matrimonyproject.matrimony.entity.UserRegister;
import com.matrimonyproject.matrimony.repository.RoleRepository;
import com.matrimonyproject.matrimony.repository.SignupRepository;
import com.matrimonyproject.matrimony.security.jwt.AuthEntryPointJwt;
import com.matrimonyproject.matrimony.security.jwt.AuthTokenFilter;
import com.matrimonyproject.matrimony.security.service.InitDataService;
import com.matrimonyproject.matrimony.security.service.UserDetailsServiceImpl;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

import com.matrimonyproject.matrimony.customEnum.AppRole;

import  com.matrimonyproject.matrimony.entity.Role;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class webSecurityConfig {


    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private DataSource dataSource;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Autowired
    private InitDataService initDataService;



    @Bean
    public AuthTokenFilter authTokenFilter(){
        return new AuthTokenFilter();
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider=new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(this.userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }




    @Bean
    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();

    }



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // Apply public and private configurations
        configurePublicUrls(http);
        configurePrivateUrls(http);

        http.csrf(AbstractHttpConfigurer::disable)
                .exceptionHandling(exception-> {
                    exception.authenticationEntryPoint(unauthorizedHandler);
                }).sessionManagement(session->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
                /*.authorizeHttpRequests(auth->
                        auth.requestMatchers("/matrimony-app/api/auth/signup").permitAll()
                        .requestMatchers("/matrimony-app/api/auth/login").permitAll()
                                .requestMatchers("/matrimony-app/actuator/**").permitAll()
                        .requestMatchers("/v3/api-docs/**") .permitAll()
                        .requestMatchers("/swagger-ui/**").permitAll()
                        .requestMatchers("/api/test/**").permitAll()
                        .requestMatchers("/images/**").permitAll()
                           //explicitly telling spring below url with the pattern needs to be secured
                         .requestMatchers("/matrimony-app/api/enrollment/**")
                                .hasAnyAuthority("Admin user", "Support", "Premium User", "Developer", "Moderator reviewer", "Basic user")
                         .anyRequest().authenticated());*/

        http.authenticationProvider(authenticationProvider());

        http.addFilterBefore(authTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        http.headers(headers -> {
            headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin);
        });

        return http.build();
    }

    /*
     The WebSecurityCustomizer interface in Java, particularly in the context of Spring Security,
     is used to customize the security settings for web applications. It provides a way to
     define specific rules and configurations for handling security aspects,
     such as which URLs should be ignored by security filters, thereby allowing
     for more flexible and granular security policies.

      Key Uses of WebSecurityCustomizer:
      Ignoring Security for Specific Paths: You can specify which URLs should not be
      secured by Spring Security. This is particularly useful for allowing public access
      to static resources (like images or CSS files) or certain endpoints
      (like login or error pages).

      Customization of Security Filters: It allows you to customize how and when certain
      security filters are applied. This can help optimize performance and reduce unnecessary
      checks on public endpoints.

      Configuration of Security Rules: By using WebSecurityCustomizer,
       you can define rules that can adapt based on application requirements,
       such as enabling or disabling security features for specific environments.
  */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web -> web.ignoring().requestMatchers("/v2/api-docs", "/configuration/ui",
                "/swagger-resources/**", "/configuration/security", "/swagger-ui.html", "/webjars/**")
        );
    }



    @Bean
    public CommandLineRunner initData(RoleRepository roleRepository, SignupRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            initDataService.initializeData(roleRepository, userRepository, passwordEncoder);
        };




    }
    private void configurePublicUrls(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/matrimony-app/api/auth/signup").permitAll()
                .requestMatchers("/matrimony-app/api/auth/login").permitAll()
                .requestMatchers("/matrimony-app/actuator/**").permitAll()
                .requestMatchers("/v3/api-docs/**").permitAll()
                .requestMatchers("/swagger-ui/**").permitAll()
                .requestMatchers("/api/test/**").permitAll()
                .requestMatchers("/images/**").permitAll()
                .requestMatchers("/error").permitAll() // Added here
        );
    }

    private void configurePrivateUrls(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/matrimony-app/api/enrollment/**")
                .hasAnyAuthority("Admin user", "Support", "Premium User", "Developer", "Moderator reviewer", "Basic user")
                .anyRequest().authenticated()
        );
    }


}

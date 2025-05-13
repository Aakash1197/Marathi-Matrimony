package com.matrimonyproject.matrimony.controller;


import com.matrimonyproject.matrimony.constant.MatrimonyConstant;
import com.matrimonyproject.matrimony.dto.APIResponse;
import com.matrimonyproject.matrimony.entity.Role;
import com.matrimonyproject.matrimony.entity.UserRegister;
import com.matrimonyproject.matrimony.exception.APIException;
import com.matrimonyproject.matrimony.repository.RoleRepository;
import com.matrimonyproject.matrimony.repository.SignupRepository;
import com.matrimonyproject.matrimony.security.jwt.JwtUtils;
import com.matrimonyproject.matrimony.security.request.LoginRequest;
import com.matrimonyproject.matrimony.security.request.SignupRequest;
import com.matrimonyproject.matrimony.security.response.MessageResponse;
import com.matrimonyproject.matrimony.security.response.UserInfoResponse;
import com.matrimonyproject.matrimony.security.service.UserDetailsImpl;
import com.matrimonyproject.matrimony.service.SignupService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.management.HeapDumpWebEndpoint;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/matrimony-app/api/auth")
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private SignupService signupServiceImpl;

    @Autowired
    private SignupRepository signupRepository;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

 /*   @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private HeapDumpWebEndpoint heapDumpWebEndpoint;*/


    @PostMapping("/signup")
    public ResponseEntity<?> userRegister(@Valid @RequestBody SignupRequest signupRequest) {
        APIResponse apiResponse;
        ResponseEntity<APIResponse> apiResponseResponseEntity;
       String registrationResponse= signupServiceImpl.registerNewUser(signupRequest);
       if(registrationResponse.contains("Registration successful")){
            apiResponse=new APIResponse(registrationResponse,true);
         apiResponseResponseEntity  = new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
       }
       else {
            apiResponse = new APIResponse(registrationResponse, false);
           apiResponseResponseEntity  = new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
       }
       return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);


    }


    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody LoginRequest loginRequest) {
        Authentication authentication;
        UserInfoResponse response;
        ResponseCookie jwtCookie;

       try {
            //login incoming credentials
            logger.info("Login attempt with username: {}", loginRequest.getUserName());
            logger.info("Entered Password : {}", loginRequest.getPassword());

           /* UserRegister userRegister=signupRepository.findByUsername(loginRequest.getUserName()).
                    orElseThrow(()->new APIException("User not found with username (AuthController  )   :  "+loginRequest.getUserName()));

        boolean matches = passwordEncoder.matches(loginRequest.getPassword(), userRegister.getPassword());
        System.out.println("Password match or not: " + matches);*/
            //Perform Authentication
            logger.info("Performing authentication");
            authentication=authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),loginRequest.getPassword()));
            logger.info("Authentication successful");

            //Check If the authentication is successful
            logger.info("Checking authentication status");
            SecurityContextHolder.getContext().setAuthentication(authentication);
            logger.info("Authentication status: {}", authentication.isAuthenticated());


            //Get User details
            logger.info("Getting user details");
            UserDetailsImpl userDetails=(UserDetailsImpl) authentication.getPrincipal();
            logger.info("User details: {}", userDetails);
            logger.info("Encoded password from database: {}", userDetails.getPassword());

            //Generate Jwt token from Cookie
            logger.info("Generating JWT cookie");
            /*String jwtToken= jwtUtils.generateTokenFromUserName(userDetails);*/
            jwtCookie=jwtUtils.generateJwtCookie(userDetails);
            logger.info("JWT cookie generated successfully");

           // 1. Find user by username
            logger.info("Finding user by username: {}", loginRequest.getUserName());
            UserRegister user = signupRepository.findByUsername(loginRequest.getUserName())
                    .orElseThrow(() -> new APIException("User not found with username: " + loginRequest.getUserName()));

            logger.info("User found: {}", user);

         /*   // 2. Check if the raw password matches the encoded password
            if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                throw new APIException("Invalid password");
            }*/

            // 3. Get Roles only if password is correct
            logger.info("Getting user roles");
            List<Role> roles = userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)  // Extract role name (as a String)
                    .map(roleName -> user.getRoles().stream()
                            .filter(role -> role.getRoleName().equals(roleName))
                            .findAny()
                            .orElseThrow(() -> new APIException("Role '" + roleName + "' is not active or not assigned to this user.")))
                    .collect(Collectors.toList());
            logger.info("User roles: {}", roles);
            //setting UserInfoResponse() constructor value without Jwt token
            logger.info("Setting UserInfoResponse() constructor value without Jwt token");
            logger.info("UserName  152:"+userDetails.getUsername());
            response= new UserInfoResponse(userDetails.getId(),userDetails.getUsername(),
                    userDetails.getFirstName(),userDetails.getMiddleName(),
                    userDetails.getLastName(), userDetails.getEmail(),
                    userDetails.getMobile(),userDetails.getGender(),
                    userDetails.getPlans(),userDetails.getPasswordExpirationDate(),
                    userDetails.getFailedLoginAttempts(),userDetails.getLockTime(),
                    userDetails.isAccountNonLocked(),userDetails.getADD_TIME(),
                    userDetails.getADD_DATE(),userDetails.getADD_BY_USER(),
                    userDetails.getMDF_TIME(),userDetails.getMDF_DATE(),
                    userDetails.getMDF_BY_USER(),userDetails.getDEL_TIME(),
                    userDetails.getDEL_DATE(),userDetails.getDEL_BY_USER(),
                    userDetails.getDEL_FLG(), roles);



            logger.info("UserInfoResponse() constructor value without Jwt token set successfully");

        }
        catch (AuthenticationException exception) {
            logger.error("Authentication failed: {}", exception.getMessage());

            // Handle bad credentials
            Map<String, Object> map = new HashMap<>();
            map.put("message", "Bad credentials: incorrect username or password");
            map.put("status", false);
            return new ResponseEntity<>(map, HttpStatus.UNAUTHORIZED);
        }
        logger.info("User logged in successfully");
        HttpHeaders header = new HttpHeaders();
        logger.info("Setting JWT cookie in response header");
        header.add(HttpHeaders.SET_COOKIE, jwtCookie.toString());
        logger.info("JWT cookie set successfully");

        return new ResponseEntity<>(response, header,HttpStatus.OK);

    }


    @PostMapping("/logout")
    public ResponseEntity<?> userSignOut(){
        ResponseCookie cookie=jwtUtils.generateJwtCleanCookie();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, String.valueOf(cookie))
                .body(new MessageResponse(MatrimonyConstant.LOGOUT));
    }


}

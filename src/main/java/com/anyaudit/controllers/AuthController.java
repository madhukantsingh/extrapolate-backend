package com.anyaudit.controllers;

import java.util.*;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.anyaudit.payload.request.LoginRequest;
import com.anyaudit.payload.request.SignupRequest;
import com.anyaudit.payload.response.JwtResponse;
import com.anyaudit.payload.response.MessageResponse;
import com.anyaudit.repository.RoleRepository;
import com.anyaudit.repository.UserRepository;
import com.anyaudit.security.jwt.JwtUtils;
import com.anyaudit.security.services.UserDetailsImpl;
import com.anyaudit.service.AuthManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.anyaudit.models.ERole;
import com.anyaudit.models.User;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  AuthManager authManager;
  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt,
                         userDetails.getId(),
                         userDetails.getUsername(),
                         userDetails.getEmail(),
                         userDetails.getPhoneNo(),
                         roles));
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      List<String> errors = bindingResult.getFieldErrors().stream()
              .map(error -> error.getField() + ": " + error.getDefaultMessage())
              .collect(Collectors.toList());
      return ResponseEntity.badRequest().body(new MessageResponse(errors.toString()));
    }

    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
    }

    if (userRepository.existsByPhoneNo(signUpRequest.getPhoneNo())) {
      return ResponseEntity.badRequest().body(new MessageResponse("Error: Phone number is already in use!"));
    }

    // Create new user's account
    User user = new User(
            signUpRequest.getUsername(),
            signUpRequest.getEmail(),
            encoder.encode(signUpRequest.getPassword()),
            signUpRequest.getPhoneNo(),
            signUpRequest.getRole().stream().map(role -> {
              switch (role) {
                case "Admin":
                  return roleRepository.findByName(ERole.ROLE_ADMIN)
                          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                case "Audit Manager":
                  return roleRepository.findByName(ERole.ROLE_MANAGER)
                          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                case "Audit Incharge":
                  return roleRepository.findByName(ERole.ROLE_INCHARGE)
                          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                case "Senior":
                  return roleRepository.findByName(ERole.ROLE_SENIOR)
                          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                case "Junior":
                    return roleRepository.findByName(ERole.ROLE_JUNIOR)
                          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                default:
                  throw new IllegalArgumentException("Invalid role: " + role);
              }
            }).collect(Collectors.toSet()));

    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }

    @GetMapping("/list")
//  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public ResponseEntity<List<User>> getUsers() {
    List<User> users = userRepository.findAll();
    return ResponseEntity.ok(users);
  }


  @GetMapping("/names")
  public List<Map<String, Object>> findNameAndId() {
    List<Object[]> users = authManager.findNameAndId();
    List<Map<String, Object>> resultList = new ArrayList<>();
    for (Object[] user : users) {
      Map<String, Object> clientMap = new HashMap<>();
      clientMap.put("value", user[0]);
      clientMap.put("label", user[1]);
      resultList.add(clientMap);
    }
    return resultList;

  }

}






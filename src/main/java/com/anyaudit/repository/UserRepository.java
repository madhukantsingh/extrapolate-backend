package com.anyaudit.repository;

import java.util.List;
import java.util.Optional;

import com.anyaudit.models.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anyaudit.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
  Boolean existsByPhoneNo(String phoneNo);

  Boolean existsByRoles(ERole name);
  @Query(value = "SELECT id,username FROM users", nativeQuery = true)
  List<Object[]> findNameAndId();

}

package com.anyaudit.repository;

import com.anyaudit.models.Assignment;
import org.springframework.data.jpa.repository.Query;
import com.anyaudit.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
//        @Query(value = "SELECT assignment_id, assignment_name FROM assignment WHERE client_id = :clientId", nativeQuery = true)
//        List<Object[]> findAssignmentsByClientId(@Param("clientId") Long clientId);
        @Query(value = "SELECT COUNT(DISTINCT a.client_id) as client_count,COUNT(DISTINCT a.assignment_id) as assignment_count  FROM campus.assignment a where userep_id = :userId or userrp_id = :userId", nativeQuery = true)
        List<Object[]> findAssignmentsByClientId(@Param("userId") Long clientId);
        @Query(value ="SELECT COUNT(DISTINCT a.assignment_id) FROM assignment a INNER JOIN user_client uc ON a.assignment_id = uc.assignment_id WHERE uc.user_id = :userId", nativeQuery = true)
        int countDistinctAssignmentsByUser(@Param("userId") int userId);

        @Query(value = "SELECT assignment_id,assignment_name FROM campus.assignment;", nativeQuery = true)
        List<Object[]> findAssignmentNameAndId();


}

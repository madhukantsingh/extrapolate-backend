package com.anyaudit.repository;


import com.anyaudit.models.Decisions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DecisionsRepository extends JpaRepository<Decisions, Long> {
}

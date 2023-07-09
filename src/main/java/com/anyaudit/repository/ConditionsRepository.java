package com.anyaudit.repository;

import com.anyaudit.models.Conditions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ConditionsRepository extends JpaRepository<Conditions, Long> {
}

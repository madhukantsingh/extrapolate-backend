package com.anyaudit.repository;


import com.anyaudit.models.Year;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YearRepository extends JpaRepository<Year, Long> {
}

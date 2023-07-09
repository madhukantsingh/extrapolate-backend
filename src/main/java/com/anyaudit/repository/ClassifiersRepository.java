package com.anyaudit.repository;

import com.anyaudit.models.Classifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassifiersRepository extends JpaRepository<Classifier, Long> {
}

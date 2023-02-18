package com.batuhanerol.spring.data.jpaintroduction.repository;

import com.batuhanerol.spring.data.jpaintroduction.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Long> {
}

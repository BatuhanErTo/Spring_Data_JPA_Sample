package com.batuhanerol.spring.data.jpaintroduction.repository;

import com.batuhanerol.spring.data.jpaintroduction.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

}

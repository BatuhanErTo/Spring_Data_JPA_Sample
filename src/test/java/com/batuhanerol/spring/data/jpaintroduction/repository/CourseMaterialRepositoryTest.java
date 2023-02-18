package com.batuhanerol.spring.data.jpaintroduction.repository;

import com.batuhanerol.spring.data.jpaintroduction.entity.Course;
import com.batuhanerol.spring.data.jpaintroduction.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .title("Data Structure")
                .credit(6)
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("eba.com.tr")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void getAllCourseMaterials(){
        List<CourseMaterial> courseMaterialList = courseMaterialRepository.findAll();
        System.out.println("course material list: " + courseMaterialList);
    }
}
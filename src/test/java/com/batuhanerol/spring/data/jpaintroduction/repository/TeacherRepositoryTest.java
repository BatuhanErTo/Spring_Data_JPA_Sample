package com.batuhanerol.spring.data.jpaintroduction.repository;

import com.batuhanerol.spring.data.jpaintroduction.entity.Course;
import com.batuhanerol.spring.data.jpaintroduction.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;
    @Test
    public void saveTeacher(){
        Course courseJava = Course.builder()
                .title("Java")
                .credit(4)
                .build();
        Course courseCpp = Course.builder()
                .title("C++")
                .credit(4)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Kamil")
                .lastName("Vurmaz")
                //.courses(List.of(courseJava,courseCpp))
                .build();
        teacherRepository.save(teacher);
    }
}
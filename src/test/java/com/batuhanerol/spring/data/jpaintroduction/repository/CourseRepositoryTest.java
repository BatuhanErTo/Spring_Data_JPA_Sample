package com.batuhanerol.spring.data.jpaintroduction.repository;

import com.batuhanerol.spring.data.jpaintroduction.entity.Course;
import com.batuhanerol.spring.data.jpaintroduction.entity.Student;
import com.batuhanerol.spring.data.jpaintroduction.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;
    @Test
    public void getAllCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses list: "+courses);
    }
    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Kemal")
                .lastName("Başaran")
                .build();
        Course course = Course.builder()
                .title("Database")
                .credit(4)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable pageable1 = PageRequest.of(0,3);
        Pageable pageable2 = PageRequest.of(1,2);
        List<Course> courses = courseRepository.findAll(pageable1).getContent();
        long totalElements = courseRepository.findAll(pageable1).getTotalElements();
        long totalPages = courseRepository.findAll(pageable1).getTotalPages();
        System.out.println("totalElements: "+totalElements);
        System.out.println("totalPages: "+totalPages);
        System.out.println("courses list: "+courses);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle = PageRequest.of(0,2, Sort.by("title"));
        Pageable sortByDesc = PageRequest.of(0,2, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc = PageRequest.of(0,2, Sort.by("title").descending()
                .and(Sort.by("credit").descending()));
        List<Course> courses = courseRepository.findAll(sortByDesc).getContent();
        System.out.println("sortByDesc: " + courses);
    }

    @Test
    public void findByTitleContaining(){
        Pageable firstTenRecords = PageRequest.of(0,10);
        List<Course> courses = courseRepository.findByTitleContaining("D",firstTenRecords).getContent();
        System.out.println("courses: "+courses);
    }

    @Test
    public void addCourse(){
        Teacher teacher = Teacher.builder()
                .firstName("Sabri")
                .lastName("Kara")
                .build();
        Student student = Student.builder()
                .firstName("Ali")
                .lastName("Fuat")
                .emailId("alafuat@yahoo.com")
                .build();
        Course course = Course.builder()
                .title("Computer Networking")
                .credit(8)
                .teacher(teacher)
                .students(List.of(student))
                .build();

        courseRepository.save(course);
    }
}
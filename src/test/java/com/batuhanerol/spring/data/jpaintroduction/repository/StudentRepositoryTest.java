package com.batuhanerol.spring.data.jpaintroduction.repository;

import com.batuhanerol.spring.data.jpaintroduction.entity.Guardian;
import com.batuhanerol.spring.data.jpaintroduction.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("bataer57@gmail.com")
                .firstName("Batuhan")
                .lastName("Erol")
                //.guardianName("Ismail")
                //.guardinMobile("124121")
                //.gurdianEmail("ismailErol@gmail.com")
                .build();
        studentRepository.save(student);
    }
    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Kezban")
                .email("kzbnErol80@hotmail.com")
                .mobile("124224142")
                .build();
        Student student = Student.builder()
                .firstName("Tuana")
                .lastName("Erol")
                .emailId("tuana@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }
    @Test
    public void getAllStudent(){
        List<Student> students = studentRepository.findAll();
        System.out.println("student list: "+students);
    }

    @Test
    public void getStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("Batuhan");
        System.out.println("student list: "+students);
    }

    @Test
    public void getStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("uhan");
        System.out.println("student list: "+students);
    }

    @Test
    public void getStudentByGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("Ismail");
        System.out.println("student list: "+students);
    }

    @Test
    public void getStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("bataer57@gmail.com");
        System.out.println("student list: "+student);
    }
    @Test
    public void getStudentLastNameByEmailAddress(){
        String studentLastName = studentRepository.getStudentLastNameByEmailAddress("bataer57@gmail.com");
        System.out.println("student list: "+studentLastName);
    }

    @Test
    public void getStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("bataer57@gmail.com");
        System.out.println("student list: "+student);
    }
}
package com.batuhanerol.spring.data.jpaintroduction.repository;

import com.batuhanerol.spring.data.jpaintroduction.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
     List<Student> findByFirstName(String firstName);
     List<Student> findByFirstNameContaining(String text);
     List<Student> findByLastNameNotNull();
     List<Student> findByGuardianName(String guardianName);
     @Query("select s from Student s where s.emailId = ?1")//JPQL
     Student getStudentByEmailAddress(String emailId);
     @Query("select s.lastName from Student s where s.emailId = ?1")//JPQL
     String getStudentLastNameByEmailAddress(String emailId);
     @Query(
             value = "select * from tbl_student as st where st.email_address = ?1 ",
             nativeQuery = true
     )
     Student getStudentByEmailAddressNative(String emailId);

     @Query(
             value = "select * from tbl_student as st where st.email_address = :emailId ",
             nativeQuery = true
     )
     Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);
     @Modifying
     @Transactional
     @Query(
             value = "update tbl_student set firs_name = ?1 where email_address = ?2",
             nativeQuery = true
     )
     int updateStudentNameByEmailId(String firstName, String emailId);
}

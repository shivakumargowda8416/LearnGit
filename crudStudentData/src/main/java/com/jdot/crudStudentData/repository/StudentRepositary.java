package com.jdot.crudStudentData.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdot.crudStudentData.entity.Student;


public interface StudentRepositary extends JpaRepository<Student, Long> {

}
    
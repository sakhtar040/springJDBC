package org.spring.jdbc.dao;

import org.spring.jdbc.entities.Student;

public interface StudentDao {
    public int insert(Student student);
    public int update(Student student);
    public int delete(int studentId);
    public Student getStudent(int studentId);
}

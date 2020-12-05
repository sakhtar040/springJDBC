package org.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.spring.jdbc.entities.Student;
import org.springframework.jdbc.core.RowMapper;

public class RowMapperImpl implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getInt(1));
        student.setName(resultSet.getString(2));
        student.setAddress(resultSet.getString(3));
        return student;
    }
}

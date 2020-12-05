package org.spring.jdbc.dao;

import org.spring.jdbc.entities.Student;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDaoImpl implements StudentDao {
    private JdbcTemplate template;

    @Override
    public int insert(Student student) {
        //insert
        String query = "insert into student (id,name,address) values (?,?,?)";
        int result = this.template.update(query, student.getId(), student.getName(), student.getAddress());
        return result;
    }

    @Override
    public int update(Student student) {
        //update
        String query = "update student set name=?, address=? where id=?";
        int result = this.template.update(query, student.getName(), student.getAddress(), student.getId());
        return result;
    }

    @Override
    public int delete(int studentId) {
        //delete
        String query = "delete from student where id=?";
        int result = this.template.update(query, studentId);
        return result;
    }

    @Override
    public Student getStudent(int studentId) {
        //select single student
        String query = "select * from student where id=?";
        //int result =
        return null;
    }


    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
}

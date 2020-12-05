package org.spring.jdbc.dao;

import java.util.List;
import org.spring.jdbc.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("studentDaoImpl")
public class StudentDaoImpl implements StudentDao {
    @Autowired
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
        RowMapper<Student> rowMapper = new RowMapperImpl();
        Student student = this.template.queryForObject(query, rowMapper, studentId);
        return student;
    }

    @Override
    public List<Student> getStudents() {
        //select students
        String query = "select * from student";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        List<Student> student = this.template.query(query, rowMapper);
        return student;
    }


    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
}

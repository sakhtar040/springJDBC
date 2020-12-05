package org.spring.jdbc;

import java.util.List;
import java.util.Scanner;
import org.spring.jdbc.dao.StudentDao;
import org.spring.jdbc.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App{
    public static void main(String[] args) {
        System.out.println("Spring Application JDBC");
        //xml
        //ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        //annotation
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

        StudentDao studentDao = context.getBean("studentDaoImpl", StudentDao.class);
        //insert
        Student student1 = new Student();
        student1.setId(7);
        student1.setName("RDX-Akhtar");
        student1.setAddress("Uttam Nagar Mohan Garden");
        int resultInsert = studentDao.insert(student1);
        System.out.println("Inserted "+resultInsert+" row");

        //update
        Student student2 = new Student();
        student2.setId(5);
        student2.setName("RDX-Akht4rar");
        student2.setAddress("Uttam Nagar Mohan Garden");
        int resultUpdate = studentDao.update(student2);
        System.out.println("Updated "+resultUpdate+" row");

        //delete
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter row id:");
        int input = Integer.parseInt(scanner.nextLine());
        int result = studentDao.delete(input);
        System.out.println(result+" row deleted...");

        //get single student
        Student student = studentDao.getStudent(5);
        System.out.println("Student Details: "+student);

        //get all students
        List<Student> students = studentDao.getStudents();
        for (Student s: students){
            System.out.println(s);
        }
    }
}

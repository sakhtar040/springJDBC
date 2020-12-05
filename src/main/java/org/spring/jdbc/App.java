package org.spring.jdbc;

import java.util.Scanner;
import org.spring.jdbc.dao.StudentDao;
import org.spring.jdbc.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App{
    public static void main(String[] args) {
        System.out.println("Spring Application JDBC");
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        StudentDao studentDao = context.getBean("studentDaoImpl", StudentDao.class);
        /*Student student = new Student();
        student.setId(4);
        student.setName("RDX-Akhtar");
        student.setAddress("Uttam Nagar Mohan Garden");*/
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter row id:");
        int input = Integer.parseInt(scanner.nextLine());
        int result = studentDao.delete(input);
        System.out.println(result+" row deleted...");
    }
}

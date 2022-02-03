package main;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.config.AppContext;
import spring.object.MemberDAO;
import spring.object.MemberDTO;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        MemberDAO memberDAO = context.getBean("memberDAO", MemberDAO.class);
        MemberDTO memberDTO = context.getBean("memberDTO", MemberDTO.class);

        try {
            memberDAO.setConnection(dataSource);
        } catch (SQLException e) {
            System.out.println("Connection error: " + e);
        }

        memberDTO.setEmail("test.com");
        memberDTO.setPassword("132413");
        memberDTO.setName("test02");

        memberDAO.setMember(memberDTO);

        try {
            System.out.println(memberDAO.insert_member());
        } catch (SQLException e) {
            System.out.println("Insert error: " + e);
        }
    }
}

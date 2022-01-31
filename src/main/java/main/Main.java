package main;

import org.apache.tomcat.jdbc.pool.DataSource;
import spring.object.MemberDAO;
import spring.object.MemberDTO;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        MemberDTO memberDTO = new MemberDTO();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/logio");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        dataSource.setInitialSize(2);
        dataSource.setMaxActive(100);

        memberDTO.setEmail("test01@email.com");
        memberDTO.setPassword("1111");
        memberDTO.setName("Tester");

        try {
            MemberDAO memberDAO = new MemberDAO(dataSource, memberDTO);
            System.out.println(memberDAO.insert_member());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

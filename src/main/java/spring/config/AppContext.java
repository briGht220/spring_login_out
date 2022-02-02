package spring.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.object.MemberDAO;
import spring.object.MemberDTO;

@Configuration
public class AppContext {
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/logio");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        dataSource.setInitialSize(2);
        dataSource.setMaxActive(10);

        return dataSource;
    }

    public MemberDAO memberDAO() {
        return memberDAO();
    }

    public MemberDTO memberDTO() {
        return memberDTO();
    }
}

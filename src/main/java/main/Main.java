package main;

import org.apache.tomcat.jdbc.pool.DataSource;
import spring.db_query.DBQuery;

public class Main {
    public static void main(String[] args) {
        DataSource dataSource = new DataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/logio");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        dataSource.setInitialSize(2);
        dataSource.setMaxActive(10);

        DBQuery dbQuery = new DBQuery(dataSource);
        System.out.println(dbQuery.count_member());
    }
}

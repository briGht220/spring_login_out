package spring.db_query;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBQuery {
    private DataSource dataSource;

    public DBQuery() {}

    public DBQuery(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int count_member() {
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select count(*) from member");

            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            System.out.println(e);
            return -1;
        }
    }
}

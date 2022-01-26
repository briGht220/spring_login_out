package spring.db_query;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbquery {
    private DataSource dataSource;

    public dbquery(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int count_member() {
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select count(*) from member");

            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package spring.object;

import javax.sql.DataSource;
import java.sql.*;

public class MemberDAO {
    private Connection connection;
    private MemberDTO member;

    public MemberDAO(DataSource dataSource) throws SQLException {
        this.connection = dataSource.getConnection();
    }

    public MemberDAO(DataSource dataSource, MemberDTO member) throws SQLException {
        this.connection = dataSource.getConnection();
        this.member = member;
    }

    public int count_member() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select count(*) from member");

        resultSet.next();

        int count = resultSet.getInt(1);

        statement.close();
        resultSet.close();
        connection.close();

        return count;
    }

    public String insert_member() throws SQLException {
        String insertQuery = "insert into member values(null, ?, ?, ?);";
        PreparedStatement statement = connection.prepareStatement(insertQuery);

        statement.setString(1, member.getEmail());
        statement.setString(2, member.getPassword());
        statement.setString(3, member.getName());
        statement.executeUpdate();

        statement.close();
        connection.close();

        return "Insert Success";
    }


    public void setConnection(DataSource dataSource) throws SQLException {
        this.connection = dataSource.getConnection();
    }

    public void setMember(MemberDTO member) {
        this.member = member;

    }
}

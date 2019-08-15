import com.mysql.cj.protocol.Resultset;


import java.sql.*;

public class connection
{
static
{
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}



    public static Connection getconnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true","root", "123456");
    }


    public static void closeconnection(ResultSet rs,Statement stmt,Connection conn)
    {
        try {
            if (rs != null )
            {
                rs.close();
            }
            if (stmt != null )
            {
                stmt.close();
            }
            if (conn != null)
            {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void insert(Statement stmt)
    {
        try {
            stmt.executeUpdate("insert into student(name) values ('芙兰朵露');");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void delete(Statement stmt)
    {
        try {
            stmt.executeUpdate("delete from student where name = '芙兰朵露'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void info(Statement stmt) throws SQLException {
        ResultSet rs=  stmt.executeQuery("SELECT  * from student");
        while(rs.next())
        {
            System.out.println(rs.getString("name"));
        }
    }


}

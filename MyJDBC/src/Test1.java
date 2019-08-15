import org.junit.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Test1 {

    private Connection getconnection = null;
    private static PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;


    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            String username = sc.next();
            String password = sc.next();
            sc.close();
            Connection getconnection = connection.getconnection();
            PreparedStatement preparedStatement = getconnection.prepareStatement("SELECT * FROM login where username = ? and password = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                System.out.print("欢迎回来"+username);
            }
            else
            {
                System.out.print("用户名或密码不正确");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }
    public void login()
    {


    }


    @Test
    public void select()  {

        try {
            getconnection = connection.getconnection();
            preparedStatement = getconnection.prepareStatement("SELECT  * from student where name = ?");
            preparedStatement.setString(1, "芙兰朵露");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                System.out.println(resultSet.getString("name")+"    "+resultSet.getString("sex"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.closeconnection(resultSet,preparedStatement,getconnection);
        }

    }

    @Test
    public  void insert(){
        try {
            getconnection = connection.getconnection();
            preparedStatement = getconnection.prepareStatement("insert into student(name, sex) values(?,?)");
            preparedStatement.setString(1, "蕾米莉亚");
            preparedStatement.setString(2, "女");
            int i = preparedStatement.executeUpdate();
            System.out.print(i);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.closeconnection(resultSet,preparedStatement,getconnection);
        }
    }


    public void update()
    {
        try {
            getconnection = connection.getconnection();
            preparedStatement = getconnection.prepareStatement("update student set sex=? where sex=? ");
            preparedStatement.setString(1, "女");
            preparedStatement.setString(2, "男");
            int i = preparedStatement.executeUpdate();
            System.out.print(i);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.closeconnection(resultSet,preparedStatement,getconnection);
        }
    }


    public void delete()
    {
        try {
            getconnection = connection.getconnection();
            preparedStatement = getconnection.prepareStatement("delete from student where name != ? and name != ?");
            preparedStatement.setString(1, "蕾米莉亚");
            preparedStatement.setString(2, "芙兰朵露");
            int i = preparedStatement.executeUpdate();
            System.out.print(i);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.closeconnection(resultSet,preparedStatement,getconnection);
        }
    }



}

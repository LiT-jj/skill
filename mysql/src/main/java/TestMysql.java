import java.sql.*;

public class TestMysql {
    public static void main(String[] args) {
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://121.5.242.23:3306/mysql", "root", "qwe@1997");
            String sql = "select host,user from user;";
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            while(resultSet.next()){
                System.out.println(resultSet.getString(1) + " - " + resultSet.getString(2));
            }
            resultSet.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectDB {
	public static Connection connectDB() {
		String url = "jdbc:mysql://localhost:3306/banbe?useUnicode=true&characterEncoding=UTF-8&characterSetResults=UTF-8"; // Địa chỉ và tên database
        String username = "banbe_user"; // Tên đăng nhập MySQL
        String password = "1234"; // Mật khẩu của MySQL

        try {
            // Kết nối đến database
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối: " + e.getMessage());
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        return null;
	}
}

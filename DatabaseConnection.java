import java.sql.*;
import javax.swing.*;

public class DatabaseConnection {

	public static Connection ConnectDb() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\user\\eclipse-workspace\\BarakaSystem\\dbRegistration.db\\");
			return conn;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error in connecting to the database.");
			e.printStackTrace();
			return null;
		}
	}
	
	public static Connection ConnectMySQLDb() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mwanzobaraka","root","staphone");
			return conn;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error in connecting to the database.");
			e.printStackTrace();
			return null;
		}
	}

}

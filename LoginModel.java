
import java.sql.*;

public class LoginModel {
	Connection connection;
	
	public LoginModel() {
		try {
			this.connection = SqliteConnection.ConnectDb();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if (this.connection == null) {
			System.exit(1);
		}
	}
	
	public boolean isDbConnected() {
		return this.connection != null;
	}
	
	public boolean isLoggedIn(String username, String password) throws Exception{
		PreparedStatement pr = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM User where Username = ? and Password = ?";
		
		try {
			pr = this.connection.prepareStatement(sql);
			pr.setString(1, username);
			pr.setString(2, password);
			
			rs = pr.executeQuery();
			
			boolean boll_1;
			if(rs.next()) {
				return true;
			}
			return false;
			
		}catch(Exception e) {
			return false;
		} finally {
			pr.close();
			rs.close();
		}
	}
}

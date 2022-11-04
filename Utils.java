import java.sql.*;

public class Utils {
	Connection connection;
	
	public Utils() {
		try {
			this.connection = SqliteConnection.ConnectMySQLDb();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if (this.connection == null) {
			System.exit(1);
		}
	}
	
	public boolean canApplyLoan(int id) throws SQLException {
		PreparedStatement pr = null;
		ResultSet rs = null;
		
//		String sql = "SELECT * FROM MembContribution WHERE MemberId = ?";
		String sql = "SELECT * FROM membcontribution WHERE MemberId = ?";
		
		try {
			pr = this.connection.prepareStatement(sql);
			pr.setInt(1,id);
			
			rs = pr.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			return false;
			
		}catch(Exception e) {
			return false;
		} finally {
			pr.close();
			rs.close();
			this.connection.close();
		}
	}
	
	public boolean hasExistingLoans(int id) throws SQLException{
		PreparedStatement pr = null;
		ResultSet rs = null;
		
//		String sql = "SELECT * FROM MembLoanApplication WHERE MemberId = ?";
		String sql = "SELECT * FROM membloanapplication WHERE MemberId = ?";
		
		try {
			pr = this.connection.prepareStatement(sql);
			pr.setInt(1,id);
			
			rs = pr.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			return false;
			
		}catch(Exception e) {
			return false;
		} finally {
			pr.close();
			rs.close();
			this.connection.close();
		}
	}
}

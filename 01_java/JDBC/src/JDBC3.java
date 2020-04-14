import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement st  = null;
		ResultSet rs = null;
		
		//1. Driver loading
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2. Connection
			con =
			DriverManager.getConnection("jdbc:mysql://127.0.0.1:3305/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8","ssafy","ssafy");
			// 3. Statement create
			st = con.createStatement();
			// 4. SQL Execute
			rs = st.executeQuery("select * from emp");
			while(rs.next()) {
				System.out.println(rs.getString("ename")+ " , " + rs.getInt("sal"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("class loading fail");
		}finally {
			// 5. close
			try {
				if(rs!=null) rs.close();
				if(st!=null) st.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
	}

}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC4 {

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
			int sal = 2000;
			int deptno = 30;
			String sql = "select * from emp where sal > ? and deptno = ?";
			PreparedStatement pSt = con.prepareStatement(sql);
			pSt.setInt(1,sal);
			pSt.setInt(2, deptno);
			// 4. SQL Execute
			rs = pSt.executeQuery();
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

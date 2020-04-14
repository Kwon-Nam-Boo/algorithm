import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC5 {

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
			int empno = 8888;
			String name= "도우너";
			int sal = 3000;
			int deptno = 30;
			
			String sql = "insert into emp(empno, ename, sal, deptno) values(?,?,?,?)";
			PreparedStatement pSt = con.prepareStatement(sql);
			pSt.setInt(1,empno);
			pSt.setString(2, name);
			pSt.setInt(3,sal);
			pSt.setInt(4,deptno);
			// 4. SQL Execute
			pSt.executeUpdate();
			System.out.println("입력 성공!");
		
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

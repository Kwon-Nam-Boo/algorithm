import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBC6 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1. Driver loading
				Class.forName("com.mysql.cj.jdbc.Driver");
				//2. Connection
				Connection con =
				DriverManager.getConnection("jdbc:mysql://127.0.0.1:3305/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8","ssafy","ssafy");
				// 3. Statement create
				Statement st = con.createStatement();
				// 4. SQL Execute
				ResultSet rs = st.executeQuery("select * from emp");
				ResultSetMetaData metaData = rs.getMetaData();
				int cnt = metaData.getColumnCount();
				System.out.println(cnt);
				for (int i = 1; i <= cnt; i++) {
					System.out.println(metaData.getColumnName(i) + " " + metaData.getColumnTypeName(i) + " ");
				}
				System.out.println();
				
				/*while(rs.next()) {
					System.out.println(rs.getString("ename")+ " , " + rs.getInt("sal"));
				}*/
				// 5. close
				rs.close();
				st.close();
				con.close();
	}
}

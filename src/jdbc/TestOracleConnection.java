package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestOracleConnection {

	public static void main(String[] args) throws Exception {

		Connection con = DriverManager.getConnection
				 ("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
		System.out.println("Connected To Oracle");
		con.close();
		
	}

}

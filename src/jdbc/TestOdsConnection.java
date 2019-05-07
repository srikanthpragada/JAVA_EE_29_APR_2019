package jdbc;

import java.sql.Connection;
import oracle.jdbc.pool.OracleDataSource;

public class TestOdsConnection {

	public static void main(String[] args) throws Exception {

		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@localhost:1521:XE");
		ods.setUser("hr");
		ods.setPassword("hr");

		try (Connection con = ods.getConnection()) {
			System.out.println("Connected To Oracle using ODS");
		}

	}

}

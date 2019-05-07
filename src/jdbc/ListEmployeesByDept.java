package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ListEmployeesByDept {

	public static void main(String[] args) throws Exception {

		Connection con = DriverManager.getConnection
				 ("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
		Scanner s = new Scanner(System.in);
		System.out.print("Enter dept number :");
		int deptno = s.nextInt();
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery
		 ("select first_name, salary from employees where department_id = "
		       + deptno);
		while(rs.next())
		{
			System.out.printf("%-15s - %d\n",  rs.getString("first_name"),      
					     rs.getInt("salary"));
		}
		st.close();
		con.close();
		
	}

}

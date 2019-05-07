// List employees by dept using PreparedStatement 

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ListEmployeesByDept2 {

	public static void main(String[] args) throws Exception {

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
		Scanner s = new Scanner(System.in);
		System.out.print("Enter dept number :");
		int deptno = s.nextInt();

		PreparedStatement ps = con.prepareStatement
				("select first_name, salary from employees where department_id = ?");
		ps.setInt(1, deptno);
		ResultSet rs = ps.executeQuery();

		if (!rs.next())
			System.out.println("Sorry! No employees found!");
		else {
			do {
				System.out.printf("%-15s - %d\n", rs.getString("first_name"), rs.getInt("salary"));
			} while (rs.next());
		}
		ps.close();
		con.close();

	}

}

package jdbc;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.Predicate;

import oracle.jdbc.rowset.OracleFilteredRowSet;

public class FiltertJobs {

	public static class CostlyJobs implements Predicate {

		@Override
		public boolean evaluate(RowSet rs) {
			try {
				return rs.getInt("min_salary") > 5000;
			} catch (Exception ex) {
				return false;
			}
		}

		@Override
		public boolean evaluate(Object arg0, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean evaluate(Object arg0, String arg1) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

	}
	
	public static class CheapJobs implements Predicate {

		@Override
		public boolean evaluate(RowSet rs) {
			try {
				return rs.getInt("min_salary") < 3000;
			} catch (Exception ex) {
				return false;
			}
		}

		@Override
		public boolean evaluate(Object arg0, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean evaluate(Object arg0, String arg1) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

	}

	public static void main(String[] args) throws Exception {
		FilteredRowSet frs = new OracleFilteredRowSet();
		frs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		frs.setUsername("hr");
		frs.setPassword("hr");
		frs.setCommand("select * from jobs");
		frs.execute();
	
		frs.setFilter(new CostlyJobs());
		while (frs.next()) {
			System.out.println(frs.getString(2) + ":" + frs.getInt(3));
		}
		
		System.out.println("Cheap Jobs");
		frs.setFilter(new CheapJobs());
		frs.beforeFirst();
		while (frs.next()) {
			System.out.println(frs.getString(2) + ":" + frs.getInt(3));
		}
		
		frs.close(); 
	}

}

package it.polito.tdp.ufo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class SightingDAO {

	
	
	public List<String> ExistingShapes() {
		
		String jdbcURL = "jdbc:mysql://localhost/ufo_sightings?user=root&password=root";
			try {
				Connection conn = DriverManager.getConnection(jdbcURL);
				
				String sql = "SELECT DISTINCT shape "
						+ "FROM sighting "
						+ "WHERE shape<>'' "
						+ "GROUP BY shape ASC ";
				
				PreparedStatement st = conn.prepareStatement(sql);
				
				ResultSet res = st.executeQuery();
				List <String> ArrayLine = new ArrayList<String>();
				
				while(res.next()) {
					ArrayLine.add(res.getString("shape"));
				}
				
				String aux = "";
				
				for(String s: ArrayLine) {
					aux += s+"\n";
				}
				
				conn.close();
				st.close();
			
		return ArrayLine;
		
			}
			catch(SQLException e) {
				throw new RuntimeException("Error",e);
			}
	}
		
	public int CountByShape(String shape) {
		int count = 0;
		
		String jdbcURL = "jdbc:mysql://localhost/ufo_sightings?user=root&password=root";
		
		Connection conn;
			try {
				conn = DriverManager.getConnection(jdbcURL);
			
			
			String sql2 = "SELECT DISTINCT count(*) AS total FROM sighting WHERE shape = ? ";
		
			PreparedStatement st2 = conn.prepareStatement(sql2);
			st2.setString(1, shape);
			
			ResultSet res2 = st2.executeQuery();
			res2.first();
			
			count = res2.getInt("total");
			conn.close();
			st2.close();
			
			return count;
			
			}
			catch(SQLException e) {
		
		e.printStackTrace();
		return 0;
	}
	
	}
	
	
}	

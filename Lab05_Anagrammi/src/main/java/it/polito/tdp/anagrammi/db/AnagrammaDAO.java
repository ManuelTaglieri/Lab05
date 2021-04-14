package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDAO {
	
	public boolean isCorret(String anagramma) {
		
		String Sql = "SELECT * FROM parola WHERE nome = ? ";
		
		boolean corretto = false;
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(Sql); 
			st.setString(1, anagramma);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				corretto = true;
			}
			
			rs.close();
			st.close();
			conn.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return corretto;
		
	}

}

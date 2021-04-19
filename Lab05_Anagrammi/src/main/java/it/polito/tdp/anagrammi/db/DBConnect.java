package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class DBConnect {
	
		static private HikariDataSource ds = null;
		static private final String jdbcURL = "jdbc:mysql://localhost/dizionario?user=root&password=TdP21";
	
	public static Connection getConnection() throws SQLException {
		
		if (ds==null) {
			ds = new HikariDataSource();
			ds.setJdbcUrl(jdbcURL);
			// ds.setUsername ds.setPassword (se non lo faccio nella URL)
		}
		
		//Non serve chiudere il dataSource, si chiude quando chiuderò il programma
		
		return ds.getConnection();
		
	}

}

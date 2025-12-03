package org.staffManagement.dbConfig;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DbConfiguration {
	
	protected Connection connection;
	protected PreparedStatement preparedStatement;
	protected ResultSet resultSet;
	
	
	public DbConfiguration() {
		try {
		File f = new File("");
		String rootPathString = f.getAbsolutePath()+"\\src\\main\\resources\\db.properties";
		FileInputStream fin = new FileInputStream(rootPathString);
		Properties p = new Properties();
		p.load(fin);
		
		String userName = p.getProperty("username"); 
		String password = p.getProperty("password");
		String driver = p.getProperty("driver");
		String url = p.getProperty("url");
		//System.out.println(userName+" "+password+" "+driver+" "+url);
		
		Class.forName(driver);
		connection = DriverManager.getConnection(url,userName,password);
		if(connection != null) {
			System.out.println("Connection Created...!");
		}else {
			System.out.println("Connection not created...!");
		}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error is : "+e);
		}
		
	}
}

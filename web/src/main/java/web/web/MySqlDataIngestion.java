package web.web;

import java.sql.*;

public class MySqlDataIngestion {

	public void ingestData(WebDataStructure webData) throws SQLException {
	//create connection between java and mysql
	 String myDriver = "com.mysql.jdbc.Driver";//"sun.jdbc.odbc.JdbcOdbcDriver";
     String myUrl ="jdbc:mysql://localhost:3306/webapp"; // "jdbc:odbc:webapp";
   
     try {
		Class.forName(myDriver);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   
     
     
		Connection conn = DriverManager.getConnection(myUrl, "root", "root");
	
   
	//create query object
  // the mysql insert statement
     String query = " insert into webapp (url , encoding , title , "
     		+ "keywords , description , content , num_links , "
     		+ "num_images , num_stopWords , num_contentLength )"
     		+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

     // create the mysql insert preparedstatement
     PreparedStatement preparedStmt = conn.prepareStatement(query);
     
     preparedStmt.setString (1, webData.getUrl());
     preparedStmt.setString (2, webData.getEncoding());
     preparedStmt.setString (3, webData.getTitle());
     preparedStmt.setString (4, webData.getKeywords());
     preparedStmt.setString (5, webData.getDescription());
     preparedStmt.setString (6, webData.getContent());
     preparedStmt.setInt    (7, webData.getNum_links());
     preparedStmt.setInt    (8, webData.getNum_images());
     preparedStmt.setInt    (9, webData.getNum_stopWords());
     preparedStmt.setInt    (10, webData.getNum_contentLength());
     
	//push data to mysql
	preparedStmt.execute();
	//connection close
    conn.close();
     
	}
	
}

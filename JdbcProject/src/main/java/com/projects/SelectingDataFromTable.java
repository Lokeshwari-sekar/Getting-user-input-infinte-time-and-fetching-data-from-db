package com.projects;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectingDataFromTable {

	public static void main(String[] args) 
	{
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/edudb"; //edudb is the database name of mysql
		String un="root";
		String pass="root";
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,un,pass);
			st=conn.createStatement();
			
			String sql="select * from details";
			rs=st.executeQuery(sql);
			System.out.println("ID\tNAME\tEMAIL");
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String email=rs.getString(3);
				System.out.println(id+"\t"+name+"\t"+email);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		
		

	}

}

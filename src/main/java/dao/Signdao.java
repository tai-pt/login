package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import connect.ConnectDB;
import login.Sign;

public class Signdao {
	 Connection con = null;
	 PreparedStatement ps = null;
	 
	
	public Sign in(String name,String pass) throws ClassNotFoundException, SQLException {
		String sql ="INSERT INTO login" + "  (name, pass) VALUES "
				+ " (?, ?);";
		  		
		if (name == null || pass == null) {
			System.out.println("No Null name or pass");
			return null;
		}
		new ConnectDB();
		con = ConnectDB.getConnection();
		ps= con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, pass);
		int check = ps.executeUpdate();
		if(check >0){
			return new Sign(name, pass);
		}else {
			System.out.println("error");
		}
		
		
		return null;
}


	}


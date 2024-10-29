package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connect.ConnectDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import login.Login;

public class Logindao {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public Login check(String name, String pass) throws SQLException, ClassNotFoundException {
		
			String query = "select * from login where name = ? and pass = ? ";
			new ConnectDB();
			conn = ConnectDB.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next()) {
				Login a = new Login(rs.getString(1), rs.getString(2));
				return a;
			}
			return null;
	}
}


	
package control;

import java.io.IOException;

import dao.Logindao;
import dao.Signdao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import login.Login;
import login.Sign;

@WebServlet("/SignControl")
public class SignControl extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=UTF-8");
		try {
			String name = req.getParameter("name");
			String pass = req.getParameter("pass");
			Signdao sgindao = new Signdao();
			
			Sign a = sgindao.in(name, pass);
			if (a != null) {
				resp.sendRedirect("login.jsp");
			} else {
				resp.sendRedirect("signup.jsp");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
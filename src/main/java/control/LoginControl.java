package control;

import java.io.IOException;

import dao.Logindao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import login.Login;

@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=UTF-8");
		try {
			String name = req.getParameter("name");
			String pass = req.getParameter("pass");
			Logindao logindao = new Logindao();
			Login a = logindao.check(name, pass);
			if (a == null) {
				resp.sendRedirect("login.html");
			} else {
				resp.sendRedirect("index.html");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
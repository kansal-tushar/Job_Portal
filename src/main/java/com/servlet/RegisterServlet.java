package com.servlet;

import java.io.IOException;

import com.DB.DBConnect;
import com.dao.UserDAO;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/add_user")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			String name= req.getParameter("name");
			String qua=req.getParameter("qua");
			String email=req.getParameter("email");
			String ps=req.getParameter("ps");
			
			UserDAO dao=new UserDAO(DBConnect.getConn());
			
			User u= new User(name,email,ps,qua,"User");
			boolean f=dao.addUser(u);
			
			HttpSession session = req.getSession();
			if(f) {
				session.setAttribute("succMsg", "Registration Successfull");
				resp.sendRedirect("signup.jsp");
			}else {
				session.setAttribute("succMsg", "Something went wrong on server");
				resp.sendRedirect("signup.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	
}

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

@WebServlet("/update_profile")
public class UpdateUserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			
			int id=Integer.parseInt(req.getParameter("id"));
			String name=req.getParameter("name");
			String qua=req.getParameter("qua");
			String email=req.getParameter("email");
			String ps=req.getParameter("ps");
			
			UserDAO dao=new UserDAO(DBConnect.getConn());
			
			User u=new User();
			u.setId(id);
			u.setName(name);
			u.setQualfication(qua);
			u.setPassword(ps);
			u.setEmail(email);
			
			boolean f=dao.updateUser(u);
			HttpSession session=req.getSession();
			if(f) {
				session.setAttribute("succMsg", "Profile Updated Successfully");
				resp.sendRedirect("home.jsp");
			}else {
				session.setAttribute("succMsg", "Something went wrong on server");
				resp.sendRedirect("home.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
}

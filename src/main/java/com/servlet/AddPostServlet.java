package com.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.JobDAO;
import com.entity.Jobs;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/add_job")
public class AddPostServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String title=req.getParameter("title");
			String location=req.getParameter("location");
			String category=req.getParameter("category");
			String status=req.getParameter("status");
			String desc=req.getParameter("desc");
			
			Jobs j=new Jobs();
			j.setTitle(title);
			j.setDescription(desc);
			j.setLocation(location);
			j.setStatus(status);
			j.setCategory(category);
			
			HttpSession session = req.getSession();
			
			JobDAO dao=new JobDAO(DBConnect.getConn());
			boolean f=dao.addJobs(j);
			if(f)
			{
				session.setAttribute("succMsg", "Job Post Successfully....");
				resp.sendRedirect("add_job.jsp");
				
			}else {
				
				session.setAttribute("succMsg", "Something went wrong on server....");
				resp.sendRedirect("add_job.jsp");
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}

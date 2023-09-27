package com.servlet;

import java.io.IOException;

import com.DB.DBConnect;
import com.dao.JobDAO;
import com.entity.Jobs;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/update")
public class UpdateJobServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			int id=Integer.parseInt(req.getParameter("id"));
			String title=req.getParameter("title");
			String location=req.getParameter("location");
			String category=req.getParameter("category");
			String status=req.getParameter("status");
			String desc=req.getParameter("desc");
			
			Jobs j=new Jobs();
			j.setId(id);
			j.setTitle(title);
			j.setDescription(desc);
			j.setLocation(location);
			j.setCategory(category);
			j.setStatus(status);
			
            HttpSession session = req.getSession();
			
			JobDAO dao=new JobDAO(DBConnect.getConn());
			boolean f=dao.updateJob(j);
			if(f)
			{
				session.setAttribute("succMsg", "Job Update Successfully....");
				resp.sendRedirect("view_job.jsp");
				
			}else {
				
				session.setAttribute("succMsg", "Something went wrong on server....");
				resp.sendRedirect("view_job.jsp");
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
}

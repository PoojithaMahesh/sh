package sh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import sh.dao.StudentDao;
import sh.dto.Student;

public class SelectServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		StudentDao studentDao=new StudentDao();
		Student dbStudent=studentDao.findStudentById(id);
		if(dbStudent!=null) {
//			id is present
			PrintWriter printWriter=res.getWriter();
			printWriter.print(dbStudent);
		}else {
			PrintWriter printWriter=res.getWriter();
			printWriter.print("Sorry that id is not present");
		}
		
	}

}

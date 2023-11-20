package sh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import sh.dao.StudentDao;
import sh.dto.Student;

public class DeleteSrevlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    int id=Integer.parseInt( req.getParameter("id"));
    StudentDao dao=new StudentDao();
    Student student=dao.deleteStudent(id);
    if(student!=null) {
    	PrintWriter printWriter=res.getWriter();
    	printWriter.print("Deleted Successfully");
    }else {
    	PrintWriter printWriter=res.getWriter();
    	printWriter.print("Sorry id is not present");

    }
	}

}

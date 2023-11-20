package sh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import sh.dao.StudentDao;
import sh.dto.Student;

public class LoginServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	StudentDao studentDao=new StudentDao();
	List<Student> list=studentDao.getAllStudents();
	boolean value=false;
	String studentPassword=null;
	
	for(Student student:list) {
		if(email.equals(student.getEmail())) {
//			email is present
			studentPassword=student.getPassword();
			value=true;
			break;
		}
	}
	
	if(value==true) {
//		email is present
//		remaining task i need to check the password
		if(password.equals(studentPassword)) {
//			login success
			RequestDispatcher dispatcher=req.getRequestDispatcher("select.html");
			dispatcher.forward(req, res);
			
			
			
		}else {
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
			dispatcher.include(req, res);
		}
		
	}else {
//		email is not present
		RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
		dispatcher.include(req, res);
	}
	
	}

}

package sh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sh.dao.StudentDao;
import sh.dto.Student;

public class UpdateServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	String name=req.getParameter("name");
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	String address=req.getParameter("address");
	long phone=Long.parseLong(req.getParameter("phone"));
	
	Student student=new Student();
	student.setAddress(address);
	student.setEmail(email);
	student.setName(name);
	student.setPassword(password);
	student.setPhone(phone);
	
	
	StudentDao studentDao=new  StudentDao();
	Student dbStudent=studentDao.updateStudent(id,student);
	
	if(dbStudent!=null) {
		PrintWriter printWriter=resp.getWriter();
		printWriter.print("Yes data updated successfully");
	}else {
		PrintWriter printWriter=resp.getWriter();
		printWriter.print("Sprry id is not present");
	}
	
}
}

package com.test.servlet.studentOpera;

import com.test.controller.TestStudent;
import com.test.domain.Student;
import com.test.service.Impl.StudentServiceImpl;
import com.test.service.Impl.UserServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/a")
public class SelectStudent extends HttpServlet {
    private StudentServiceImpl studentService;
    private List<Student> students;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        studentService = (StudentServiceImpl) context.getBean("studentService");
        students = studentService.selectAllStudent();
        req.setAttribute("students",students);

        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            System.out.println(headerNames.nextElement());
        }


        req.getRequestDispatcher("/WEB-INF/views/student/student.jsp").forward(req,resp);
    }


    public void init() {

         }
}

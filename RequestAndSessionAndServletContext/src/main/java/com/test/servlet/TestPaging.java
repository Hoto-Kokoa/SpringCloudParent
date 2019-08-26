package com.test.servlet;

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
import java.util.List;

@WebServlet("/a")
public class TestPaging extends HttpServlet {
    private StudentServiceImpl studentService;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();


        //requst
        Integer a = (Integer) req.getAttribute("a");
        if (a == null)
        {
            req.setAttribute("a", 1);
        }
        else
        {
            req.setAttribute("a", a + 1);
        }
        a = (Integer) req.getAttribute("a");
        out.print("req:"+ a +"<br>");

//        resp.getWriter().write(studentService.selectAllStudent().toString());

        //session
        Integer b = (Integer) req.getSession().getAttribute("b");
        if (b == null)
        {
            req.getSession().setAttribute("b", 1);
        }
        else
        {
            req.getSession().setAttribute("b", b + 1);
        }
        b = (Integer) req.getSession().getAttribute("b");
        out.print("session:"+ b +"<br>");


        Integer c = (Integer) req.getServletContext().getAttribute("c");
        if (c == null)
        {
            req.getServletContext().setAttribute("c", 1);
        }
        else
        {
            req.getServletContext().setAttribute("c", c + 1);
        }
        c = (Integer) req.getServletContext().getAttribute("c");
        out.print("ServletContext:"+ c +"<br>");
    }


    public void init() {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        studentService = (StudentServiceImpl) context.getBean("studentService");

         }
}

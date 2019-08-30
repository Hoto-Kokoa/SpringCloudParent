package com.test.servlet.studentOpera;

import com.test.domain.Student;
import com.test.service.IStudentService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/insert")
public class InsertStudent extends HttpServlet {
    private IStudentService studentService;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");


        /*
        注意getattribute 与 getParameter的区别
        前者是获取req中附带的数据,后者是获取前台提交过来的数据
        * */
//        Enumeration<String> attributeNames = req.getParameterNames();
//        while (attributeNames.hasMoreElements()) {
//            String s = attributeNames.nextElement();
//            System.out.println(s);
//        }
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        studentService = (IStudentService) context.getBean("studentService");
        Student student = new Student();
        student.setName(req.getParameter("username"));
        student.setSex(req.getParameter("sex"));
        student.setAddress(req.getParameter("address"));
        student.setDepartment(req.getParameter("department"));
        Integer integer = studentService.insertStudnent(student);
        if (integer == 1) {
            req.setAttribute("msg", "插入完成");
        }
        req.getRequestDispatcher("/a").forward(req, resp);

    }
}

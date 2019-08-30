package com.test.servlet.studentOpera;

import com.test.domain.Student;
import com.test.service.IStudentService;
import com.test.service.Impl.StudentServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateStudent extends HttpServlet {
    private IStudentService studentService;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        //从Spring容器中获取studentService代理对象
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        studentService = (StudentServiceImpl) context.getBean("studentService");
        Integer id = Integer.valueOf(req.getParameter("id")) ;
        Student student = studentService.selectStudentById(id);
        req.setAttribute("username", student.getName());
        req.setAttribute("sex", student.getSex());
        req.setAttribute("address", student.getAddress());
        System.out.println(student);
        req.getRequestDispatcher("/updateStudent").forward(req,resp);
    }
}

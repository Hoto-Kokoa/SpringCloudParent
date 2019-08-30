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

@WebServlet("/update2")
public class UpdateStudentSubmit extends HttpServlet {
    private IStudentService studentService;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF -8");
        //从Spring容器中获取studentService代理对象
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        studentService = (StudentServiceImpl) context.getBean("studentService");
        Student student = new Student();
        student.setId(Integer.valueOf(req.getParameter("id")));
        student.setName(req.getParameter("username"));
        student.setSex(req.getParameter("sex"));
        student.setAddress(req.getParameter("address"));
        System.out.println(student);
        Integer integer = studentService.updateStudent(student);
        if (integer == 1) {
            req.setAttribute("msg", "修改完成");
        }
        req.getRequestDispatcher("/a").forward(req,resp);
    }
}

package com.test.servlet.studentOpera;

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

@WebServlet("/delete")
public class DeleteStudnet extends HttpServlet {
    private IStudentService studentService;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        studentService = (IStudentService) context.getBean("studentService");
        Integer id = Integer.valueOf(req.getParameter("id"));
        Integer integer = studentService.deleteStudent(id);
        System.out.println(id);
        if (integer == 1) {
            req.setAttribute("msg","删除完成");
        }
        req.getRequestDispatcher("/a").forward(req,resp);
    }

}

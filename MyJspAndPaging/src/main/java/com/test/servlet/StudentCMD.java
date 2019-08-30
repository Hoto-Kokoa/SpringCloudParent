package com.test.servlet;

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
import java.util.Enumeration;
import java.util.List;

@WebServlet("/cmd")
public class StudentCMD extends HttpServlet {
    private IStudentService studentService;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        studentService = (IStudentService) context.getBean("studentService");
        String cmd = req.getParameter("cmd");
        //如果cmd为空则令cmd=""
        cmd = cmd == null ? "" : cmd;
        System.out.println(cmd);
        if (cmd.equals("select") )
        {
            selectAllStudent(req,resp);
        } else if (cmd.equals("insert"))
        {
            insertStudent(req,resp);
        } else if (cmd.equals("delete"))
        {
            deleteStudent(req,resp);
        } else if (cmd.equals("update"))
        {
            updateStudent(req,resp);
        } else if (cmd.equals("updateSubmit"))
        {
            updateStudentSubmit(req,resp);
        } else
        {
            selectAllStudent(req,resp);
        }


    }

    public void selectAllStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = studentService.selectAllStudent();
        req.setAttribute("students",students);
        req.getRequestDispatcher("/WEB-INF/views/student/student.jsp").forward(req,resp);
    }

    public void insertStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {

        System.out.println("insert");
        Student student = new Student();
        student.setName(req.getParameter("username"));
        student.setSex(req.getParameter("sex"));
        student.setAddress(req.getParameter("address"));
        student.setDepartment(req.getParameter("department"));
        Integer integer = studentService.insertStudnent(student);
        if (integer == 1) {
            req.getSession().setAttribute("msg", "插入完成");
        }
        resp.sendRedirect("/cmd");

    }

    public void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        Integer id = Integer.valueOf(req.getParameter("id"));
        Integer integer = studentService.deleteStudent(id);
        System.out.println(id);
        if (integer == 1) {
            req.getSession().setAttribute("msg","删除完成");
        }
        resp.sendRedirect("/cmd");
    }

    public void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id")) ;
        Student student = studentService.selectStudentById(id);
        req.setAttribute("id", student.getId());
        req.setAttribute("username", student.getName());
        req.setAttribute("sex", student.getSex());
        req.setAttribute("address", student.getAddress());
        req.getRequestDispatcher("/updateStudent").forward(req,resp);
    }

    public void updateStudentSubmit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = new Student();
        student.setId(Integer.valueOf(req.getParameter("id")));
        student.setName(req.getParameter("username"));
        student.setSex(req.getParameter("sex"));
        student.setAddress(req.getParameter("address"));
        System.out.println(student);
        Integer integer = studentService.updateStudent(student);
        if (integer == 1) {
            req.getSession().setAttribute("msg", "修改完成");
        }
        resp.sendRedirect("/cmd");
    }
}

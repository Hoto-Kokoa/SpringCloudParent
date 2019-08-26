package com.test.servlet;

import com.test.domain.Users;
import com.test.service.Impl.UserServiceImpl;
import lombok.ToString;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
    private UserServiceImpl userService;

    @Override
    public void init()
    {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        userService = (UserServiceImpl) context.getBean("userService");
//        Users users = new Users();
//        users.setUsername("123");
//        users.setPassword("123");
//        System.out.println(userService.login(users));
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        String code = req.getParameter("code");
        HttpSession session = req.getSession();
        System.out.println(session.getId());
        String codeSession = (String) session.getAttribute("code");
        if (codeSession.equals(code)) {
            System.out.println("验证码正确");
        }
        else
        {
            System.out.println("验证码错误"+"code:"+code+"codeSession:"+codeSession);
            req.setAttribute("error","验证码不正确");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username+password+"");
        Users users = new Users();
        users.setUsername(username);
        users.setPassword(password);
        if (userService.login(users) != null)
        {
            System.out.println("登陆成功");
            PrintWriter writer = resp.getWriter();
            writer.write("登陆成功,欢迎用户:"+username);
        }
        else
        {
            System.out.println("账号或密码错误");
            req.setAttribute("error","账号或密码错误");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}

package com.test.cookieTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ab")
public class MyCookieTest extends HttpServlet {

    private boolean isFlag = false;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");


        Cookie[] cookies = req.getCookies();
        PrintWriter writer = resp.getWriter();

        if (cookies != null)
        {
            for (Cookie c : cookies) {
                if (c.getName().equals("username"))
                {
                    isFlag = true;
                    break;
                }
                else
                {
                    isFlag = false;
                }
                System.out.println("isFlag的值为" + isFlag);
                System.out.println(c.getName());
                System.out.println(c.getValue());
            }
        }

        if (isFlag)
        {
            System.out.println("已经存在cookie");
            writer.write("已经存在cookie");
        }
        else
        {
            System.out.println("不存在cookie,已经创建");
            Cookie username = new Cookie("username", "456789456489");
            username.setSecure(true);
            username.setMaxAge(5);
            resp.addCookie(username);
            writer.write("不存在cookie,已经创建");
        }

    }


}

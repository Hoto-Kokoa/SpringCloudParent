package com.test.cookieTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/ab")
public class MyCookieTest extends HttpServlet {

    private boolean isFlag = false;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
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
            Cookie[] cookies1 = req.getCookies();
            for (Cookie c: cookies1 )
            {
                if (c.getName().equals("date"))
                {
                    System.out.println("从cookie中读取到上次访问时间:"+c.getValue()+":"+c.getValue());
                    writer.write("上次访问时间:"+c.getValue());
                }

            }
            Date date = new Date();


            Cookie date1 = new Cookie("date", ft.format(date));

            resp.addCookie(date1);
            System.out.println("存在cookie,设置当前时间:"+ft.format(date));
        }
        else
        {
            System.out.println("不存在cookie,已经创建");
            Cookie username = new Cookie("username", "456789456489");
            Date date = new Date();
            Cookie date1 = new Cookie("date", ft.format(date));
            System.out.println("不存在cookie,设置当前时间:"+ft.format(date));
//            username.setSecure(true);
            username.setMaxAge(30);
            resp.addCookie(username);
//            resp.addCookie(date1);
            writer.write("不存在cookie,已经创建");
        }

    }


}

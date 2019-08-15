package com.test.servlet;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter out = resp.getWriter();

        ServletOutputStream os = resp.getOutputStream();

        FileInputStream is = new FileInputStream(new File(getServletContext().getRealPath("image"), "kokoa.jpg"));
        int index = -1;
        while ((index=is.read())!=-1)
        {
            os.write(index);
        }

    }
}

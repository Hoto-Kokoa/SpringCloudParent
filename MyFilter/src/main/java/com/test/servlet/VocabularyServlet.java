package com.test.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/v")
public class VocabularyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String vocabulary = (String) req.getParameter("vocabulary");
        System.out.println("VocabularyServlet:"+vocabulary);
        resp.getWriter().write(vocabulary);
    }
}

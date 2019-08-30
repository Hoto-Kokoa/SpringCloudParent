package com.test.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

@WebServlet("/validcode")
public class ValidCodeServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建一张图片
        BufferedImage image = new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);
        //画板
        Graphics2D gra = image.createGraphics();
        //画笔颜色和填充区域
        gra.setColor(Color.white);
        gra.fillRect(0, 0, 200 ,100);

        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 4; i++) {
            arrayList.add((int)(Math.random()*4));
        }

        Color[] colors = {Color.black, Color.cyan, Color.pink, Color.GREEN, Color.red, Color.orange, Color.blue};

        gra.setFont(new Font("微软雅黑",Font.BOLD,30 ));
        for (int i = 0; i <4; i++)
        {
            gra.setColor(colors[(int)(colors.length*Math.random())]);
            gra.drawString(arrayList.get(i).toString(),i*40, 40+(int)(Math.random() * 50));
        }
        for (int i = 0; i < 3; i++)
        {
            gra.setColor(colors[(int)(colors.length*Math.random())]);
            gra.drawLine((int)(Math.random()*200),(int)(Math.random()*100),(int)(Math.random()*200),(int)(Math.random()*100));
        }
        //返回流
        ServletOutputStream outputStream = resp.getOutputStream();
        //工具类
        ImageIO.write(image, "jpg", outputStream);

        HttpSession session = req.getSession();

        session.setAttribute("code", ""+arrayList.get(0)+arrayList.get(1)+arrayList.get(2)+arrayList.get(3));
    }
}

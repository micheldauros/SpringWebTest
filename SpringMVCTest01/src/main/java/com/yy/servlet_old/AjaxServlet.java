package com.yy.servlet_old;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet(name = "AjaxServlet", value = "/Ajax/AjaxServlet")
public class AjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String no=request.getParameter("no");
        String name=request.getParameter("name");
        PrintWriter printWriter=response.getWriter();
        printWriter.println("学号： "+no+" 姓名： "+name);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}

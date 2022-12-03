package com.zejing.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AppServlet extends HttpServlet {
    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UFT-8");
        String fname = req.getParameter("fname");
        String pricestr = req.getParameter("price");
        Integer price = Integer.parseInt(pricestr);
        String fcountstr = req.getParameter("fcount");
        Integer fcount = Integer.parseInt(fcountstr);
        String remark = req.getParameter("remark");
        super.doPost(req, resp);



    }
}

package com.hedgebenefits.web.controllers.admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminRegistrationController extends HttpServlet{

    @Override
     public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
        System.out.println("Test here");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
        requestDispatcher.forward(req, resp);
    }
}

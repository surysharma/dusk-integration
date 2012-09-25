package com.hedgebenefits.web.controllers.admin;

import com.hedgebenefits.domain.Admin;
import com.hedgebenefits.services.AdminService;
import com.hedgebenefits.util.BeanFactory;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.hedgebenefits.util.HibernateUtils.sessionFactory;

public class AdminRegistrationServlet extends HttpServlet{

    private AdminService adminService;

    @Override
    public void init() throws ServletException {
        adminService = BeanFactory.getAdminService();
    }

    @Override
     public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
        SessionFactory sf = sessionFactory;
        Session session = sf.getCurrentSession();
        session.beginTransaction();
        Admin admin = new Admin();
        admin.setUsername("Suresh");
        admin.setPassword("somepass");
        session.save(admin);
        session.getTransaction().commit();
        System.out.println("Session created:" + session);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/registration.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
     public void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
        System.out.println("Post here");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
        requestDispatcher.forward(req, resp);
    }
}

package com.hedgebenefits.web.controllers.admin;

import com.hedgebenefits.domain.Admin;
import com.hedgebenefits.domain.Receipt;
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
import java.util.Arrays;

import static com.hedgebenefits.util.HibernateUtils.sessionFactory;

public class AdminRegistrationServlet extends HttpServlet {


    private static final String SESSION_FACTORY = "sessionFactory";
    private AdminService adminService;

    @Override
    public void init() throws ServletException {
        getServletContext().setAttribute("adminService", adminService);
        getServletContext().setAttribute(SESSION_FACTORY, sessionFactory);
        adminService = BeanFactory.getAdminService();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Admin admin = new Admin();
        admin.setUsername("Suresh");
        admin.setPassword("somepass");
        Receipt receipt = new Receipt();
        receipt.setReceiptName("someReceiptName");
        receipt.setAdmin(admin);
        admin.setReceipts(Arrays.asList(receipt));
        session.save(admin);
        session.getTransaction().commit();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/registration.jsp");


        req.getSession().setAttribute("id", admin.getId());
        requestDispatcher.forward(req, resp);
    }

    private SessionFactory getSessionFactory() {
        return (SessionFactory) getServletContext().getAttribute(SESSION_FACTORY);  //To change body of created methods use File | Settings | File Templates.
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("Post here");
        SessionFactory sf = getSessionFactory();
        Session session = sf.getCurrentSession();
        session.beginTransaction();
        String id = req.getParameter("id");
        Admin admin = (Admin) session.get(Admin.class, Long.valueOf(id));

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
        req.getSession().setAttribute("admin", admin);
        session.getTransaction().commit();

        requestDispatcher.forward(req, resp);

    }
}

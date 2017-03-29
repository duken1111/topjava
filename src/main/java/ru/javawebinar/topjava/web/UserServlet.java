package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.service.UserService;
import ru.javawebinar.topjava.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;


/**
 * User: gkislin
 * Date: 19.08.2014
 */
public class UserServlet extends HttpServlet {
    private static final Logger LOG = getLogger(UserServlet.class);
    private UserService userService = new UserServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("redirect to users");

        request.setAttribute("users",userService.getAll());
        //response.sendRedirect("users.jsp");
        request.getRequestDispatcher("/users.jsp").forward(request, response);
    }
}

package com.zemian.hellojava.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A direct simple controller to forward URL to a view without providing any data model.
 * Note that we can map multiple simple URL path here for the entire application.
 */
@WebServlet({"/about", "/hello", "/error"})
public class ViewController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AppManager app = AppManager.getInstance();
        String viewName = app.getViewResolver().resolveViewName(req);
        req.getRequestDispatcher(viewName).forward(req, resp);
    }
}

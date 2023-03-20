package com.zemian.hellojava.web;

import org.slf4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * A direct simple controller to forward URL to a view without providing any data model.
 * Note that we can map multiple simple URL path here for the entire application.
 */
@WebServlet("/about")
public class ViewController extends HttpServlet {
    private static final Logger LOG = getLogger(ViewController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AppManager app = AppManager.getInstance();
        String contextPath = req.getContextPath();
        String name = req.getRequestURI();
        // Strip contextPath if found
        if (name.startsWith(contextPath)) {
            name = name.substring(contextPath.length());
        }
        String viewName = app.getViewResolver().resolveViewName(name);
        LOG.trace("Using viewName={}", viewName);
        req.getRequestDispatcher(viewName).forward(req, resp);
    }
}

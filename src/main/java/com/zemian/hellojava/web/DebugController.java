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
 * Just a sample of dummy Controller for debug code purpose.
 */
@WebServlet("/debug")
public class DebugController extends HttpServlet {
    private static final Logger LOG = getLogger(DebugController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AppManager app = AppManager.getInstance();
        String contextPath = req.getContextPath();
        String name = req.getRequestURI();
        LOG.debug("Using contextPath={}, name={}", contextPath, name);
        String viewName = app.getViewResolver().resolveViewName("debug");
        LOG.debug("Using viewName={}", name, viewName);
        req.getRequestDispatcher(viewName).forward(req, resp);
    }
}

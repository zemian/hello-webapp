package com.zemian.hellojava.web;

import org.slf4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.security.CodeSource;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Just a sample of dummy Controller for debug code purpose.
 */
@WebServlet("/class-finder")
public class ClassFinderController extends HttpServlet {
    private static final Logger LOG = getLogger(ClassFinderController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cn = req.getParameter("cn");
        if (cn != null && !cn.equals("")) {
            try {
                Class<?> cls = this.getClass().getClassLoader().loadClass(cn);
                CodeSource codeSource = cls.getProtectionDomain().getCodeSource();
                URL loc = codeSource.getLocation();
                req.setAttribute("cls", cls);
                req.setAttribute("loc", loc);
                LOG.info("Found class: {}, location={}", cls, loc);
            } catch (ClassNotFoundException e) {
                LOG.error("ClassNotFoundException: " + cn);
                req.setAttribute("error", true);
            }
        }

        AppManager app = AppManager.getInstance();
        String viewName = app.getViewResolver().resolveViewName(req);
        LOG.trace("Using viewName={}", viewName);
        req.getRequestDispatcher(viewName).forward(req, resp);
    }
}

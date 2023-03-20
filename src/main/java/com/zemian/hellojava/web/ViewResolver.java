package com.zemian.hellojava.web;

import org.slf4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Given a HttpServletRequest, extract the request URI name and use it to
 * resolve the file location of a view file.
 */
public class ViewResolver {
    private static final Logger LOG = getLogger(ViewResolver.class);
    private String viewNamePrefix = "/WEB-INF/jsp";
    private String viewNameSuffix = ".jsp";

    public String resolveViewName(HttpServletRequest req) {
        String contextPath = req.getContextPath();
        String name = req.getRequestURI();
        // Strip contextPath if found
        if (name.startsWith(contextPath)) {
            name = name.substring(contextPath.length());
        }
        if (name.equals("") || name.equals("/")) {
            name = "/index";
        } else if (!name.startsWith("/")) {
            name = "/" + name;
        }

        String view = viewNamePrefix + name + viewNameSuffix;
        LOG.debug("Resolving name={} to view={}", name, view);
        return view;
    }
}

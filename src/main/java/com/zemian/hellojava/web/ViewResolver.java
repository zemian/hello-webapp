package com.zemian.hellojava.web;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Given a simple name and resolve the file location of a view file.
 */
public class ViewResolver {
    private static final Logger LOG = getLogger(ViewResolver.class);
    private String viewNamePrefix = "/WEB-INF/jsp";
    private String viewNameSuffix = ".jsp";

    public String resolveViewName(String name) {
        if (!name.startsWith("/")) {
            name = "/" + name;
        }
        String view = viewNamePrefix + name + viewNameSuffix;
        LOG.debug("Resolving name={} to view={}", name, view);
        return view;
    }
}

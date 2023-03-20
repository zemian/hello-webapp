<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/jsp/includes/html-head.jsp"%>
<%@include file="/WEB-INF/jsp/includes/header.jsp"%>

<div class="section">
    <div class="container">
        <h1 class="title">Use cn query parameter</h1>
        <p class="subtitle">Example: <code>?cn=com.zemian.hellojava.web.AppStartup</code></p>

        <h1 class="title">Result:</h1>
        <p>Class: <code>${cls}</code></p>
        <p>Location: <code>${loc}</code></p>
    </div>
    <%@include file="/WEB-INF/jsp/includes/footer.jsp"%>
</div>

<%@include file="/WEB-INF/jsp/includes/html-tail.jsp"%>
</html>
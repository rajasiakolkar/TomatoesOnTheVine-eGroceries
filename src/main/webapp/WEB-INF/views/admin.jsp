<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/common/header.jsp" %>

<div class="container-wrapper">
<div class="container">
<div class="page-header">
	
	<h1>Administrator</h1>
</div>

<c:if test="${pageContext.request.userPrincipal.name != null }">
<h3>Welcome, ${pageContext.request.userPrincipal.name} | <a href="<c:url value="j_spring_security_logout" />">Logout</a></h3>
</c:if>


<h3><a href="<c:url value="/admin/inventory" />" class="btn btn-default">Inventory</a></h3>

<p class="lead"> Update Inventory! </p>
</div>
</div>

<%@include file="/WEB-INF/views/common/footer.jsp" %>
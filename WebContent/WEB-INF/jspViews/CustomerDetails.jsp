<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Page</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<body>
	<center>
		<h2>Customer Details Within The Date Range</h2>
		<form:form method="GET" modelAttribute="dateBean"
			action="${pageContext.request.contextPath}/getCustomerRec.html">
			<table border="2">
				<tr>
					<th>From Date:</th>
					<td><form:input path="fromDate" /></td>
					<th>To Date:</th>
					<td><form:input path="toDate" /></td>
				</tr>
			</table>
			<br>
			<input type="submit" value="Fetch details">
		</form:form>
		<br> <br>
		<a href="${pageContext.request.contextPath}/index.jsp">Home</a>
		<hr>
		<br>


		<form:form>
			<c:if test="${not empty custList}">
				<table border="2">
					<tr>
						<th>CustomerId</th>
						<th>CustomerName</th>
						<th>Bill</th>
						<th>Billing Date</th>
					</tr>
					<c:forEach var="var" items="${custList}">
						<tr>
							<th>${var.customerId}</th>
							<th>${var.customerName}</th>
							<th>${var.bill}</th>
							<th><fmt:formatDate value="${var.getBillingDate()}" pattern="dd/MMM/yyyy"/></th>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			<c:if test="${empty custList}">
				<h4>${message}</h4>
			</c:if>
		</form:form>
	</center>
</body>
</html>
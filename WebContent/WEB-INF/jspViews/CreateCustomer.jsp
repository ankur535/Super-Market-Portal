<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		<h2>Add Customer Details</h2>
		<form:form method="GET" modelAttribute="custObj" action="${pageContext.request.contextPath}/saveCustomer.html">
			<table border="2">
				<tr>
					<th>Customer Name</th>
					<td><form:input path="customerName"/></td>
				</tr>
				<tr>
					<th>Customer Type</th>
					<td>
						<form:radiobutton path="customerType" value="G" label="Gold"/>
						<form:radiobutton path="customerType" value="P" label="Platinum"/>
						<form:radiobutton path="customerType" value="S" label="Silver"/>
					</td>
				</tr>
				<tr>
					<th>Bill Amount</th>
					<td><form:input path="bill"/></td>
				</tr>
				<tr>
					<th>Billing Date [dd-MMM-yyyy]</th>
					<td><form:input path="billingDate" /></td>
				</tr>
				
			</table>
			<br>
				<input type="submit" value="Register">
		</form:form>
		<br><br>
		<a href="${pageContext.request.contextPath}/index.jsp">Home</a>
	</center>
</body>
</html>
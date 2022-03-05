<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<sql:query dataSource="jdbc/xe" var="result">
select p.prod_name,p.prod_img,i.prod_rate,i.prod_avail_qty from product p join product_inventory i on p.prod_id=i.prod_id
</sql:query>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
<c:forEach var="row" items="${result.rows}">
<tr>
<td><c:out value="${row.prod_name}"/>
</td>

<td>
<img  src="${pagecontext.servletContext.contextPath }/photoServlet?id=${row.prod_id}"/>
</td>
<td>
<c:out value="${row.prod_rate }"></c:out>
</td>
<td>
<c:out value="${row.prod_avail_qty }"></c:out>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>
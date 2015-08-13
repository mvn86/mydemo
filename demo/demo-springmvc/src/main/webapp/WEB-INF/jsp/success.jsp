<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>hello controller</title>
</head>
<html>
<body>
<h2 style="color: red;">~SUCCESSFUL~</h2>
	<table width="439" height="292" border="0" cellpadding="1"
		cellspacing="1">
		<tr>
			<td>username</td>
			<td><input name="username" type="text" value="${username }" /></td>
		</tr>
		<tr>
			<td>password</td>
			<td><input name="password" type="password" value="${password }" /></td>
		</tr>
		<tr>
			<td>sex</td>
			<td><c:if test="${radiosex eq 1 }">
			男<input name="radiosex" type="radio" checked="checked" />
				女 <input name="radiosex" type="radio" value="2" />
				</c:if> <c:if test="${radiosex eq 2 }">
			男<input name="radiosex" type="radio" value="1" /> 
			女 <input name="radiosex" type="radio" checked="checked" />
				</c:if></td>
		</tr>
		<tr>
			<td>爱好</td>
			<td>
				<c:forEach items="${checkbox }" var="item">
					<c:out value="${item }"></c:out>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td>select</td>
			<td>${select }</td>
		</tr>
		<tr>
			<td>备注</td>
			<td><textarea name="textarea">${textarea }</textarea></td>
		</tr>
	</table>
</body>
</html>
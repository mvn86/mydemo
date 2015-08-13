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

	<h2>${message}</h2>
	<form action="post.html" method="post">

		<table width="439" height="292" border="0" cellpadding="1"
			cellspacing="1">
			<tr>
				<td>username</td>
				<td><input name="username" type="text" /></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input name="password" type="password" /></td>
			</tr>
			<tr>
				<td>sex</td>
				<td>
				男<input name="radiosex" type="radio" value="1" /> 
				女 <input name="radiosex" type="radio" value="2" />
					</td>
			</tr>
			<tr>
				<td>爱好</td>
				<td>游泳<input name="checkbox" type="checkbox" value="Swimming" />唱歌<input
					name="checkbox" type="checkbox" value="Sing" />跳舞<input
					name="checkbox" type="checkbox" value="Dance" /></td>
			</tr>
			<tr>
				<td>select</td>
				<td><select name="select">
						<option value="">-请选择-</option>
						<option value="bj">北京</option>
						<option value="sh">上海</option>
						<option value="nj">南京</option>
						<option value="xa">西安</option>
				</select></td>
			</tr>
			<tr>
				<td>备注</td>
				<td><textarea name="textarea"></textarea></td>
			</tr>
			<tr>
				<td align="center" valign="middle"><input name="" type="reset"
					value="reset" /></td>
				<td align="center" valign="middle"><input name="" type="submit"
					value="submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
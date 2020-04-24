<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><s:text name="hello.world"/></title>
</head>
<body>
	<h2>
		<s:property value="message" />
	</h2>

	<h3><s:text name="hello.languages"/></h3>
	<ul>
		<li><s:url var="url" action="Welcome">
				<s:param name="request_locale">en</s:param>
			</s:url> <s:a href="%{url}"><s:text name="welcome.english"/></s:a></li>
		<li><s:url var="url" action="Welcome">
				<s:param name="request_locale">es</s:param>
			</s:url> <s:a href="%{url}"><s:text name="welcome.espanol"/></s:a></li>
	</ul>
</body>
</html>
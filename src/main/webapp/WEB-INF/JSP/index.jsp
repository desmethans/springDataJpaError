<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="nl">
<head>
<title>Add person</title>
</head>
<body>
<form:form action="" method="post" commandName="person">
<form:label path="name">Name:</form:label>
<form:input path="name" autofocus="true"/>
<input type="submit">
</form:form>
</body>
</html>

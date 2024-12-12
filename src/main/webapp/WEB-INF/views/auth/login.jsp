<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login</h2>
<form method="post" action="${pageContext.request.contextPath}/auth/perform_login">
    <label>Email: <input type="text" name="email" /></label><br/>
    <label>Password: <input type="password" name="password" /></label><br/>
    <button type="submit">Login</button>
</form>
<p><a href="${pageContext.request.contextPath}/auth/register">Don't have an account? Register</a></p>
<p th:if="${error}" th:text="${error}" style="color:red;"></p>
<%--<p th:if="${param.logout}">You have been logged out.</p>--%>
</body>
</html>

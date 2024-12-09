<%--
  Created by IntelliJ IDEA.
  User: safiy
  Date: 10/22/2024
  Time: 2:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/login" method="post">
    <input type="text" name="username" placeholder="Email" required />
    <input type="password" name="password" placeholder="Password" required />
    <button type="submit">Login</button>
  </form>
  </body>
</html>

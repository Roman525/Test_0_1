<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 09.05.2018
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List users</title>
</head>
<body>
<div>
    <h1>List of users</h1>
</div>

<div>
    <div>
        <%
            List<String> names = (List<String>) request.getAttribute("userNames");

            if (names != null && !names.isEmpty()) {
                out.println("<ui>");
                for (String s : names) {
                    out.println("<li>" + s + "</li>");
                }
                out.println("</ui>");
            } else out.println("<p>No registered users!</p>");
        %>
    </div>
</div>

<div>
    <button onclick="location.href='/'">Exit</button>
</div>
</body>
</html>

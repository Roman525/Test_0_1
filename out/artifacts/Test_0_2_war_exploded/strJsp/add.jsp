<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 09.05.2018
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New user</title>
</head>
<body>
<div>
    <h1>Create a Name and Password</h1>
</div>

<div>
    <%
        if (request.getAttribute("userName") != null) {
            out.println("<p>User '" + request.getAttribute("userName") + "' added!</p>");
        }
    %>
    <div>
        <form method="post">
            <label>Name:
                <input type="text" name="name"><br />
            </label>
            <label>Password:
                <input type="password" name="pass"><br />
            </label>
            <button type="submit">Save</button>
        </form>
    </div>
</div>

<div>
    <button onclick="location.href='/'">Exit</button>
</div>
</body>
</html>


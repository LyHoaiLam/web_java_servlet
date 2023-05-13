<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Handle Login_02.jsp</title>
</head>
<body>
    <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");
    %>

    <%  
        if(username.equalsIgnoreCase("hoailam03999") && password.equals("0362685068SonyXperia"))
        {
    %>

    <h2>successful login</h2>

    <%
        } else {
    %>
    <h2>Account not found</h2>
    <%
        }
    %>
</body>
</html>
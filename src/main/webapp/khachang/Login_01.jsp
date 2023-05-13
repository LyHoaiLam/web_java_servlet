
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

    <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
    %>
    <h1>Ban Da Dang Nhap Thanh Cong</h1>
    <p>Username: <b> <%= username %></b></p> 
    <p>Password: <b> <%= password %></b></p>
</body>
</html>
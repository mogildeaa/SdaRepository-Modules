

<html>

<head>
</head>

<body>
User name is: <%= request.getParameter("username")%>
<br>
The password is: <%= request.getParameter("password")%>
<br>

<%
    String[] car = request.getParameterValues("cars");
    for (String s : car){
        out.println(" ");
        out.println(s);
        out.println(" ");
    }
%>

</body>
</html>
<%@page import="io.github.kanedafromparis.ose.fakedatagen.FakeDataGenerator" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Fake Data Generator</title>
</head>
<body>
<p><%
    //generateFakeData(String dir, Integer deep, Boolean saveToDtb, Boolean saveToFile)
    out.println(new FakeDataGenerator().generateFakeData());
    
%>
</p>
</body>
</html>
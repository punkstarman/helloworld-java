<%@page language="java" contentType="text/html; charset=UTF-8" %>
<%@page import="net.namrats.helloworld.Greeter"%>

<%
String greeting = new Greeter().greet(request.getParameter("name"));
%>
<!DOCTYPE html>

<html>
  <head>
    <title><%= greeting %></title>
  </head>
  <body>
    <h1><%= greeting %></h1>
  </body>
</html>

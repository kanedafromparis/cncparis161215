<%@page import="java.util.Iterator"%>
<%@page import="io.github.kanedafromparis.ose.fakedatagen.FDGCompany"%>
<%@page import="io.github.kanedafromparis.ose.fakedatagen.FDGPersonne"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="io.github.kanedafromparis.ose.fakedatagen.FakeDataGenerator" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
        <title>Fake Data Generator
        </title>
        <meta http-equiv="refresh" content="10" >

    </head>

    <body>
        <p>    <%
            Date dNow = new Date();
            SimpleDateFormat ft
                    = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

            out.println("Current Date: " + ft.format(dNow));

            %>
        <table>
            <tr>
                <td valign="top" ><img src="images/logo_cncf_0002.png" /></td>
                <td valign="top"><p><img src="images/buffer-loading.gif" />
                    <a href="api/data/v1" target="_blank">Get to the Json Api<a></p>
                                </td>
                                    </tr>
                                    </table>
                                    </p>
                                    </body>
                                    </html>

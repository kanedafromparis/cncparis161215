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
        <meta http-equiv="refresh" content="5" >

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
                <td valign="top" ><img src="images/logo_cncf_0003.png" /></td>
                <td><p><a href="api/data/v1" target="_blank">Get to the Json Api<a></p>
                                <p> 
                                    <%    List<FDGCompany> compLst = new FakeDataGenerator().generateFakeData();
                                        //generateFakeData(String dir, Integer deep, Boolean saveToDtb, Boolean saveToFile)
                                        //out.println(new FakeDataGenerator().generateFakeData());
                                        Iterator<FDGCompany> iterator = compLst.iterator();
                                        while (iterator.hasNext()) {
                                            FDGCompany next = iterator.next();

                                            out.println("<b>" + next.getName() + "</b><br/>");
                                            out.println("<i>" + next.getNote() + "</i><br/>");
                                            out.println("<ul>");
                                            
                                            Iterator<FDGPersonne> iterator1 = next.getFKPersonneLst().iterator();
                                            while (iterator1.hasNext()) {
                                                FDGPersonne person = iterator1.next();
                                                out.println("<li>" + person.getFirstname() + " " + person.getLastname() + "</li>");

                                            }
                                            out.println("</ul>");

                                        }
                                    %>
                                <c:
                                    </p></td>
                                    </tr>
                                    </table>
                                    </p>
                                    </body>
                                    </html>

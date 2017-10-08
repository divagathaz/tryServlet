<%-- 
    Document   : Tabel
    Created on : Oct 8, 2017, 4:15:50 PM
    Author     : Divaagathaz
--%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <table border=1>
        <thead>
            <tr>
                <th>ID Jurusan</th>
                <th>Nama</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listJurusan}" var="mhs">
                <tr>
                    <td><c:out value="${mhs.idJurusan}" /></td>
                    <td><c:out value="${mhs.namaJurusan}" /></td>
                    <td><a href="JurusanServlet?action=edit&idJurusan=<c:out value="${mhs.idJurusan}"/>">Update</a></td>
                    <td><a href="JurusanServlet?action=delete&idJurusan=<c:out value="${mhs.idJurusan}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
        <select>
            <c:forEach items="${listJurusan}" var="mhs">
               <option><c:out value="${mhs.namaJurusan}" /></option>         
            </c:forEach>
        </select>
         
     <p><a href="index.jsp">Kembali</a> | <a href="FormJurusan.jsp?action=create">Tambahkan jurusan</a><br/>
    </body>
</html>

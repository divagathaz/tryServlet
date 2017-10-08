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
        <title>Tabel Mahasiswa</title>
    </head>
    <body>
        <h1>Tabel Mahasiswa</h1>
    <table border=1>
        <thead>
            <tr>
                <th>ID Mahasiswa</th>
                <th>Nama</th>
                <th>Alamat</th>
                <th>Jurusan</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listMahasiswa}" var="mhs">
                <tr>
                    <td><c:out value="${mhs.idMahasiswa}" /></td>
                    <td><c:out value="${mhs.namaMahasiswa}" /></td>
                    <td><c:out value="${mhs.alamat}" /></td>
                    <td><c:out value="${mhs.namaJurusan}" /></td>
                    <td><a href="MahasiswaServlet?action=edit&idMahasiswa=<c:out value="${mhs.idMahasiswa}"/>">Update</a></td>
                    <td><a href="MahasiswaServlet?action=delete&idMahasiswa=<c:out value="${mhs.idMahasiswa}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
        <p><a href="index.jsp">Kembali</a> | <a href="MahasiswaServlet?action=create&idMahasiswa=">Tambah data mahasiswa</a><br/></p>
    </body>
</html>

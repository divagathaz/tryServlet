<%-- 
    Document   : Form
    Created on : Oct 8, 2017, 6:11:07 PM
    Author     : Divaagathaz
--%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
        
        <c:choose>
			<c:when test="${action == 'edit'}">
				<h2>Update Contact Information</h2>
				<form method="POST" action='MahasiswaServlet' class="form-inline">
                                    ID Mahasiswa : 
                                    <c:out value="${mahasiswa.idMahasiswa}"/>
						<input type="hidden" name="idMahasiswa" value="${mahasiswa.idMahasiswa}">
						<div class="form-group">
							<label for="poductname">Name:</label> <input type="name"
								class="form-control" id="name" name="namaMahasiswa"
								value="${mahasiswa.namaMahasiswa}">
						</div>
						<div class="form-group">
							<label for="address">Address:</label> <input type="address"
								class="form-control" id="address" name="alamat"
								value="${mahasiswa.alamat}">
						</div>
						<div class="form-group">
						<label for="jurusan">Jurusan:</label> 
                                                <select name="namaJurusan">
                                                    <c:forEach items="${listJurusan}" var="mhs">
                                                        <option value="${mhs.idJurusan}" ${mhs.namaJurusan == selectedJurusan ?  'selected="selected"' : ''}><c:out value="${mhs.namaJurusan}" /></option>         
                                                    </c:forEach>
                                                </select>
					</div>
						<button type="submit" class="btn btn-default" value="Update">Update</button><a href="MahasiswaServlet">Kembali</a> 
					
				</form>

			</c:when>
			<c:otherwise>
				<h2>Mahasiswa Baru</h2>
				<form method="POST" action='MahasiswaServlet' class="form-inline">
					<input type="hidden" name="idMahasiswa" value="">
					<div class="form-group">
						<label for="namaMahasiswa">Nama:</label> <input type=text"
							class="form-control"  name="namaMahasiswa"
							placeholder="Masukkan nama">
					</div>
					<div class="form-group">
						<label for="alamat">Alamat:</label> <input type="text"
							class="form-control" id="alamat" name="alamat"
							placeholder="Masukkan alamat">
					</div>
                                        <div class="form-group">
						<label for="jurusan">Jurusan:</label> 
                                                <select name="namaJurusan">
                                                    <c:forEach items="${listJurusan}" var="mhs">
                                                        <option value="${mhs.idJurusan}"><c:out value="${mhs.namaJurusan}" /></option>         
                                                    </c:forEach>
                                                </select>
					</div>
                                                
					<button type="submit" class="btn btn-default">Submit</button><a href="MahasiswaServlet">Kembali</a> 
				</form>
			</c:otherwise>
		</c:choose>
    </body>
    
</html>

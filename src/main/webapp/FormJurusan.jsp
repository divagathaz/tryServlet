<%-- 
    Document   : Form Jurusan
    Created on : Oct 8, 2017, 6:11:07 PM
    Author     : Divaagathaz
--%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form Jurusan</title>
    </head>
    <body>
       
        
        <c:choose>
			<c:when test="${action == 'edit'}">
				<h2>Update Contact Information</h2>
				<form method="POST" action='JurusanServlet' class="form-inline">
                                    ID Jurusan : 
                                    <c:out value="${jurusan.idJurusan}"/>
						<input type="hidden" name="idJurusan" value="${jurusan.idJurusan}">
						<div class="form-group">
							<label for="poductname">Name:</label> <input type="name"
								class="form-control" id="name" name="namaJurusan"
								value="${jurusan.namaJurusan}">
						</div>
						
						<button type="submit" class="btn btn-default" value="Update">Update</button>
					
				</form>

			</c:when>
			<c:otherwise>
				<h2>Jurusan Baru</h2>
				<form method="POST" action='JurusanServlet' class="form-inline">
					<input type="hidden" name="idJurusan" value="">
					<div class="form-group">
						<label for="namaJurusan">Nama Jurusan Baru:</label> <input type=text"
							class="form-control"  name="namaJurusan"
							placeholder="Masukkan nama jurusan">
                                                <button type="submit" class="btn btn-default">Submit</button>
					</div>
                                        <br/>
					 <a href="JurusanServlet">Kembali</a> 
				</form>
			</c:otherwise>
		</c:choose>
    </body>
    
</html>

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mgs.bismillah01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Divaagathaz
 */
public class MahasiswaService {
    private Connection connection;

	public MahasiswaService() {
		connection = DbUtil.getConnection();
	}

	public void addMahasiswa(Mahasiswa mahasiswa) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into mahasiswa values (0, ?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, mahasiswa.getNamaMahasiswa());
			preparedStatement.setString(2, mahasiswa.getAlamat());
                        preparedStatement.setString(3, mahasiswa.getNamaJurusan());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteMahasiswa(int mahasiswaId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from mahasiswa where idMahasiswa=?");
			// Parameters start with 1
			preparedStatement.setInt(1, mahasiswaId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateMahasiswa(Mahasiswa mahasiswa, String idMahasiswa) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update mahasiswa set namaMahasiswa=?, alamat=?, idJurusan=?" +
							"where idMahasiswa=?");
			// Parameters start with 1
			preparedStatement.setString(1, mahasiswa.getNamaMahasiswa());
			preparedStatement.setString(2, mahasiswa.getAlamat());
                        preparedStatement.setString(3, mahasiswa.getNamaJurusan());
			preparedStatement.setString(4, idMahasiswa);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Mahasiswa> getAllMahasiswas() {
		List<Mahasiswa> mahasiswas = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select mahasiswa.idMahasiswa, mahasiswa.namaMahasiswa, mahasiswa.alamat, jurusan.namaJurusan from mahasiswa join jurusan on mahasiswa.idJurusan = jurusan.idJurusan");
			while (rs.next()) {
				Mahasiswa mahasiswa = new Mahasiswa();
				mahasiswa.setIdMahasiswa(rs.getInt("idMahasiswa"));
				mahasiswa.setNamaMahasiswa(rs.getString("namaMahasiswa"));
				mahasiswa.setAlamat(rs.getString("alamat"));
                                mahasiswa.setNamaJurusan(rs.getString("namaJurusan"));
				mahasiswas.add(mahasiswa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mahasiswas;
	}
	
	public Mahasiswa getMahasiswaById(int mahasiswaId) {
		Mahasiswa mahasiswa = new Mahasiswa();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from mahasiswa where idMahasiswa=?");
			preparedStatement.setInt(1, mahasiswaId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				mahasiswa.setIdMahasiswa(rs.getInt("idMahasiswa"));
				mahasiswa.setNamaMahasiswa(rs.getString("namaMahasiswa"));
				mahasiswa.setAlamat(rs.getString("alamat"));
                                mahasiswa.setNamaJurusan(rs.getString("namaJurusan"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mahasiswa;
	}
}

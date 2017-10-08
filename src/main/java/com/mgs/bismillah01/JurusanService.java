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
public class JurusanService {
    private Connection connection;

	public JurusanService() {
		connection = DbUtil.getConnection();
	}

	public void addJurusan(Jurusan jurusan) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into jurusan values (0, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, jurusan.getNamaJurusan());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteJurusan(int jurusanId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from jurusan where idJurusan=?");
			// Parameters start with 1
			preparedStatement.setInt(1, jurusanId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateJurusan(Jurusan jurusan, String idJurusan) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update jurusan set namaJurusan=? " +
							"where idJurusan=?");
			// Parameters start with 1
			preparedStatement.setString(1, jurusan.getNamaJurusan());
			preparedStatement.setString(2, idJurusan);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Jurusan> getAllJurusans() {
		List<Jurusan> jurusans = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from jurusan");
			while (rs.next()) {
				Jurusan jurusan = new Jurusan();
				jurusan.setIdJurusan(rs.getInt("idJurusan"));
				jurusan.setNamaJurusan(rs.getString("namaJurusan"));
				jurusans.add(jurusan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return jurusans;
	}
	
	public Jurusan getJurusanById(int jurusanId) {
		Jurusan jurusan = new Jurusan();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from jurusan where idJurusan=?");
			preparedStatement.setInt(1, jurusanId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				jurusan.setIdJurusan(rs.getInt("idJurusan"));
				jurusan.setNamaJurusan(rs.getString("namaJurusan"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return jurusan;
	}
}

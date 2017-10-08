/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mgs.bismillah01;

/**
 *
 * @author Divaagathaz
 */
public class Mahasiswa {
    private int idMahasiswa;
    private String namaJurusan;
    private String namaMahasiswa;
    private String alamat;

    public int getIdMahasiswa() {
        return idMahasiswa;
    }

    public void setIdMahasiswa(int idMahasiswa) {
        this.idMahasiswa = idMahasiswa;
    }

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public void setNamaMahasiswa(String namaMahasiswa) {
        this.namaMahasiswa = namaMahasiswa;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    @Override
	public String toString() {
		return "Mahasiswa [idMahasiswa=" + idMahasiswa + ", namaMahasiswa=" + namaMahasiswa
				+ ", alamat=" + alamat + ", namaJurusan=" +namaJurusan+" ]";
	}

    /**
     * @return the namaJurusan
     */
    public String getNamaJurusan() {
        return namaJurusan;
    }

    /**
     * @param namaJurusan the namaJurusan to set
     */
    public void setNamaJurusan(String namaJurusan) {
        this.namaJurusan = namaJurusan;
    }
}


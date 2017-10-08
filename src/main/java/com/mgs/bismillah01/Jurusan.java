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
public class Jurusan {
    private int idJurusan;
    private String namaJurusan;

    /**
     * @return the idJurusan
     */
    public int getIdJurusan() {
        return idJurusan;
    }

    /**
     * @param idJurusan the idJurusan to set
     */
    public void setIdJurusan(int idJurusan) {
        this.idJurusan = idJurusan;
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
    @Override
	public String toString() {
		return "Jurusan [idJurusan=" + idJurusan + ", namaJurusan=" + namaJurusan
				+ "]";
    }
}

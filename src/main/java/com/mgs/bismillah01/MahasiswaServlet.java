/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mgs.bismillah01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Divaagathaz
 */
@WebServlet(name = "MahasiswaServlet", urlPatterns = {"/MahasiswaServlet"})
public class MahasiswaServlet extends HttpServlet {

    static MahasiswaService ms = new MahasiswaService();
    static JurusanService js = new JurusanService();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
           response.sendRedirect("TabelMahasiswa.jsp");  
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String idMahasiswa = new String();
        String action= new String();
        String namaMahasiswa = new String();
        String alamat = new String();
        try{
            action = request.getParameter("action").toString();
            idMahasiswa = request.getParameter("idMahasiswa");
             namaMahasiswa = request.getParameter("namaMahasiswa");
            alamat = request.getParameter("alamat");
        }catch(NullPointerException e){
            
        }
        if(!idMahasiswa.isEmpty()){
           Mahasiswa mhs = new Mahasiswa();
           mhs.setNamaMahasiswa(namaMahasiswa);
           mhs.setAlamat(alamat);
           ms.updateMahasiswa(mhs, idMahasiswa);
       }
        if(action.equals("")){
            request.setAttribute("listMahasiswa", ms.getAllMahasiswas());
        request.getRequestDispatcher("TabelMahasiswa.jsp").forward(request, response);
        }
        if(action.equals("delete")){
            request.setAttribute("action", action);
            ms.deleteMahasiswa(Integer.parseInt(idMahasiswa));
            request.setAttribute("listMahasiswa", ms.getAllMahasiswas());
        request.getRequestDispatcher("TabelMahasiswa.jsp").forward(request, response);
        }
        if(action.equals("edit"))
        {
            request.setAttribute("action", action);
            request.setAttribute("mahasiswa", ms.getMahasiswaById(Integer.parseInt(idMahasiswa)));
            request.setAttribute("listJurusan", js.getAllJurusans());
            request.setAttribute("selectedJurusan", ms.getMahasiswaById(Integer.parseInt(idMahasiswa)).getNamaJurusan());
        request.getRequestDispatcher("FormMahasiswa.jsp").forward(request, response);
        }
        if(action.equals("create"))
        {
            request.setAttribute("action", action);
            request.setAttribute("listJurusan", js.getAllJurusans());
            request.getRequestDispatcher("FormMahasiswa.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("listMahasiswa", ms.getAllMahasiswas());
        request.getRequestDispatcher("TabelMahasiswa.jsp").forward(request, response);
        }
        request.getRequestDispatcher("FormMahasiswa.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
         String idMahasiswa ="",namaMahasiswa,alamat, namaJurusan;
        idMahasiswa = request.getParameter("idMahasiswa");
        namaMahasiswa = request.getParameter("namaMahasiswa");
        alamat = request.getParameter("alamat");
        namaJurusan = request.getParameter("namaJurusan");
        
        if(!idMahasiswa.isEmpty()|| !idMahasiswa.equals("")){
            Mahasiswa mhs= new Mahasiswa();
            mhs.setAlamat(alamat);
            mhs.setNamaMahasiswa(namaMahasiswa);
            mhs.setNamaJurusan(namaJurusan);
         ms.updateMahasiswa(mhs, idMahasiswa);
       }
        else{
            Mahasiswa mhs = new Mahasiswa();
            mhs.setAlamat(alamat);
            mhs.setNamaMahasiswa(namaMahasiswa);
            mhs.setNamaJurusan(namaJurusan);
            ms.addMahasiswa(mhs);
        }
       request.setAttribute("listMahasiswa", ms.getAllMahasiswas());
        request.getRequestDispatcher("TabelMahasiswa.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

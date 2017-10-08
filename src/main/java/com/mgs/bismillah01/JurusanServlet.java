/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mgs.bismillah01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "JurusanServlet", urlPatterns = {"/JurusanServlet"})
public class JurusanServlet extends HttpServlet {

    static JurusanService js = new JurusanService();


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String idJurusan = new String();
        String action= new String();
        String namaJurusan = new String();
        try{
            action = request.getParameter("action").toString();
            idJurusan = request.getParameter("idJurusan");
             namaJurusan = request.getParameter("namaJurusan");
        }catch(NullPointerException e){
            
        }
        if(!idJurusan.isEmpty()){
           Jurusan mhs = new Jurusan();
           mhs.setNamaJurusan(namaJurusan);
           js.updateJurusan(mhs, idJurusan);
       }
        if(action.equals("")){
            request.setAttribute("listJurusan", js.getAllJurusans());
        request.getRequestDispatcher("TabelJurusan.jsp").forward(request, response);
        }
        if(action.equals("delete")){
            request.setAttribute("action", action);
            js.deleteJurusan(Integer.parseInt(idJurusan));
            request.setAttribute("listJurusan", js.getAllJurusans());
        request.getRequestDispatcher("TabelJurusan.jsp").forward(request, response);
        }
        if(action.equals("edit"))
        {
            request.setAttribute("action", action);
            request.setAttribute("jurusan", js.getJurusanById(Integer.parseInt(idJurusan)));
        request.getRequestDispatcher("FormJurusan.jsp").forward(request, response);
        }
        if(action.equals("create"))
        {
            request.setAttribute("action", action);
        request.getRequestDispatcher("FormJurusan.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("listJurusan", js.getAllJurusans());
        request.getRequestDispatcher("TabelJurusan.jsp").forward(request, response);
        }
        request.getRequestDispatcher("FormJurusan.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
         String idJurusan ="",namaJurusan;
        idJurusan = request.getParameter("idJurusan");
        namaJurusan = request.getParameter("namaJurusan");
        
        if(!idJurusan.isEmpty()|| !idJurusan.equals("")){
            Jurusan mhs= new Jurusan();
            mhs.setNamaJurusan(namaJurusan);
         js.updateJurusan(mhs, idJurusan);
       }
        else{
            Jurusan mhs = new Jurusan();
            mhs.setNamaJurusan(namaJurusan);
            js.addJurusan(mhs);
        }
       request.setAttribute("listJurusan", js.getAllJurusans());
        request.getRequestDispatcher("TabelJurusan.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

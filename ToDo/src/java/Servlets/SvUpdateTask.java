/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import Logica.Controladora;
import Logica.Tarea;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.lang.Integer ;


/**
 *
 * @author bruno
 */
@WebServlet(name="SvUpdateTask" , urlPatterns = {"/SvUpdateTask"})
public class SvUpdateTask extends HttpServlet {

    Controladora ctrl = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
            out.println("data saved");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
        response.sendRedirect("update.jsp");

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPut(request, response); 
        Integer idTask =  Integer.valueOf(request.getReader().readLine());
        
        System.out.println(idTask.getClass());
        HttpSession session = request.getSession();
        session.setAttribute("idTaskUpdate", idTask);
        

    }
    
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idtarea= Integer.parseInt(request.getParameter("idtask"));
        String task = request.getParameter("task");
        
        Tarea tarea = new Tarea(idtarea , task);
        
        ctrl.actualizarTarea(tarea);
        response.sendRedirect("index.jsp");
        
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

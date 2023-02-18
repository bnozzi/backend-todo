


package Servlets;
import Logica.Controladora;
import Logica.Tarea;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;




/**
 *
 * @author bruno
 */
@WebServlet(name = "SVtodo", urlPatterns = {"/SVtodo"})
public class SVtodo extends HttpServlet {

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
            
        //HttpSession session = request.getSession();
        //get object task from db
        List<Tarea> taskList = ctrl.LeerTareas();
        //session.setAttribute("taskList", taskList);
        
        //save every getter into list
        List tareas = new ArrayList<>();
        for (Tarea tarea:taskList ){
            tareas.add(tarea.toJson());
            
        }
        System.out.println(tareas);
        
        
        response.setStatus(200);
        response.setHeader("Content-Type", "application/json");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        String key = "{\"tasklist\": " +tareas +"}";
        response.getOutputStream().println(key);
        //session.setAttribute("taskList", taskList);
        
  
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        resp.setHeader("Access-Control-Allow-Headers", "content-type");
        resp.setHeader("Access-Control-Allow-Methods", "POST, DELETE, PUT");
        

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("add");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");

       BufferedReader reader = request.getReader();
                
                String jsonBody= reader.readLine(); //"{"id":123}"
                
                System.out.println(jsonBody);
                //instance Gson to manage Json 
                Gson gson = new Gson();
                //???
                JsonObject json=gson.getAdapter(JsonObject.class).fromJson(jsonBody);
                 
                
                //get tarea from json
                String tarea= json.get("tarea").getAsString();
                //System.out.println(tarea);   
        
        
                Tarea task= new Tarea(0,tarea);
                ctrl.crearTarea(task);
        
        //response.sendRedirect("index.jsp");
        
        
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
                
                resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");

                //way to get body data from put/delete fetch 

               int id = Integer.parseInt(req.getParameter("id"));
                
                //call to controladora 
                ctrl.eliminarTarea(id);
               
                System.out.println("Deleted");
                resp.setStatus(200);
                
                
                
                
    }
    
    
    
    
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse response) 
            throws ServletException, IOException {
            System.out.println("Update");
            //get task to update 
                    response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");

                BufferedReader reader = req.getReader();
                
                String jsonBody= reader.readLine(); //"{"id":123}"
                
                System.out.println(jsonBody);
                //instance Gson to manage Json 
                Gson gson = new Gson();
                //???
                JsonObject json=gson.getAdapter(JsonObject.class).fromJson(jsonBody);
                String tarea = json.get("task").getAsString();
                int id= json.get("id").getAsInt();
                Tarea TaskObject=new Tarea(id,tarea);
                ctrl.actualizarTarea(TaskObject);
    }

    
    
   
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

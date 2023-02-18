<%-- 
    Document   : update
    Created on : 30 ene. 2023, 14:24:12
    Author     : bruno
--%>

<%@page import="Logica.Tarea"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <form action="SvUpdateTask" method="post">
           <% if (request.getSession().getAttribute("idTaskUpdate")!=null){
                String id= request.getSession().getAttribute("idTaskUpdate").toString();
                Controladora ctrl= new Controladora();
                Tarea task= ctrl.ObtenerPorId(Integer.parseInt(id));
             %>  
             <label> modifique la tarea </label>
           <input type="text" name="task" value="<%= task.getTarea() %>">
           <input type="number" name="idtask" value="<%= task.getId()%>" style="display: none">
           <input type="submit" value="guardar" />

           <% } 
else{
System.out.println(request.getSession().getAttributeNames().asIterator());
}
           %>
        </form>
        
    </body>
</html>

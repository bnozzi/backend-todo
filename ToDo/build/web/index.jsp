<%-- 
    Document   : index
    Created on : 28 ene. 2023, 12:33:02
    Author     : bruno
--%>

<%@page import="java.util.List"%>
<%@page import="Logica.Tarea"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        
    </head>
    <body  >
        <p> Add task</p>
        <!--     post from -->
        
         <form action="SVtodo" method="post">
            <input type="text" name="task">
            <input type="submit" value="guardar" />
        </form>
       <br>
       <label> List of To Do </label>
       <!--    get from -->

       <form action="SVtodo" method="get">
          <input type="submit" value="get tasks" />
       </form>
       
       
        <% 
        
        if (request.getSession().getAttribute("taskList")!=null){
        
        List<Tarea> listaTareas= (List) request.getSession().getAttribute("taskList");

        for (Tarea task: listaTareas) {
                
        %>

        <ul>
            <li>
                <%= task.getTarea() %>
                
                <form action="SVtodo" onsubmit="DeleteTask('<%= task.getId()%>');">
                    <input type="submit" value="Delete" />
                </form>
                <form action="SvUpdateTask" onsubmit="UpdateTask('<%= task.getId()%>');">
                    <input type="submit" value="Update" />
                </form>
            </li>

        </ul>

        
        
        <% } //endfor
        }//endif
            
        %>
        
        
        
        
        <script>
            
            function DeleteTask(task){
                fetch("SVtodo", {method: 'DELETE', body: task  });
                   
            
            }
            
            function UpdateTask(task){
                fetch("SvUpdateTask", {method: 'PUT', body: task  });
            }
            
        </script>
    </body>
</html>

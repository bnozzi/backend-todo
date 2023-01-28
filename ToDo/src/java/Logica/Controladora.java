/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;
import Persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
     
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void crearTarea(Tarea tarea){
        controlPersis.create(tarea);
    }
    
    public List<Tarea> LeerTareas(){
        return controlPersis.read();
        
    }
    //rest of crud methods 
    
}

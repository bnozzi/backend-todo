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
    public void eliminarTarea(int id){
        controlPersis.delete(id);
    }
    public void actualizarTarea(Tarea tarea){
       controlPersis.update(tarea);
    }
    public Tarea ObtenerPorId(int id){
        return controlPersis.GetById(id);
    }
    
}


package Persistencia;

import Logica.Tarea;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    
TareaJpaController tareaJpa = new TareaJpaController();

public void create(Tarea tarea){
    tareaJpa.create(tarea);
}

public void update(){
    
}


public List<Tarea> read(){
    System.out.println(tareaJpa.findTareaEntities());
    return tareaJpa.findTareaEntities();

}

public void delete(int id){
    try {
        tareaJpa.destroy(id);
    } catch (NonexistentEntityException ex) {
        Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}

}

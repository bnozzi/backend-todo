/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author bruno
 */

@Entity
public class Tarea implements Serializable {
    
    @Id // anotation para seleccionar el id 
    @GeneratedValue(strategy = GenerationType.AUTO) // anotation para elegir una estrategia a la hora de cargar el id
    private int id;
    
    @Basic // para el resto de campos 
    private String tarea;

    public Tarea() {
        
    }

    public Tarea(int id, String tarea) {
        this.id = id;
        this.tarea = tarea;
    }

    public int getId() {
        return id;
    }

    public String getTarea() {
        return tarea;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Tarea{" + "id=" + id + ", tarea=" + tarea + '}';
    }
    
    public String toJson(){
        return ("{ \"id\" : "+id+", \"tarea\":  \""+tarea+"\" }");
        
    }
    
    

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }
    
    
    
}

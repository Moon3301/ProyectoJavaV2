/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentaBook;

import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class CarroCompras {
    
    private int id;
    private String fecha;
    private ArrayList listaLibros;
 

    public CarroCompras(int id, String fecha, ArrayList listaLibros, int cantidad, int total) {
        this.id = id;
        this.fecha = fecha;
        this.listaLibros = listaLibros;
    }

    public CarroCompras() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(ArrayList listaLibros) {
        this.listaLibros = listaLibros;
    }

  
    
    
    
    
    
    
    
    
    
}

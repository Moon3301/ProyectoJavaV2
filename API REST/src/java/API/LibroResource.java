/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import VentaBook.Categoria;
import VentaBook.Libro;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.ws.rs.POST;


/**
 * REST Web Service
 *
 * @author carlo
 */
@Path("Libro")
public class LibroResource {

    @Context
    private UriInfo context;
    static final ArrayList<Libro> libros = new ArrayList<Libro>();
    
    Categoria cat = new Categoria(1,"Horror");
        
    Libro libro1 = new Libro(1,"Harry1.png",20,"Harry Potter 1","J.K Rowlin","Salamandra",19900,cat);
    Libro libro2 = new Libro(2,"Harry2.png",10,"Harry Potter 2","J.K Rowlin","Salamandra",9900,cat);
    Libro libro3 = new Libro(3,"Harry3.png",15,"Harry Potter 3","J.K Rowlin","Salamandra",29900,cat);
    

    /**
     * Creates a new instance of LibroResource
     */
    public LibroResource() {
        
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);
        
    }
    
    public static String peticionHttpGet(String urlParaVisitar) throws Exception {
		// Esto es lo que vamos a devolver
		StringBuilder resultado = new StringBuilder();
		// Crear un objeto de tipo URL
		URL url = new URL(urlParaVisitar);

		// Abrir la conexión e indicar que será de tipo GET
		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("GET");
		// Búferes para leer
		BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		String linea;
		// Mientras el BufferedReader se pueda leer, agregar contenido a resultado
		while ((linea = rd.readLine()) != null) {
			resultado.append(linea);
		}
		// Cerrar el BufferedReader
		rd.close();
		// Regresar resultado, pero como cadena, no como StringBuilder
		return resultado.toString();
	}

    @GET
    @Path("Api")
    @Produces("text/html")
    public String getJson() {
        
        String url = "http://127.0.0.1:8000/api/listarCarro?format=json";
		String respuesta = "";
		try {
			respuesta = peticionHttpGet(url);
			System.out.println("Datos Recibidos con exito:\n");
		} catch (Exception e) {
			// Manejar excepción
			e.printStackTrace();
		}

        return respuesta;
  
    }
    
    @GET
    @Path("listar")
    @Produces("application/json")
    public ArrayList<Libro> ListarLibros() {
        

        
        return libros;
        
    }
    
    @POST
    @Path("agregar")
    @Produces("application/json")
    @Consumes("application/json")
    public ArrayList<Libro> AgregarLibro(Libro lib){
        
        libros.add(lib);
        return libros;
         
    }
    
    
    @POST
    @Path("buscar/{id}")
    @Produces("application/json")
    public Libro BuscarLibro(@PathParam("id") String id){
        
        Libro lib = new Libro();
        
        for(Libro l: libros){
            
            if(l.getId() == Integer.parseInt(id)){
                
                lib.setAutor(l.getAutor());
                lib.setCat(l.getCat());
                lib.setEditorial(l.getEditorial());
                lib.setId(l.getId());
                lib.setImagen(l.getImagen());
                lib.setNombre(l.getNombre());
                lib.setPrecio(l.getPrecio());
                lib.setStock(l.getStock());

            }
            
            
        
        
        }
        return lib;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}

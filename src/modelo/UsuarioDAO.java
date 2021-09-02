/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mongodb.BasicDBObject;


/**
 *
 * @author Martin
 */
public class UsuarioDAO {
    
    public void insertarUsuario(Usuario u){
        
        ConexionAgro conec = new ConexionAgro();
        BasicDBObject documento= new BasicDBObject();
        documento.put("Nombre: ",u.getNombre());
        documento.put("Apellido: ",u.getApellido());
        documento.put("Nombre de Usuario: ",u.getNombreUsuario());
        documento.put("Contaseña: ",u.getContrasenia());
        documento.put("E-mail: ",u.getEmail());
        documento.put("Tipo: ",u.getTipo());
        conec.coleccion.insert(documento);
        
    }
    
    
    
}

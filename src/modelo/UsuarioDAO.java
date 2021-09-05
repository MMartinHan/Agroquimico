/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.util.ArrayList;


/**
 *
 * @author Martin
 */
public class UsuarioDAO {
    
    public void insertarUsuario(Usuario u){
        
        ConexionAgro conec = ConexionAgro.getInstance();
        conec.Conexion();
        BasicDBObject documento= new BasicDBObject();
        documento.put("Nombre: ",u.getNombre());
        documento.put("Apellido: ",u.getApellido());
        documento.put("Nombre de Usuario: ",u.getNombreUsuario());
        documento.put("Contaseña: ",u.getContrasenia());
        documento.put("E-mail: ",u.getEmail());
        documento.put("Tipo: ",u.getTipo());
        conec.coleccion.insert(documento);
        
    }
    
    public ArrayList<Usuario> obtenerUsuarios(){
        ArrayList<Usuario> listUsuarios = new ArrayList();
        Usuario u1;
        ConexionAgro conec = ConexionAgro.getInstance();
        conec.Conexion();
        
        DBCursor cursor = conec.coleccion.find();
        
        while(cursor.hasNext()){
            DBObject obj = cursor.next();
            u1 = new Usuario((String)obj.get("Nombre de Usuario: "));
            u1.setContrasenia((String)obj.get("Contaseña: "));
            u1.setTipo((String)obj.get("Tipo: "));
            System.out.println(u1.toString());
            listUsuarios.add(u1);
        }
        return listUsuarios;
    }
    
    public ArrayList<Usuario> obtenerEmails(){
        ArrayList<Usuario> listEmails = new ArrayList();
        Usuario u1;
        ConexionAgro conec = ConexionAgro.getInstance();
        conec.Conexion();
        
        DBCursor cursor = conec.coleccion.find();
        
        while(cursor.hasNext()){
            u1 = new Usuario((String)cursor.next().get("E-mail: "));
            System.out.println(u1.toString());
            listEmails.add(u1);
        }
        return listEmails;
    }
    
    
    
    
    
}

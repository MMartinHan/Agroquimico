/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;

/**
 *
 * @author Martin
 */
public class ConexionAgro {
    
    private static ConexionAgro instance;
    
    DB baseDatos;
    DBCollection coleccion;
    BasicDBObject documento = new BasicDBObject();
    
    private ConexionAgro(){
    }
    
    public static ConexionAgro getInstance (){
         if (instance== null)
            instance= new ConexionAgro();
        return instance;
    }
    
    public void Conexion(){
        try{
           MongoClient mongo = new MongoClient("localhost", 27017);
           baseDatos= mongo.getDB("Agroquimico");
           coleccion= baseDatos.getCollection("Usuario");
           System.out.println("conexion a base de datos exitoso..");
        }
        catch(Exception e){
        
        }
    }
    
    /*DB baseDatos;
    DBCollection coleccion;
    BasicDBObject documento = new BasicDBObject();
    
    public ConexionAgro(){
        try{
           MongoClient mongo = new MongoClient("localhost", 27017);
           baseDatos= mongo.getDB("Agroquimico");
           coleccion= baseDatos.getCollection("Usuario");
           System.out.println("conexion a base de datos exitoso..");
        }
        catch(Exception e){
        
        }
    }*/

   
    
}

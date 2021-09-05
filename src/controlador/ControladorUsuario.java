/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.AgroquimicoFrm;
import vista.RegistroFrm;

/**
 *
 * @author Martin
 */
public class ControladorUsuario implements ActionListener {
    
    UsuarioDAO objetoDAO = new UsuarioDAO();
    Usuario objetoUsuario = new Usuario();
    RegistroFrm objetoRegistro = new RegistroFrm();
    
    public ControladorUsuario(RegistroFrm r){
        
        this.objetoRegistro = r;
        this.objetoRegistro.btnRegiatrarse.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == objetoRegistro.btnRegiatrarse){
            objetoRegistro.lbNotify.setText("");   
            if(verficarUsuario()==false && verficarEmail()==false){
                agregarUsuario();
                RegistroFrm g = new RegistroFrm();
                new ControladorUsuario(g);
                g.setVisible(true);
                g.setLocationRelativeTo(g);
                g.dispose();
                AgroquimicoFrm a = new AgroquimicoFrm();
                new ControladorLogin(a);
                a.setVisible(true);
                a.setLocationRelativeTo(a);
                
            }
         
        }
        
    }
    
    public void agregarUsuario(){
        objetoUsuario.setNombre(objetoRegistro.txtNombre.getText());
        objetoUsuario.setApellido(objetoRegistro.txtApellido.getText());
        objetoUsuario.setNombreUsuario(objetoRegistro.txtNombreUsuario.getText());
        objetoUsuario.setContrasenia(objetoRegistro.txtContraseña.getText());
        objetoUsuario.setEmail(objetoRegistro.txtCorreo.getText());
        objetoUsuario.setTipo(objetoRegistro.jcbTipoUsuario.getSelectedItem().toString());
        objetoDAO.insertarUsuario(objetoUsuario);
    }
    
    public boolean verficarUsuario(){
        String Aux = objetoRegistro.txtNombreUsuario.getText();
        int numUsuario = objetoDAO.obtenerUsuarios().size();
        
        for(int i=0; i<numUsuario;i++){
            objetoUsuario = (Usuario)objetoDAO.obtenerUsuarios().get(i);
            if(Aux.equals(objetoUsuario.getNombreUsuario().trim())){
                String notificacion = "Usuario ya existente";
                objetoRegistro.lbNotify.setText(notificacion);
                return true;
            } 
        }
        return false;
    }
    
    public boolean verficarEmail(){
        String Aux = objetoRegistro.txtCorreo.getText();
        boolean bandera = false;
        int numUsuario = objetoDAO.obtenerEmails().size();
        
        for(int i=0; i<numUsuario;i++){
            objetoUsuario = (Usuario)objetoDAO.obtenerEmails().get(i);
            if(Aux.equals(objetoUsuario.getEmail())){
                String notificacion = "Correo ya existente";
                objetoRegistro.lbNotify.setText(notificacion);
                bandera = true;
            } 
        }
        return bandera;
    }
}

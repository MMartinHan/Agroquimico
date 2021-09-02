/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Usuario;
import modelo.UsuarioDAO;
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
            agregarUsuario();
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
    
}

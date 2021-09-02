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
import vista.AgroquimicoFrm;
import vista.RegistroFrm;

/**
 *
 * @author Martin
 */
public class ControladorLogin implements ActionListener {
    
    UsuarioDAO objetoDAO = new UsuarioDAO();
    Usuario objetoUsuario = new Usuario();
    AgroquimicoFrm objetoRegistro = new AgroquimicoFrm();
    
    public ControladorLogin(AgroquimicoFrm a){
        
        this.objetoRegistro = a;
        this.objetoRegistro.btnRegistrar.addActionListener(this);
                
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==objetoRegistro.btnRegistrar){
            RegistroFrm r = new RegistroFrm();
            r.setVisible(true);
            
        }
    }
    
    
}

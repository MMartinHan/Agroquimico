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
import vista.CompradorFrm;
import vista.RegistroFrm;
import vista.VendedorFrm;

/**
 *
 * @author Martin
 */
public class ControladorLogin implements ActionListener {
    
    UsuarioDAO objetoDAO = new UsuarioDAO();
    Usuario objetoUsuario = new Usuario();
    AgroquimicoFrm objetoAgriquimicoFrm = new AgroquimicoFrm();
    
    public ControladorLogin(AgroquimicoFrm a){
        
        this.objetoAgriquimicoFrm = a;
        this.objetoAgriquimicoFrm.btnRegistrar.addActionListener(this);
        this.objetoAgriquimicoFrm.btnIngresar.addActionListener(this);
                
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==objetoAgriquimicoFrm.btnRegistrar){
            //RegistroFrm r = new RegistroFrm();
            //r.setVisible(true);
            RegistroFrm g = new RegistroFrm();
            new ControladorUsuario(g);
            g.setVisible(true);
            g.setLocationRelativeTo(g);

            
        }
        
        if(e.getSource()==objetoAgriquimicoFrm.btnIngresar){
            if(verficarUsuarioContrasenia()){
                if("Comprador".equals(objetoUsuario.getTipo())){
                    CompradorFrm c = new CompradorFrm();
                    c.setVisible(true);
                }
                if("Vendedor".equals(objetoUsuario.getTipo())){
                    VendedorFrm v = new VendedorFrm();
                    v.setVisible(true);
                }
                
            }
        }
    }
    
    public boolean verficarUsuarioContrasenia(){
        
        int numUsuario = objetoDAO.obtenerUsuarios().size();
        
        for(int i=0; i<numUsuario;i++){
        
            objetoUsuario = (Usuario)objetoDAO.obtenerUsuarios().get(i);
            if(objetoAgriquimicoFrm.txtUsuario.getText().equals(objetoUsuario.getNombreUsuario())){
                if(objetoAgriquimicoFrm.txtContraseña.getText().equals(objetoUsuario.getContrasenia())){
                return true;
                } else{
                    String notificacion = "Usuario o contraseña incorrecta";
                objetoAgriquimicoFrm.lbNotify.setText(notificacion);
                return false;
                }
            } 
        }
        return false;
    }
    
    
    
}

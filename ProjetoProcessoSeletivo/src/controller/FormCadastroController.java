/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Conexao;
import dao.UsuarioDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;
import view.FormCadastroVirew;

/**
 *
 * @author JUREG
 */
public class FormCadastroController {
    
    private FormCadastroVirew view;

    public FormCadastroController(FormCadastroVirew view) {
        this.view = view;
    }
    
    public void salvaUsuario(){
        
      
                
        String usuario = view.getjTextFieldUsuario().getText();
        String senha = view.getjPasswordFieldSenha().getText();
        
        Usuario usuarioFelipe = new Usuario(usuario, senha);
     
        
        try {
            Connection conexao = new Conexao().getConnection();
            UsuarioDao usuarioDao = new UsuarioDao(conexao);
            usuarioDao.insert(usuarioFelipe);
            
            JOptionPane.showMessageDialog(null, "Usuario Salvo Com Sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(FormCadastroVirew.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

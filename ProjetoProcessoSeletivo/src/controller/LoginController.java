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
import javax.swing.JOptionPane;
import model.Usuario;
import view.LoginView;
import view.MenuView;

/**
 *
 * @author JUREG
 */
public class LoginController {
    
    private LoginView view;

    public LoginController(LoginView view) {
        this.view = view;
    }

    public void autenticar() throws SQLException {
        
        //Buscar usuario da View
        String usuario = view.getjTextFieldUsuario().getText();
        String senha = view.getjPasswordFieldSenha().getText();
        
        Usuario usuarioAutenticar = new Usuario(usuario, senha);
        
        //Verificar se existe no banco de dados
        Connection conexao = new Conexao().getConnection();
        UsuarioDao usuarioDao = new UsuarioDao(conexao);
        
        boolean existe = usuarioDao.existeNoBancoPorUsuarioESenha(usuarioAutenticar);
        
        //Se existir Direciona para menu
        if(existe){
          MenuView telaDeMenu = new MenuView();
     telaDeMenu.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(view, "Usuario ou Senha inválidos");
        }
        
     
    }
    
    
}

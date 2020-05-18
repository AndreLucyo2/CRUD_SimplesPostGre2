/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import DAO.Conexao;
import DAO.UsuarioDAO;
import MODEL.UsuarioDTO;
import VIEW.LogInView;
import VIEW.MenuView;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
public class LoginController
{

    //Vinculando a View que vai controlar
    private LogInView view;

    public LoginController(LogInView view)
    {
        this.view = view;
    }

    public void autenticar() throws SQLException
    {
        //1 - buscar o usuario da view [tela] 
        String usuario = view.getjTextFileldUsuario().getText();
        String senha = view.getjPasswordFileldSenha().getText();
        //Passar dados da tela para o objeto:
        UsuarioDTO usuarioDTOAutentcar = new UsuarioDTO(usuario, senha);
               
        //2 - verificar se existe usuario no banco de dados
        //Criar um CONEXAO
        Connection conexao = new Conexao().getConection();
        //Criar DAO:
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
        
        //Variavel boleana para a validação:
        boolean existe = usuarioDAO.existeNoBancoPorUsuarioESenha(usuarioDTOAutentcar);
                
        //3- se existir, direciona para a tela principal entrar no sistema
        if (existe)
        {
            JOptionPane.showMessageDialog(null, "Acesso iberado!");
            
            MenuView telaDEMenuView = new MenuView();
            telaDEMenuView.setVisible(true);          
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Usuario ou senha inválido!");
            
        }  
    }

}

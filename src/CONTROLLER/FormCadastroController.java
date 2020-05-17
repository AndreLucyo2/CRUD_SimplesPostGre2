/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import DAO.Conexao;
import DAO.UsuarioDAO;
import MODEL.UsuarioDTO;
import VIEW.FormCadastroView;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
public class FormCadastroController
{

    //Obriga a passar uma tela view
    private FormCadastroView view;

    public FormCadastroController(FormCadastroView view)
    {
        this.view = view;
    }

    /**
     * 
     */
    public void salvaUsuario()
    {
        //Pegar os campos da tela atraves da propriedade VIEW:
        String usuario = view.getjTextFileldUsuario().getText();
        String senha = view.getjPasswordFileldSenha().getText();

        //Instacia o objeto usuarioDTO:
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario, senha);

        try
        {
            //Criar um CONEXAO
            Connection conexao = new Conexao().getConection();

            //Criar DAO:
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);

            //Faz o insert:
            usuarioDAO.insert(usuarioDTO);

            JOptionPane.showMessageDialog(null, "Usuario salvo com sucesso! \0/ ");

        }
        catch (SQLException ex)
        {
            Logger.getLogger(FormCadastroView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/** 
 *
 * @author Andre
 */
public class UsuarioDAO
{
    //Usa uma propriedade no construtor:
    private final Connection connection;

    //Usuario so pode ser criado se passar uma conexao:
    public UsuarioDAO(Connection connection)
    {
        this.connection = connection;
    }
    
    /**
     * Metodo que recebe um obj. usuario e faz o insert
     * @param usuario
     * @throws SQLException 
     */
    public void insert(UsuarioDTO usuario) throws SQLException //lança uma SQL Exception caso der erro.
    {
        //Cria o Select INSERT:
        String sql = "INSERT INTO usuario(usuario,senha) VALUES('"+usuario.getUsuario()+"','"+usuario.getSenha()+"'); ";

        //Prepara a Conexao com o banco, informano uma Query sql:
        PreparedStatement statement = connection.prepareStatement(sql); 
        statement.execute();
        
    }

    /**
     * Teste: Verifica se o usuario informado na tela de logIn existe no banco
     */
    public boolean existeNoBancoPorUsuarioESenha(UsuarioDTO usuario) throws SQLException //lança uma SQL Exception caso der erro.
    {
        //Cria o Select SQL:
        String sql = "SELECT * FROM usuario WHERE usuario = ? AND senha = ?";

        //Prepara a Conexao com o banco, informano uma Query sql:
        PreparedStatement statement = connection.prepareStatement(sql);
        
        //Passar os valores por parametros: conforme a ordem dos pontos de interrogação
        statement.setString(1, usuario.getUsuario());
        statement.setString(2, usuario.getSenha());
        
        
        statement.execute();

        //Pega o resultado que retornou do banco:
        ResultSet resultSet = statement.getResultSet();

        //Se retorna resultado ele ja definine o retorno como true
        return resultSet.next();

    }

}

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
import java.util.ArrayList;

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
     *
     * @param usuario
     * @throws SQLException
     */
    public void insert(UsuarioDTO usuario) throws SQLException //lança uma SQL Exception caso der erro.
    {
        //Cria o Select INSERT:
        String sql = "INSERT INTO usuario(usuario,senha) VALUES('" + usuario.getUsuario() + "','" + usuario.getSenha() + "'); ";

        //Prepara a Conexao com o banco, informano uma Query sql:
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();

    }

    /**
     *
     * @param usuario
     * @throws SQLException
     */
    public void update(UsuarioDTO usuario) throws SQLException //lança uma SQL Exception caso der erro.
    {
        //os ? serão trocados pelos parametros na ordem indicadas:
        String sql = "UPDATE usuario SET usuario = ?, senha = ? WHERE id = ?;";

        //Prepara a Conexao com o banco, informano uma Query sql:
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, usuario.getUsuario());//ORDEM do ponto de insterrogação 
        statement.setString(2, usuario.getSenha());
        statement.setInt(3, usuario.getId());//ja seta o parametros com o tipo de dados conforme o campo espera no caso int

        statement.execute();

    }

    /**
     * Valida se é usuario esta salvando ou alterando:
     *
     * @param usuario
     * @throws SQLException
     */
    public void insertOrUpdate(UsuarioDTO usuario) throws SQLException
    {
        //So testa para ver se é update ou salvar
        if (usuario.getId() > 0)
        {
            update(usuario); //se ID for maior que zero , ja tem cadastro, neste daso sera um uodate
        }
        else
        {
            insert(usuario);//caso contrario esta criando um novo usuario
        }
    }

    /**
     * Delte pelo ID
     *
     * @param usuario
     * @throws SQLException
     */
    public void delete(UsuarioDTO usuario) throws SQLException
    {
        //os ? serão trocados pelos parametros na ordem indicadas:
        String sql = "DELETE FROM usuario WHERE id = ?;";

        //MSG no console:
        System.out.println("Conexão iniciada!");

        //Prepara a Conexao com o banco, informano uma Query sql:
        PreparedStatement statement = connection.prepareStatement(sql);

        //Passar os valores por parametros: conforme a ordem dos pontos de interrogação
        statement.setInt(1, usuario.getId());

        statement.execute();

        //MSG de sucesso no console:
        System.out.println("Fez o DELETE e finalizada a CONEXAO com sucesso!");
    }

    /**
     * Traz uma lista com todos os usuarios
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<UsuarioDTO> selectAll() throws SQLException
    {
        String sql = "SELECT * FROM usuario";

        //Prepara a Conexao com o banco, informano uma Query sql:
        PreparedStatement statement = connection.prepareStatement(sql);

        //Separa em um novo metodo para facilitar a leitura:
        return pesquisa(statement); // statement na possui o sql.
    }

    /**
     * Recupera uma lista de objetos a partir de um select
     *
     * @param statement
     * @return
     * @throws SQLException
     */
    private ArrayList<UsuarioDTO> pesquisa(PreparedStatement statement) throws SQLException
    {
        ArrayList<UsuarioDTO> usuarios = new ArrayList<>();

        statement.execute();

        //Nesta lista tenho todos os usuario retornados:
        ResultSet resultSet = statement.getResultSet();

        //retorna varias linhas faz iteração em cada linha retornada do select:
        //Cada linha se torna uma usuario: se tem proxima linha continua      
        while (resultSet.next())// resultSet.next() ja testa se retornou pelo menos uma linha.
        {
            //Percorre cada linha, pegando os valores e passando para os campos de objeto:
            int id = resultSet.getInt("id");
            String usuario = resultSet.getString("usuario");
            String senha = resultSet.getString("senha");

            //Instancia o novo objeto:
            UsuarioDTO usuarioComDadosDoBanco = new UsuarioDTO(id, usuario, senha);
            //Adiciona o usuario na no Array
            usuarios.add(usuarioComDadosDoBanco);//Adiciona cada objeto no arrayList de objetos

        }

        //Retorna a lista de objetos retornados do banco:
        return usuarios;
    }

    /**
     *
     * @param usuario
     * @return
     * @throws SQLException
     */
    public UsuarioDTO selectPorID(UsuarioDTO usuario) throws SQLException
    {
        String sql = "SELECT * FROM usuario WHERE ID = ? ";

        //MSG no console:
        System.out.println("Conexão iniciada!");

        //Prepara a Conexao com o banco, informano uma Query sql:
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, usuario.getId());

        //Retorna pra mim o objeto com index 0 retorna ua lista porem pega so o primeiro
        return pesquisa(statement).get(0);//retorna somente 1 objeto
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

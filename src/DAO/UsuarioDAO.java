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
     * @param usuario
     * @throws SQLException 
     */
    public void insert(UsuarioDTO usuario) throws SQLException //lança uma SQL Exception caso der erro.
    {
        String sql = "INSERT INTO usuario(usuario,senha) VALUES('"+usuario.getUsuario()+"','"+usuario.getSenha()+"'); ";

        //Prepara a Conexao com o banco, informano uma Query sql:
        PreparedStatement statement = connection.prepareStatement(sql); 
        statement.execute();
        connection.close();

    }

    //https://youtu.be/-l1wb78EqUI?list=PLJIP7GdByOyvpQ7EbzucVHocSAG7_EZQZ&t=255
    public void update(UsuarioDTO usuario) throws SQLException //lança uma SQL Exception caso der erro.
    {
        //os ? serão trocados pelos parametros na ordem indicadas:
        String sql = "UPDATE usuario SET usuario = ?, senha = ? WHERE id = ?;";

        //MSG no console:
        System.out.println("Conexão iniciada!");

        //Prepara a Conexao com o banco, informano uma Query sql:
        PreparedStatement statement = connection.prepareStatement(sql);

        //https://youtu.be/QrsP0Yvw3QA?list=PLJIP7GdByOyvpQ7EbzucVHocSAG7_EZQZ&t=658  
        https://youtu.be/-l1wb78EqUI?list=PLJIP7GdByOyvpQ7EbzucVHocSAG7_EZQZ&t=314
        statement.setString(1, usuario.getUsuario());//ORDEM do ponto de insterrogação 
        statement.setString(2, usuario.getSenha());
        statement.setInt(3, usuario.getId());//ja seta o parametros com o tipo de dados conforme o campo espera no caso int

        statement.execute();

        //MSG de sucesso no console:
        System.out.println("Fez o UPDATE e finalizada a CONEXAO com sucesso!");

    }

    //https://youtu.be/-l1wb78EqUI?list=PLJIP7GdByOyvpQ7EbzucVHocSAG7_EZQZ&t=525
    public void insertOrUpdate(UsuarioDTO usuario) throws SQLException
    {
        //https://youtu.be/-l1wb78EqUI?list=PLJIP7GdByOyvpQ7EbzucVHocSAG7_EZQZ&t=525
        if (usuario.getId() > 0)
        {
            update(usuario); //se ID for maior que zero , ja tem cadastro, neste daso sera um uodate
        } else
        {
            insert(usuario);//caso contrario esta criando um novo usuario
        }

    }

    //https://youtu.be/-l1wb78EqUI?list=PLJIP7GdByOyvpQ7EbzucVHocSAG7_EZQZ&t=603
    public void delete(UsuarioDTO usuario) throws SQLException
    {
        //os ? serão trocados pelos parametros na ordem indicadas:
        String sql = "DELETE FROM usuario WHERE id = ?;";

        //MSG no console:
        System.out.println("Conexão iniciada!");

        //Prepara a Conexao com o banco, informano uma Query sql:
        PreparedStatement statement = connection.prepareStatement(sql);

        //https://youtu.be/-l1wb78EqUI?list=PLJIP7GdByOyvpQ7EbzucVHocSAG7_EZQZ&t=632
        statement.setInt(1, usuario.getId());

        statement.execute();

        //MSG de sucesso no console:
        System.out.println("Fez o DELETE e finalizada a CONEXAO com sucesso!");
    }
    
    //https://youtu.be/-l1wb78EqUI?list=PLJIP7GdByOyvpQ7EbzucVHocSAG7_EZQZ&t=1455
    private ArrayList<UsuarioDTO> pesquisa(PreparedStatement statement) throws SQLException
    {
        ArrayList<UsuarioDTO> usuarios = new ArrayList<>();
        
        statement.execute();

        ResultSet resultSet = statement.getResultSet(); // https://youtu.be/-l1wb78EqUI?list=PLJIP7GdByOyvpQ7EbzucVHocSAG7_EZQZ&t=864
        
        //retorna varias linhas faz iteração em cada linha retornada do select:        
        while (resultSet.next())// resultSet.next() ja testa se retornou pelo menos uma linha.
        {
            //https://youtu.be/-l1wb78EqUI?list=PLJIP7GdByOyvpQ7EbzucVHocSAG7_EZQZ&t=1090
            int id = resultSet.getInt("id");
            String usuario = resultSet.getString("usuario");
            String senha = resultSet.getString("senha");

            UsuarioDTO usuarioComDadosDoBanco = new UsuarioDTO(id, usuario, senha);
            usuarios.add(usuarioComDadosDoBanco);//Adiciona cada objeto no arrayList de objetos

        }

        //MSG de sucesso no console:
        System.out.println("Selecionado todos os usuarios e finalizada a CONEXAO com sucesso!");

        //Retorna a lista de objetos retornados do banco:
        return usuarios;
    }

    //https://youtu.be/-l1wb78EqUI?list=PLJIP7GdByOyvpQ7EbzucVHocSAG7_EZQZ&t=1259
    public ArrayList<UsuarioDTO> selectAll() throws SQLException
    {
        String sql = "SELECT * FROM usuario";

        //MSG no console:
        System.out.println("Conexão iniciada!");

        //Prepara a Conexao com o banco, informano uma Query sql:
        PreparedStatement statement = connection.prepareStatement(sql);

        //https://youtu.be/-l1wb78EqUI?list=PLJIP7GdByOyvpQ7EbzucVHocSAG7_EZQZ&t=1455
        return pesquisa(statement); // statement na possui o sql.
    }


    //https://youtu.be/-l1wb78EqUI?list=PLJIP7GdByOyvpQ7EbzucVHocSAG7_EZQZ&t=1365
    public UsuarioDTO selectPorID(UsuarioDTO usuario) throws SQLException
    {
        String sql = "SELECT * FROM usuario WHERE ID = ? ";

        //MSG no console:
        System.out.println("Conexão iniciada!");

        //Prepara a Conexao com o banco, informano uma Query sql:
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, usuario.getId());

        //https://youtu.be/-l1wb78EqUI?list=PLJIP7GdByOyvpQ7EbzucVHocSAG7_EZQZ&t=1455
        //https://youtu.be/-l1wb78EqUI?list=PLJIP7GdByOyvpQ7EbzucVHocSAG7_EZQZ&t=1789
        return pesquisa(statement).get(0);//retorna somente 1 objeto
    }   
    


    //https://youtu.be/gbvVh1738z8?list=PLJIP7GdByOyvpQ7EbzucVHocSAG7_EZQZ&t=820
    //https://youtu.be/gbvVh1738z8?list=PLJIP7GdByOyvpQ7EbzucVHocSAG7_EZQZ&t=959
    /**
     * Teste: Verifica se o usuario informado na tela de logIn existe no banco
     */
    public boolean existeNoBancoPorUsuarioESenha(UsuarioDTO usuario) throws SQLException //lança uma SQL Exception caso der erro.
    {
        //https://youtu.be/gbvVh1738z8?list=PLJIP7GdByOyvpQ7EbzucVHocSAG7_EZQZ&t=1789
        //String sql = "SELECT * FROM usuario WHERE usuario = '"+usuario.getUsuario()+"' AND senha = '"+usuario.getSenha()+"'";

        //https://youtu.be/QrsP0Yvw3QA?list=PLJIP7GdByOyvpQ7EbzucVHocSAG7_EZQZ&t=658
        String sql = "SELECT * FROM usuario WHERE usuario = ? AND senha = ?";

        //MSG no console:
        System.out.println("Conexão iniciada!");

        //Prepara a Conexao com o banco, informano uma Query sql:
        PreparedStatement statement = connection.prepareStatement(sql);

        //https://youtu.be/QrsP0Yvw3QA?list=PLJIP7GdByOyvpQ7EbzucVHocSAG7_EZQZ&t=658        
        statement.setString(1, usuario.getUsuario());//rdemo do ponto de insterrogação 
        statement.setString(2, usuario.getSenha());

        statement.execute();

        //Pega o resultado que retornou do banco:
        ResultSet resultSet = statement.getResultSet();

        //https://youtu.be/gbvVh1738z8?list=PLJIP7GdByOyvpQ7EbzucVHocSAG7_EZQZ&t=1183
        //Enquanto resultSet tiver um proximo, retornar true caso contrario false: 
        return resultSet.next();//https://youtu.be/gbvVh1738z8?list=PLJIP7GdByOyvpQ7EbzucVHocSAG7_EZQZ&t=1424

    }

}

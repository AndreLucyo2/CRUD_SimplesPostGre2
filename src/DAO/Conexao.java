/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Andre
 */
public class Conexao
{
   public Connection getConection() throws SQLException
   {
       //Configurar os dados da conexao: postgreSQL
       Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5433/CRUD_SimplesPostGre2", "postgres", "inside@1");
       return conexao;
   }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author Andre
 */
public class UsuarioDTO
{
    private int id;
    private String usuario;
    private String senha;

    public UsuarioDTO(int id, String usuario, String senha)
    {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
    }

    public UsuarioDTO(String usuario, String senha)
    {
        this.usuario = usuario;
        this.senha = senha;
    }    

    public int getId()
    {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id)
    {
        this.id = id;
    }

    public String getUsuario()
    {
        return usuario;
    }

    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }

    public String getSenha()
    {
        return senha;
    }

    public void setSenha(String senha)
    {
        this.senha = senha;
    }
    
}

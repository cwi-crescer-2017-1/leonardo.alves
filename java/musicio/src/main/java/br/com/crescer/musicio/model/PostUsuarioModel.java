
package br.com.crescer.musicio.model;

import java.math.BigDecimal;

/** 
 * @author leonardo.alves
 **/
public class PostUsuarioModel {
    private BigDecimal idUsuario;
    private String nome;
    private String email;
    
    public PostUsuarioModel (BigDecimal idUsuario, String nome, String email) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
    }

    public BigDecimal getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

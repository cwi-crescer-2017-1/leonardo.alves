
package br.com.crescer.musicio.model;

import java.math.BigDecimal;
import java.util.Date;

/** 
 * @author leonardo.alves
 **/
public class PostUsuarioModel {
    private BigDecimal idUsuario;
    private String nome;
    private String email;
    private Character sexo;
    private Date dataNascimento;
    
    public PostUsuarioModel (BigDecimal idUsuario, String nome, String email, Character sexo, Date dataNascimento) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
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

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}

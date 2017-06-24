
package br.com.crescer.aula4.exercicios.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/** 
 * @author leonardo.alves
 **/
@Entity
public class Video implements Serializable {
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_VIDEO")
    @SequenceGenerator(name = "SEQ_VIDEO", sequenceName = "SEQ_VIDEO")
    @Basic(optional = false)
    private Long id;
    
    @Basic(optional = false)
    private Long valor;
    
    private String nome;
    
    @Column(name = "QUANTIDADE_ESTOQUE")
    private Long quantidadeEstoque;
    
    @Column(name = "DATA_LANCAMENTO")
    @Temporal(TemporalType.DATE)
    private Date dataLancamento;
    
    private String duracao;
    
    @ManyToOne
    @JoinColumn(name = "ID_GENERO")
    private Genero genero;
    
    @OneToMany(mappedBy = "video", targetEntity = Locacao.class)
    private List<Locacao> locacoes;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Long quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Locacao> getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(List<Locacao> locacoes) {
        this.locacoes = locacoes;
    }
   
}

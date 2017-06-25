
package br.com.crescer.aula4.exercicios.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/** 
 * @author leonardo.alves
 **/

@Entity
public class Genero implements Serializable {
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_GENERO")
    @SequenceGenerator(name = "SEQ_GENERO", sequenceName = "SEQ_GENERO", allocationSize = 1)
    @Basic(optional = false)
    private Long   id;  
    
    @Basic(optional = false)
    private String descricao;
    
    @OneToMany(mappedBy = "genero", targetEntity = Video.class)
    private List<Video> videos;    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    
    
}

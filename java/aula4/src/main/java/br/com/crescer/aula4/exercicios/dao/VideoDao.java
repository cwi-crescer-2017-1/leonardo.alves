
package br.com.crescer.aula4.exercicios.dao;

import br.com.crescer.aula4.exercicios.pojo.Video;

/** 
 * @author leonardo.alves
 **/
public final class VideoDao extends GenericDAO<Video, Long> {
    
    public VideoDao () {
        super(Video.class);
    } 
    
}

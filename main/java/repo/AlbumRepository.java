package repo;

import entity.Albums;
import entity.Artists;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AlbumRepository {
    EntityManager em;

    public AlbumRepository(EntityManager em) {
        this.em = em;
    }
    public void create(Albums album){
        em.merge(album);
    }
    public Albums findById(int id){
        TypedQuery<Albums> q = em.createQuery("SELECT a FROM Albums a WHERE a.id = :id", Albums.class);
        q.setParameter("id", id);
        return q.getSingleResult();
    }
    public List<Albums> findByName(String name){
        return em.createNamedQuery("findByName").setParameter("name",name).getResultList();
    }
    public List<Artists> findByArtist(Artists artist){
        return em.createNamedQuery("findByArtist").setParameter("id",artist.getId()).getResultList();
    }
}

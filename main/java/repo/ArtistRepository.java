package repo;

import entity.Artists;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ArtistRepository {
    EntityManager em;

    public ArtistRepository(EntityManager em) {
        this.em = em;
    }
    public void create(Artists artist){
        em.merge(artist);
    }
    public Artists findById(int id){
        TypedQuery<Artists> q = em.createQuery("SELECT a FROM Artists a WHERE a.id = :id", Artists.class);
        q.setParameter("id", id);
        return q.getSingleResult();
    }
    public List<Artists> findByName(String name){
        return em.createNamedQuery("findByName").setParameter("name",name).getResultList();
    }
}

package App;


import util.PersistenceUtil;

import javax.persistence.EntityManager;

public class AlbumManager
{
    public static void main( String[] args )
    {
        PersistenceUtil PU=PersistenceUtil.getInstance();
        EntityManager em=PU.emf.createEntityManager();
        em.getTransaction().begin();
        em.close();
        PU.emf.close();
    }
}

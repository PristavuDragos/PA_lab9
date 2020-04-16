package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
    private static PersistenceUtil PU=null;
    public EntityManagerFactory emf=null;
    private PersistenceUtil()
    {
        emf= Persistence.createEntityManagerFactory("MusicAlbumsPU");
    }
    public static PersistenceUtil getInstance()
    {
        if (PU == null)
            PU = new PersistenceUtil();

        return PU;
    }
}

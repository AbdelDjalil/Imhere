/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imhereSession;

import imhereEntity.Utilisateur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Djalil
 */
@Stateless
public class UtilisateurFacade extends AbstractFacade<Utilisateur> implements UtilisateurFacadeLocal {
    @PersistenceContext(unitName = "ImHereAppLoc-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public UtilisateurFacade() {
        super(Utilisateur.class);
    }
    
    public void Auth (int i) {
        
        UtilisateurFacadeLocal ufl = new UtilisateurFacade ();
        Utilisateur ut = new Utilisateur (i);
        ufl.create(ut);
        
    }
}

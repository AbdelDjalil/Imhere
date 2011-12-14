/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imhereSession;

import imhereEntity.Utilisateur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Djalil
 */
@Local
public interface UtilisateurFacadeLocal {

    void create(Utilisateur utilisateur);

    void edit(Utilisateur utilisateur);

    void remove(Utilisateur utilisateur);

    Utilisateur find(Object id);

    List<Utilisateur> findAll();

    List<Utilisateur> findRange(int[] range);

    int count();
    
    void Auth (int i, String nom , String mdp);
    
    public void effacer (Utilisateur ut);
    
}

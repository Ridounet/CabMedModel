package cabmed.dao;

import cabmed.model.Specialisation;
import cabmed.ressources.Constantes;
import java.util.LinkedList;
import java.util.List;

public class SpecialisationDAO implements ISpecialisationDAO{

    @Override
    public List<Specialisation> getListSpecialisation() {
        String sql = "SELECT s FROM Specialisation s WHERE s.visible = " + Constantes.VISIBLE;
        List<Specialisation> listSpecialisation = new LinkedList<>();
        try {
            return DAOMySQL.getEntityManager().createQuery(sql).getResultList();
        } catch (Exception ex) {
            return listSpecialisation;
        }
    }
    
}

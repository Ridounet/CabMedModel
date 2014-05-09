package cabmed.dao;

import cabmed.model.Cp;
import java.util.ArrayList;
import java.util.List;

public class CpDAO implements ICpDAO{

    @Override
    public List<Cp> getListCp() {
        try {
            return DAOMySQL.getEntityManager().createQuery("SELECT c FROM Cp c").getResultList();
        } catch(Exception e) {
            return new ArrayList<>();
        }
    }
    
}

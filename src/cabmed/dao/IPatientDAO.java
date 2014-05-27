package cabmed.dao;

import cabmed.model.Patient;
import cabmed.model.Rdv;
import java.util.List;

public interface IPatientDAO {
    public boolean savePatient(Patient patient);
    public Patient getPatientByRegistreNat(String registreNat);
    public List<Rdv> getRdvPatient(Patient patient);
    public boolean updateRdv(Rdv rdv);
}

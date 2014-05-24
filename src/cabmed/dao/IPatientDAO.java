package cabmed.dao;

import cabmed.model.Patient;

public interface IPatientDAO {
    public boolean savePatient(Patient patient);
    public Patient getPatientByRegistreNat(String registreNat);
}

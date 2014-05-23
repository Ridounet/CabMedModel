package cabmed.ressources;

import be.belgium.eid.exceptions.EIDException;
import cabmed.model.Patient;
import cabmed.model.Personne;

public class Main {

    public static void main(String[] args) throws EIDException {
        Personne p = EID.getData();
        System.out.println(p.getRegistreNat());
    }
}

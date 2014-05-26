package cabmed.ressources;

import be.belgium.eid.exceptions.EIDException;
import cabmed.model.Patient;

public class Main {

    public static void main(String[] args) throws EIDException {
        Patient p = EID.getData();
        System.out.println(p.getRegistreNat());
    }
}

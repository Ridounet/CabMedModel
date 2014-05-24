package cabmed.ressources;

import cabmed.model.Adresse;
import cabmed.model.Patient;
import cabmed.model.Cp;
import be.belgium.eid.eidlib.BeID;
import be.belgium.eid.exceptions.EIDException;
import cabmed.model.Sexe;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EID {
    
    public static void main(String[] args) {
        try {
            System.out.println(getData().getDateNaissance());
        } catch (EIDException ex) {
            Logger.getLogger(EID.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Patient getData() throws EIDException {
        
//        BeID eID = new BeID(true);
//        System.out.println(eID.getIDData().toString());
//        return null;
        BeID eID = new BeID(true);
        String birthdate;
        String eid = (eID.getIDData().toString().replaceAll(": ", ":"));
        Patient p = new Patient();
        //------------------------------------------
        //-            Infos Générales             -
        //------------------------------------------
        StringTokenizer st1 = new StringTokenizer(eid, "\n");
        StringTokenizer st2;

        st1.nextToken();
        st1.nextToken();
        st1.nextToken();
        st1.nextToken();
        st1.nextToken();
        
        st2 = new StringTokenizer(st1.nextToken(), ":");
        st2.nextToken();
        p.setRegistreNat(st2.nextToken());

        st2 = new StringTokenizer(st1.nextToken(), ":");
        st2.nextToken();
        p.setNom(st2.nextToken());

        st2 = new StringTokenizer(st1.nextToken(), ":");
        st2.nextToken();
        p.setPrenom(st2.nextToken());

        st1.nextToken();
        st1.nextToken();
        st1.nextToken();

        st2 = new StringTokenizer(st1.nextToken(), ":");
        st2.nextToken();
        birthdate = st2.nextToken() + ":" + st2.nextToken() + ":" + st2.nextToken();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", Locale.US);
            //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date d = sdf.parse(birthdate);
            //sdf.applyPattern("dd-MM-yyyy");
            p.setDateNaissance(d);
        } catch (ParseException ex) {
            Logger.getLogger(EID.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        st2 = new StringTokenizer(st1.nextToken(), ":");
        st2.nextToken();
        if ("M".equals((String)st2.nextToken()))
            p.setSexe(Sexe.HOMME);
        else
            p.setSexe(Sexe.FEMME);
        
        //-------------------------------------------------
        //-                   Adresse                     -
        //-------------------------------------------------
        eid = (eID.getIDAddress().toString().replaceAll(": ", ":"));
        st1 = new StringTokenizer(eid, "\n");
        Adresse a = new Adresse();
        Cp c = new Cp();
        
        st2 = new StringTokenizer(st1.nextToken(), ":");
        st2.nextToken();
        a.setAdresse(st2.nextToken());
        
        st2 = new StringTokenizer(st1.nextToken(), ":");
        st2.nextToken();
        c.setCodePostal(Integer.parseInt(st2.nextToken()));
        
        st2 = new StringTokenizer(st1.nextToken(), ":");
        st2.nextToken();
        c.setNom(st2.nextToken());
        
        a.setCp(c);
        p.setAdresse(a);
        
        return p;
    }

}

package cabmed.admin.main;

import cabmed.ressources.Observer;
import java.util.List;
import cabmed.dao.*;
import java.util.ArrayList;

public class Facade implements IPersonnelDAO, IMedecinDAO, ISpecialisationDAO{
    private static final List<Observer> listObservers = new ArrayList<>();
    
    private static void notifyObservers() {
        for (Observer ob : listObservers) {
            ob.update();
        }
    }
    
    public static void addObserver(Observer o) {
        listObservers.add(o);
    }
    
    
    
}

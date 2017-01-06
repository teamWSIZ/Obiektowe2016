package objective_tools;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class Baza {
    Map<Integer,String> dane;  //good: dependencja na interfejs nie implementacje

}

//chcemy mape ktora nie pozwala wrzucic wiecej niz 1000 elementow,
//a fakty zapisu audytuje do pliku (loga admina)
class FiniteSizeAuditedMap extends HashMap<Integer,String> {

    @Override
    public String put(Integer key, String value) {
        String res = super.put(key, value);
        if (size()>2) {
            //jak wywalac??
            int minKey = Integer.MAX_VALUE;
            for(Integer kkey : keySet()) {
                minKey = Math.min(minKey, kkey);
            }
            remove(minKey);
            System.out.println("Removed key: " + minKey);
        }
        return res;
    }
}


interface DAO {
    void insert(String entry);
    void update(Integer key, String entry);
    String get(Integer key);
    Iterable<String> findAll(); //good: dep na interfejs, ale Iterable, Collection, List ?
}

class DAOImpl implements DAO {
    Baza b;

    public DAOImpl() {
        b = new Baza(); //domyslny konstruktor -- OK -- konstruujemy baze sami
    }

    public DAOImpl(Baza b) {
        this.b = b;  //ktos nam daje baze (np. zapieta z H2, lub gdzies z sieci przez REST)
    }

    ///////////////////////
    // do napisania @Overridy wszystkich metod
    @Override
    public void insert(String entry) {

    }

    @Override
    public void update(Integer key, String entry) {

    }

    @Override
    public String get(Integer key) {
        return null;
    }

    @Override
    public Iterable<String> findAll() {
        return null;
    }
}



public class Start {
    public static void main(String[] args) {
        Map<Integer, String> m = new FiniteSizeAuditedMap();
        m.put(1, "aa");
        m.put(2, "bb");
        m.put(5, "cc");
        m.put(10, "dd");
    }
}

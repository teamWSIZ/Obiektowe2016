package objective_tools;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

class Baza {
    Map<Integer,String> dane;  //good: dependencja na interfejs nie implementacje

}

//chcemy mape ktora nie pozwala wrzucic wiecej niz 1000 elementow,
//a fakty zapisu audytuje do pliku (loga admina)
class FiniteSizeMap extends HashMap<Integer,String> {

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

class AuditingMap extends HashMap<Integer,String> {
    String logFileName = "fun_system.log";

    private void writeToLog(String reason) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(logFileName, true)));
            out.println("[" + new Date() + "] " + reason);
            out.close();
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
            System.out.println(e);
        }
    }

    @Override
    public String put(Integer key, String value) {
        String result =  super.put(key, value);
        writeToLog(" Inserted at [" + key + "] value [" + value + "]");
        return result;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends String> m) {
        throw new RuntimeException("Operation not implemented");
    }

    @Override
    public void clear() {
        super.clear();
        writeToLog("Map cleared");
    }

    @Override
    public boolean remove(Object key, Object value) {
        boolean success =  super.remove(key, value);
        writeToLog("Removed at [" + key + "]  value [" + value + "]");
        return success;
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

    private static void writeIt() {

    }


    public static void main(String[] args) {
//        long st = System.currentTimeMillis();

//        Map<Integer, String> m = new FiniteSizeMap();
//        m.put(1, "aa");
//        m.put(2, "bb");
//        m.put(5, "cc");
//        m.put(10, "dd");
//
//        long end = System.currentTimeMillis();
//
//        System.out.println((end-st) + " [ms]");
//        writeIt();

        AuditingMap map = new AuditingMap();
        map.put(12, "aa");
        map.put(13, "bb");
        map.clear();
        

    }
}

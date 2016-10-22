package hallo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created on 15.10.16, at 07:29
 */
public class DbStart {
    public static void main(String[] args) throws Exception {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/nowabaza", "sa", "");

        //dodanie rzędu do tabeli `abc`
        PreparedStatement st1 = conn.prepareStatement("insert into abc (name) values (?)");
        st1.setString(1, "AbcX");
        st1.executeUpdate();


        //Sprawdzenie wszystkich danych z tabeli `abc`
        PreparedStatement st = conn.prepareStatement("select * from abc");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            String name = rs.getString("name");
            System.out.println(name);
        }




        // tutaj kod działający na bazie
        conn.close();

    }
}

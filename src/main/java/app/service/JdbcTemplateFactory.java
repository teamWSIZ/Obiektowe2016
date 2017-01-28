package app.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Zadanie tej klasy to dostarczanie jednej (pojedynczej w systemie)
 * instancji kasy {@link JdbcTemplate} (do wykonywania operacji na bazie)
 * do jej klientów (najczęściej obiektów typu DAO).
 *
 */
public class JdbcTemplateFactory {
    private static JdbcTemplate template = null;

    public static JdbcTemplate getTemplate() {
        if (template==null) {
//            DriverManagerDataSource dataSource =
//                    new DriverManagerDataSource(
//                    "jdbc:h2:tcp://localhost/~/nowabaza",
//                    "sa",
//                    ""
//            );
            DriverManagerDataSource dataSource =
                    new DriverManagerDataSource(
                    "jdbc:postgresql://10.10.22.255:5432/student",
                    "student",
                    "wsiz#1234"
            );

            template = new JdbcTemplate(dataSource);
        }
        return template;
    }

}

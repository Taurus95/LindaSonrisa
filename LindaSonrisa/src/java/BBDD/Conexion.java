package BBDD;

import java.security.Principal;
import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {  
    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Principal.class);
    public static Connection getConexion() {
        Connection connection = null;
        try {
           String driverClassName = "oracle.jdbc.driver.OracleDriver";
           String driverUrl="jdbc:oracle:thin:@localhost:1521:XE";
           Class.forName(driverClassName);
           connection = DriverManager.getConnection(
                   driverUrl, "prueba","prueba");
        }catch (Exception e) {
            log.error("Error en conexcion: "+e.getMessage());
        }
        return connection;
    }
}

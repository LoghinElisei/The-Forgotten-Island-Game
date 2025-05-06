package PaooGame.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private String url ;
    private String user ;
    private String password ;
    private static DatabaseManager instance;
    protected Connection connection = null;

    private DatabaseManager()
    {
        url = "jdbc:mysql://root:aqDFFRKlccXbZwWTnuuAsLrUTVpeSxtn@crossover.proxy.rlwy.net:50650/railway";
        user = "root";
        password = "aqDFFRKlccXbZwWTnuuAsLrUTVpeSxtn";
    }

    public static DatabaseManager getInstance() {
        if(instance == null){
            instance  = new DatabaseManager();
        }
        return instance;
    }

    public Connection connect()
    {
        if(connection != null){
            return connection;
        }
        try {
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Conexiune reușită la baza de date !");


            }
        } catch (SQLException e) {
            System.out.println("Eroare la conectare: " + e.getMessage());
        }
        finally {

            return connection;
        }
    }

    public void disconnect(){
        try{
            if(connection != null){
                connection.close();
                System.out.println("Disconectat de la baza de date");
            }
        }catch (SQLException e )
        {
            System.out.println("Eroare la inchiderea bazei de date");
        }
    }
}

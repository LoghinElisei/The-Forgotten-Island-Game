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
    private Connection connection = null;

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
        try {
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Conexiune reușită la baza de date !");

//                String query = "CREATE TABLE IF NOT EXISTS conexiuni_test (" +
//                        "id INT PRIMARY KEY AUTO_INCREMENT," +
//                        "timestamp DATETIME DEFAULT CURRENT_TIMESTAMP)";
//                Statement stmt = connection.createStatement();
//                stmt.executeUpdate(query);
//                System.out.println("Tabel de test creat.");
//
//                String insert = "INSERT INTO conexiuni_test () VALUES ()";
//                stmt.executeUpdate(insert);
//                System.out.println("Inserare efectuată.");

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

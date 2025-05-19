package PaooGame.Database;

<<<<<<< HEAD

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
        private static DatabaseManager instance;
        private final String url ;
        private String user;
        private String password;
        Connection connection = null;

        public static DatabaseManager getInstance() {
                if(instance == null){
                        instance  = new DatabaseManager();
                }
                return instance;
        }

        private DatabaseManager()
        {
              url = "mysql://root:aqDFFRKlccXbZwWTnuuAsLrUTVpeSxtn@crossover.proxy.rlwy.net:50650/railway";
              user = "root";
              password = "aqDFFRKlccXbZwWTnuuAsLrUTVpeSxtn";

        }
        public int connect(){

                try{
                        connection = DriverManager.getConnection(url,user,password);

                }
                catch (SQLException e)
                {
                        System.out.println("No internet connection");
                        return -1;
                }

                return 0;
        }
=======
import java.sql.*;

public class DatabaseManager {
    private String url ;
    private String user ;
    private String password ;
    private String sqliteUrl;
    private static DatabaseManager instance;
    protected Connection connection = null;
    protected boolean isOracleDatabase = true;

    private DatabaseManager()
    {
//        url = "jdbc:mysql://root:aqDFFRKlccXbZwWTnuuAsLrUTVpeSxtn@crossover.proxy.rlwy.net:50650/railway";
//        user = "root";
//        password = "aqDFFRKlccXbZwWTnuuAsLrUTVpeSxtn";

        url = "jdbc:oracle:thin:@adbj_high?TNS_ADMIN=res/database/Wallet";
        user = "admin";
        password="Abcdefg123**";
        sqliteUrl = "jdbc:sqlite:res/database/localDatabase.db";
    }

    public static DatabaseManager getInstance() {
        if(instance == null){
            instance  = new DatabaseManager();
        }
        return instance;
    }

    public Connection connect()
    {
        System.out.println("*********");
        if(connection != null){ //connect to oracle database
            return connection;
        }
        try {
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {  //oracle
                System.out.println("Conexiune reușită la baza de date Oracle!");
            }
        }catch (SQLException e) {

            System.out.println("Eroare la conectare baza de date Oracle: " + e.getMessage());
            isOracleDatabase = false;

            try{// local database
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection(sqliteUrl);
                if(connection!=null)
                {
                    System.out.println("Conexiune reusita la baza de date locala!");
                }
            }
            catch (SQLException err)
            {
                System.out.println("Eroare la conectarea la baza de date locala: " + err.getMessage());
            }
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
>>>>>>> master
}

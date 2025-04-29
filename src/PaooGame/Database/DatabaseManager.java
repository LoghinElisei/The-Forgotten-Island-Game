package PaooGame.Database;


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
}

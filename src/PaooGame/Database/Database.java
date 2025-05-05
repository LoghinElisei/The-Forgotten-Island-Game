package PaooGame.Database;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Database {
    public DatabaseManager db;
    private static ExecutorService executor;

    public Database(){
        this.db = DatabaseManager.getInstance();

        executor = Executors.newFixedThreadPool(2);
    }
    public boolean connect(){

//        new Thread(() -> {
//            db.connect();}).start();
//        runAsync( () -> db.connect());
        if(db.connection != null){
            System.out.println("Connected already to the database !!!");
            return true;
        }
        return (db.connect() != null);

    }
    public void disconnect(){
//        db.disconnect();
        System.out.println("Disconnecting...");
        runAsync( () ->db.disconnect());
    }

    public void runAsync(Runnable task){
        executor.submit(task);
    }
    public void shutdown(){
        executor.shutdown();
    }

    public void loadMap1(){

    }

    public void deleteMap() {


    }
}

package PaooGame.Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Database {
    public DatabaseManager db;

    public Database(){
        this.db = DatabaseManager.getInstance();
    }
    public boolean connect(){

        if(db.connection != null){
            System.out.println("Connected already to the database !!!");
            return true;
        }
        return (db.connect() != null);

    }

    public boolean isConnected(){
        return (db.connection != null);
    }
    public void disconnect(){
//        db.disconnect();
        System.out.println("Disconnecting...");
        db.disconnect();
    }

    public int[][] loadMap1(int width , int height){
        String path = "res/maps/thematic/map1.txt";

        int [][] map = new int[height][width];
        int [][] tiles=new int[width][height];
        String line;
        int row = 0;


        try {
            String sql =null;
            Statement stm = null;
//            sql = "DROP TABLE MAP1";
//
//            stm = db.connection.createStatement();
//            stm.executeUpdate(sql);

            sql = "CREATE TABLE MAP1  " +
                    "(ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT," +
                    "LINIE INT NOT NULL,"
                    + "COLOANA INT NOT NULL," +
                    "VALUE INT NOT NULL)";

            stm = db.connection.createStatement();
            int delay = 50000;
            while((delay--) !=0);

            stm.executeUpdate(sql);
            stm.close();
        }
        catch (SQLException e){
            System.out.println("Error loading MAP1 -> "+e.getMessage());
        }
        try {
//            System.out.println("Trying to open file with FileReader...");
            FileReader fr = new FileReader(path);
//            System.out.println("FileReader opened successfully.");
            BufferedReader reader = new BufferedReader(fr);

            while((line = reader.readLine()) != null && row <height){
                line = line.trim(); //elimina spatiile de la inceput si sfarsit
                if(line.isEmpty()) continue;

                String [] element = line.split("\\s+");
                for(int i=0;i<width;i++)
                {
                    map[row][i] = Integer.parseInt(element[i]);
                }

                row++;
            }
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    tiles[j][i] = map[i][j];
                }
            }

            reader.close();
        }
        catch (IOException e)
        {
            System.out.println("Text file ThematicMap couldn't be opened");
        }

        try{
            for(int i=0;i<map.length;i++){
                for(int j=0;j<map[i].length;j++){
                    String sql = "INSERT INTO MAP1 (LINIE,COLOANA,VALUE) VALUES ("+i+","+j+","+map[i][j]+")";
                    Statement stm = null;
                    stm = db.connection.createStatement();
                    stm.executeUpdate(sql);
                    stm.close();
                }
            }
        }catch (SQLException e){
            System.out.println("Error loading MAP1 -> "+e.getMessage());
        }

        return map;
    }

    public int[][] downloadMap1(){
        try{
            PreparedStatement stmt = null;
            String query = "SELECT VALUE FROM MAP1 WHERE LINIE = ? AND COLOANA = ?" ;
            stmt = db.connection.prepareStatement(query);

        }catch (SQLException e){

        }
    }
    public void deleteMap() {


    }
}

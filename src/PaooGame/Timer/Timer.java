package PaooGame.Timer;


public class Timer {
    private static Timer instance;

    private long startTime;
    private long elapsedTime;
    private boolean running;

    private Timer(){
        startTime =0 ;
        elapsedTime =0;
        running =false;
    }

    public static Timer getInstance(){
        if(instance == null){
            instance = new Timer();
        }
        return instance;
    }

    public void start()
    {
        if(!running)
        {
            startTime = System.nanoTime();
            running = true;
        }
    }

    public void stop()
    {
        if(running)
        {
            elapsedTime += System.nanoTime() - startTime;
            running = false;
        }
    }

    public double getElapsedTime(){
        if(running)
        {
            return (System.nanoTime() - startTime + elapsedTime) / 1_000_000_000.0; //seconds
        }else {
            return elapsedTime / 1_000_000_000.0;
        }
    }

    public void reset(){
        elapsedTime = 0;
        if(running)
        {
            startTime = System.nanoTime();
        }
    }

}

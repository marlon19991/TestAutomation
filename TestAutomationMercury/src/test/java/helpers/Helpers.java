package helpers;

public class Helpers {
    public void sleepSeconds (int seconds){ //los parametros que le voy a pasar al objeto, conctructor
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

package observer;

public class MonitorVisual implements Observador {
    public void actualizar (String info){
        System.out.println("Monitor visual: "+info);
    }
}

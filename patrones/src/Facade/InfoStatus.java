package Facade;


public class InfoStatus {
    // Datos miembro asociados a los subsistemas controlados
    private GestorBD gestorBD;
    private GestorRed gestorRed;
    private ControlAcceso gestorControl;

    // Constructor de la clase
    public InfoStatus(GestorBD bd, GestorRed red, ControlAcceso control){
        gestorBD = bd;
        gestorRed = red;
        gestorControl = control;
    }

    // Metodo para obtener informacion
    public void getInfo(){
        // control BD
        gestorBD.start();
        gestorBD.login();
        gestorBD.getData();
        gestorBD.close();

        // control de red
        gestorRed.initService();
        gestorRed.getStatus();
        gestorRed.stopService();

        // control de acceso
        gestorControl.login();
        gestorControl.getLog();
        gestorControl.logOut();
    }

    public static void main(String args[]){
        GestorBD gestorBD = new GestorBD();
        GestorRed gestorRed = new GestorRed();
        ControlAcceso control = new ControlAcceso();

        InfoStatus fachada = new InfoStatus(gestorBD,gestorRed,control);

        // obtengo la informacion
        fachada.getInfo();
    }
}

package state;

public interface Estado {
    // metodos que indican los eventos posibles del sistema
    default public String gestionarPeticion(){
        return "no puede gestionarse peticion";
    }
    default public String chequearPeticion(){
        return "no puede chequearse peticion";
    }
    default public String aceptarPeticion(){
        return "no puede aeptarse peticion";
    }
    default public String ejecutarPeticion(){
        return "no puede ejecutarse peticion";
    }
}

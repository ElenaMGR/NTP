package listado;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListadoEmpleados {

    /**
     * Contador del numero de empleados
     */
    int numeroEmpleados;

    /**
     * Dato miembro para almacenar a los empleados tal y como se encuentran
     * en el archivo de datos.txt
     */
    private List<Empleado> listadoArchivo;

    /**
    * Dato miembro para almacenar a los empleados como mapa con pares
    * (una vez reparados los datos leidos del archivo)
    * <dni - empleado>
    */
    private Map<String, Empleado> listado;





    /**
     * Constructor de la clase
     *
     * @param nombreArchivo
     * @throws IOException
     */
    public ListadoEmpleados(String nombreArchivo){
        try {
            // Se leen las lineas del archivo
            Stream<String> lineas = Files.lines(Paths.get(nombreArchivo));

            // Se procesan las lineas del archivo

            // Se define el patron para las comas que hacen de separadores
            Pattern pattern = Pattern.compile(",");

            // Se procesa la linea
            listadoArchivo = new ArrayList<>();
            lineas.forEach(linea -> {
                List<String> infos = pattern.splitAsStream(linea).collect(Collectors.toList());
                listadoArchivo.add(new Empleado(infos.get(0), infos.get(1), infos.get(2), infos.get(3)));

            });

            // se da valor a numero empleados
            numeroEmpleados=listadoArchivo.size();
            System.out.println("Numero de empleados: "+numeroEmpleados);

        }catch(IOException e){
            System.out.println("Error reading file: "+nombreArchivo);
            System.exit(0);
        }
    }

    /**
     * Método que devuelve el número de empleados
     */
    public int obtenerNumeroEmpleadosArchivo(){
        return numeroEmpleados;
    }


    /**
     * Método que devuelve true si hay dnis repetidos
     */
    public boolean hayDnisRepetidosArchivo(){
        AtomicBoolean repetidos = new AtomicBoolean(false);
        //Agrupamiento de los empleados por dni
        Map<String, List<Empleado>> agrupadosDni =
                listadoArchivo.stream().collect(Collectors.groupingBy(Empleado::obtenerDni));

        agrupadosDni.forEach(
                (dni, asignados)->{
                    if (asignados.size() > 1) {
                        //System.out.println(dni + " : " + asignados.size());
                        repetidos.set(true);
                    }
                }
        );

        return repetidos.get();
    }

    /**
     * Método que devuelve el número de empleados con dnis repetidos
     */
    public int contarEmpleadosDnisRepetidos(){
        AtomicInteger num = new AtomicInteger();
        //Agrupamiento de los empleados por dni contando los empleados con dni repetidos
        TreeMap<String, Long> contadores =
                listadoArchivo.stream().collect(Collectors.groupingBy(
                        Empleado::obtenerDni, TreeMap::new, Collectors.counting()));

        contadores.forEach((dni,cont)->{
            if (cont > 1) {
                //System.out.println(dni + " : " + cont);
                num.addAndGet(cont.intValue());
                //System.out.println(num);
            }
        });

        return num.get();
    }


    /**
     * Método que devuelve la obtención de datos sobre empleados con dnis repetidos
     */
    public Map<String, List<Empleado>> obtenerDnisRepetidosArchivo(){
        //Agrupamiento de los empleados por dni
        Map<String, List<Empleado>> agrupadosDni =
                listadoArchivo.stream().collect(Collectors.groupingBy(Empleado::obtenerDni));

        Map<String, List<Empleado>> dnisRepetidos = new HashMap<>();

        agrupadosDni.forEach(
                (dni, asignados)->{
                    if (asignados.size() > 1) {
                        dnisRepetidos.put(dni,asignados);
                    }
                }
        );

        return dnisRepetidos;
    }

    /**
     * Este métdodo se encarga de arreglar los dnis repetidos
     * @param listaRepeticion lista de empleados con dnis repetidos
     */
    public void repararDnisRepetidos(Map<String, List<Empleado>> listaRepeticion){


        listaRepeticion.forEach(
                (dni, asignados) ->{
                    listadoArchivo.forEach( campo -> {
                        if (campo.obtenerDni()==dni){
                            campo.asignarDniAleatorio();
                        }
                    });
                }
        );

        if (hayDnisRepetidosArchivo()){
            repararDnisRepetidos(obtenerDnisRepetidosArchivo());
        }

    }

    /**
     *
     * @return true si hay correos repetidos
     */
    public boolean hayCorreosRepetidosArchivo(){
        AtomicBoolean repetidos = new AtomicBoolean(false);

        //Agrupamiento de los empleados por correo
        Map<String, List<Empleado>> agrupadosCorreo =
                listadoArchivo.stream().collect(Collectors.groupingBy(Empleado::obtenerCorreo));

        agrupadosCorreo.forEach(
                (correo, asignados) ->{
                    if (asignados.size() > 1) {
                        //System.out.println(dni + " : " + asignados.size());
                        repetidos.set(true);
                    }
                }
        );

        return repetidos.get();
    }

    /**
     *
     * @return datos de los empleados con problemas en el correo
     */
    public Map<String, List<Empleado>> obtenerCorreosRepetidosArchivo(){

    }
}

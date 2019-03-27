package listado;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListadoEmpleados {

    /**
     * Contador del numero de empleados
     */
    int numeroEmpleados;

    /**
     * Dato miembro para almacenar la lista de empleados ya generados
     */
    private List<Empleado> empleados;

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
            empleados = lineas.map(linea -> new Empleado(linea)).
                    collect(Collectors.toList());

            // se da valor a numero empleados
            numeroEmpleados=empleados.size();
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

    public boolean hayDnisRepetidosArchivo(){
        AtomicBoolean repetidos = new AtomicBoolean(false);
        //Agrupamiento de los empleados por dni
        Map<String, List<Empleado>> agrupadosDni =
                empleados.stream().collect(Collectors.groupingBy(Empleado::obtenerDni));

        /*TreeMap<String, Long> contadores =
                empleados.stream().collect(Collectors.groupingBy(
                        Empleado::obtenerDni, TreeMap::new, Collectors.counting()));

        contadores.forEach((dni,cont)->{
            if (cont > 1)
                System.out.println(dni + " : " + cont);
        });*/



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
}

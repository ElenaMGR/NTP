package listado;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
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
}

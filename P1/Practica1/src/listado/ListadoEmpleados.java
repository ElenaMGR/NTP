package listado;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
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
     * patrón usado para trocear la información de una cadena considerando como
     * separador el espacio en blanco
     */
    private static Pattern patronEspacios=Pattern.compile("\\s+");



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
     * Método que comprueba si hay elementos repetidos
     * @param agrupados elemento por el que agrupar
     * @return true si hay elementos repetidos
     */
    public boolean hayRepetidosArchivo(Map<String, List<Empleado>> agrupados){
        AtomicBoolean repetidos = new AtomicBoolean(false);

        agrupados.forEach(
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
     * Método que devuelve true si hay dnis repetidos
     * @return true si hay dni repetidos
     */
    public boolean hayDnisRepetidosArchivo(){
        //Agrupamiento de los empleados por dni
        Map<String, List<Empleado>> agrupadosDni =
                listadoArchivo.stream().collect(Collectors.groupingBy(Empleado::obtenerDni));

        return hayRepetidosArchivo(agrupadosDni);
    }

    /**
     *
     * @return true si hay correos repetidos
     */
    public boolean hayCorreosRepetidosArchivo(){
        //Agrupamiento de los empleados por correo
        Map<String, List<Empleado>> agrupadosCorreo =
                listadoArchivo.stream().collect(Collectors.groupingBy(Empleado::obtenerCorreo));

        return hayRepetidosArchivo(agrupadosCorreo);
    }

    public int contarElementosRepetidos(TreeMap<String, Long> contadores){
        AtomicInteger num = new AtomicInteger();

        contadores.forEach((elemento,cont)->{
            if (cont > 1) {
                //System.out.println(dni + " : " + cont);
                num.addAndGet(cont.intValue());
                //System.out.println(num);
            }
        });

        return num.get();
    }

    /**
     * Método que devuelve el número de empleados con dnis repetidos
     */
    public int contarEmpleadosDnisRepetidos(){
        TreeMap<String, Long> contadores =
                listadoArchivo.stream().collect(Collectors.groupingBy(
                        Empleado::obtenerDni, TreeMap::new, Collectors.counting()));

        return contarElementosRepetidos(contadores);
    }

    /**
     * Método que cuenta los empleados con correo repetido
     * @return número de empleados con correo repetido
     */
    public int contarEmpleadosCorreosRepetidos(){
        TreeMap<String, Long> contadores =
                listadoArchivo.stream().collect(Collectors.groupingBy(
                        Empleado::obtenerCorreo, TreeMap::new, Collectors.counting()));

        return contarElementosRepetidos(contadores);
    }


    public Map<String, List<Empleado>> obtenerElementosRepetidosArchivo(Map<String, List<Empleado>> agrupados){
        Map<String, List<Empleado>> repetidos = new HashMap<>();

        agrupados.forEach(
                (elemento, asignados)->{
                    if (asignados.size() > 1) {
                        repetidos.put(elemento,asignados);
                    }
                }
        );

        return repetidos;
    }
    /**
     * Método que devuelve la obtención de datos sobre empleados con dnis repetidos
     */
    public Map<String, List<Empleado>> obtenerDnisRepetidosArchivo(){
        //Agrupamiento de los empleados por dni
        Map<String, List<Empleado>> agrupadosDni =
                listadoArchivo.stream().collect(Collectors.groupingBy(Empleado::obtenerDni));

        return obtenerElementosRepetidosArchivo(agrupadosDni);
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
     * @return datos de los empleados con problemas en el correo
     */
    public Map<String, List<Empleado>> obtenerCorreosRepetidosArchivo(){
        //Agrupamiento de los empleados por dni
        Map<String, List<Empleado>> agrupadosCorreo =
                listadoArchivo.stream().collect(Collectors.groupingBy(Empleado::obtenerCorreo));

        return obtenerElementosRepetidosArchivo(agrupadosCorreo);
    }

    /**
     * Método que repara los correos repetidos
     * @param listaRepeticiones listado de empleados con correos repetidos
     */
    public void repararCorreosRepetidos(Map<String, List<Empleado>> listaRepeticiones){
        listaRepeticiones.forEach(
                (correo, asignados) ->{
                    listadoArchivo.forEach( campo -> {
                        if (campo.obtenerCorreo()==correo){
                            campo.generarCorreoCompleto();
                        }
                    });
                }
        );

        if (hayCorreosRepetidosArchivo()){
            repararCorreosRepetidos(obtenerCorreosRepetidosArchivo());
        }
    }

    /**
     * Una vez los datos estan correctamente se almacenan en listado
     */
    public void validarListaArchivo(){
        listado = listadoArchivo.stream().collect(Collectors.toMap(Empleado::obtenerDni, empleado -> empleado));
    }


    /**
     * @param cadena nombre del sector a procesar
     * @return Sector
     */
    private Sector procesarNombreSector(String cadena){
        // se trocea la linea del archivo usando el patrón basado en la separación mediante espacios
        //en blanco
        List<String> infos = patronEspacios.splitAsStream(cadena).
                collect(Collectors.toList());

        // se crea una condición para hacer el filtrado de todos los posibles valores del enumerado
        Predicate<Sector> condicion = sector ->
                (sector.name().equals(infos.get(0)));

        // se usa esta condición para el filtrado y se devuelve el sector
        return Arrays.stream(Sector.values()).
                filter(condicion).
                findFirst().get();
    }

    /**
     *
     * @param datosAsignacion dni del empleado
     * @param sector sector al que pertenece el empleado
     * @return
     */
    private boolean procesarAsignacionSector(String datosAsignacion, Sector sector){
        List<String> infos = patronEspacios.splitAsStream(datosAsignacion).
                collect(Collectors.toList());

        // se localiza el empleado asociado a dicho dni
        Empleado empleado = listado.get(infos.get(0));

        // si la referencia es válida (hay realmente un empleado con dicho dni), se le asigna el sector
        //y se devuelve true. En caso contrario se devuelve false
        if (empleado!=null){
            empleado.asignarSector(sector);
            return true;
        }else{
            return false;
        }
    }


    /**
     *
     * @param nombreArchivo archivo de datos del que obtener los sectores
     * @return número de errores obtenidos como consecuencia de la asignación
     * @throws IOException
     */
    public long cargarArchivoAsignacionSector(String nombreArchivo) throws IOException{
        List<String> lineas = Files.lines(Paths.get(nombreArchivo)).
                collect(Collectors.toList());
        Sector sector = procesarNombreSector(lineas.get(0));

        long errores=lineas.stream().skip(2).
                map(linea -> procesarAsignacionSector(linea, sector)).
                filter(flag -> flag == false).count();

        return errores;
    }

    /**
     * @param cadena nombre del sector a procesar
     * @return Ruta
     */
    private Ruta procesarNombreRuta(String cadena){
        // se trocea la linea del archivo usando el patrón basado en la separación mediante espacios
        //en blanco
        List<String> infos = patronEspacios.splitAsStream(cadena).
                collect(Collectors.toList());

        // se crea una condición para hacer el filtrado de todos los posibles valores del enumerado
        Predicate<Ruta> condicion = ruta ->
                (ruta.name().equals(infos.get(0)));

        // se usa esta condición para el filtrado y se devuelve el sector
        return Arrays.stream(Ruta.values()).
                filter(condicion).
                findFirst().get();
    }

    /**
     *
     * @param datosAsignacion dni del empleado
     * @param ruta ruta al que pertenece el empleado
     * @return
     */
    private boolean procesarAsignacionRuta(String datosAsignacion, Ruta ruta){
        List<String> infos = patronEspacios.splitAsStream(datosAsignacion).
                collect(Collectors.toList());

        // se localiza el empleado asociado a dicho dni
        Empleado empleado = listado.get(infos.get(0));

        // si la referencia es válida (hay realmente un empleado con dicho dni), se le asigna el sector
        //y se devuelve true. En caso contrario se devuelve false
        if (empleado!=null){
            empleado.asignarRuta(ruta);
            return true;
        }else{
            return false;
        }
    }


    /**
     *
     * @param nombreArchivo archivo de datos del que obtener los sectores
     * @return número de errores obtenidos como consecuencia de la asignación
     * @throws IOException
     */
    public long cargarArchivoAsignacionRuta(String nombreArchivo) throws IOException{
        List<String> lineas = Files.lines(Paths.get(nombreArchivo)).
                collect(Collectors.toList());
        Ruta ruta = procesarNombreRuta(lineas.get(0));

        long errores=lineas.stream().skip(2).
                map(linea -> procesarAsignacionRuta(linea, ruta)).
                filter(flag -> flag == false).count();

        return errores;
    }

    /**
     *
     * @return listado de empleados sin sector y sin ruta
     */
    List < Empleado > buscarEmpleadosSinSectorSinRuta(){
        // se crea una condición para hacer el filtrado de todos los posibles valores del enumerado
        Predicate<Empleado> condicion = empleado ->
                (empleado.obtenerRuta()==Ruta.NORUTA && empleado.obtenerSector()==Sector.NOSECTOR);

        // se usa esta condición para el filtrado
        return listado.values().stream().filter(condicion).collect(Collectors.toList());
    }


    /**
     *
     * @param sector
     * @return listado de empleados sin ruta con un sector determinado
     */
    public List < Empleado > buscarEmpleadosSinRuta(Sector sector){
        Predicate<Empleado> condicion = empleado -> (
                empleado.obtenerSector() == sector &&
                        empleado.obtenerRuta() == Ruta.NORUTA);

        return listado.values().stream().filter(condicion).collect(Collectors.toList());
    }

    /**
     *
     * @return listado de empleados con sector y sin ruta
     */
    public List < Empleado > buscarEmpleadosConSectorSinRuta(){
        List <Empleado> empleados = buscarEmpleadosSinRuta(Sector.SECTOR1);
        empleados.addAll(buscarEmpleadosSinRuta(Sector.SECTOR2));

        return empleados;
    }

    /**
     *
     * @param ruta
     * @return listado de empleados sin sector pero con la ruta dada
     */
    public List < Empleado > buscarEmpleadosSinSector(Ruta ruta){
        Predicate<Empleado> condicion = empleado -> (
                empleado.obtenerSector() == Sector.NOSECTOR &&
                        empleado.obtenerRuta() == ruta);

        return listado.values().stream().filter(condicion).collect(Collectors.toList());
    }

    /**
     *
     * @return listado de empleados sin sector y con ruta
     */
    public List < Empleado > buscarEmpleadosSinSectorConRuta(){
        List <Empleado> empleados = buscarEmpleadosSinSector(Ruta.RUTA1);
        empleados.addAll(buscarEmpleadosSinSector(Ruta.RUTA2));
        empleados.addAll(buscarEmpleadosSinSector(Ruta.RUTA3));

        return empleados;
    }

    /**
     *
     * @param sector
     * @return devuelve los contadores de empleados asignados a cada ruta
     */
    public Map<Ruta, Long> obtenerContadoresRuta(Sector sector){
        return listado.values().stream().
                filter(empleado -> empleado.obtenerSector() == sector).
                sorted(Comparator.comparing(Empleado::obtenerRuta)).
                collect(Collectors.groupingBy (Empleado::obtenerRuta,
                        LinkedHashMap::new,
                        Collectors.mapping(Empleado::obtenerRuta, Collectors.counting())));
    }

    /**
     *
     * @return numero de empleados por ruta y sector
     */
    public Map<Sector, Map<Ruta, Long>> obtenerContadoresSectorRuta(){
        return Arrays.stream(Sector.values()).
                sorted(Comparator.comparing(Sector::ordinal)).
                collect(Collectors.toMap(sector -> sector, this::obtenerContadoresRuta));
    }

    /**
     *
     * @return listado con el numero de empleados de cada sector
     */
    public List<Long> obtenerContadoresSectores(){
        return obtenerContadoresSectorRuta().values().stream().
                map(Map::values).
                map(valor -> valor.stream().reduce((long) 0, Long::sum)).
                collect(Collectors.toList());

    }


}

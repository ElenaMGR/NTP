package base;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcesarEmpleados {
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
   public ProcesarEmpleados(String nombreArchivo){
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

   public void listadoImperativo (){
      for (int i=0; i< numeroEmpleados; i++){
         System.out.println(empleados.get(i).generarLineaSimple());
      }
   }

   public void listadoFuncional(){
      empleados.stream().forEach(empleado -> System.out.println(empleado.generarLineaSimple()));
   }

   public void listadoFuncionalParalelo (){
      empleados.stream().parallel().forEach(empleado -> System.out.println(empleado.generarLineaSimple()));
   }

   /**
    * Metodo main para pruebas
    *
    * @param args
    */
   public static void main(String[] args) {
      /*Integer [] numeros = {1,2,3,4,5,6,7,8,9,0};

      Arrays.stream(numeros).sorted(Comparator.reverseOrder());*/

      // Inicializa el array de empleados
      Empleado[] empleados = {
              new Empleado("Juan", "Lopez", 5000, "IT"),
              new Empleado("Antonio", "Garcia", 7600, "IT"),
              new Empleado("Mateo", "Insausti", 3587.5, "Ventas"),
              new Empleado("Joaquín", "Fernandez", 4700.77, "Marketing"),
              new Empleado("Lucas", "Martinez", 6200, "IT"),
              new Empleado("Pedro", "Garcia", 3200, "Ventas"),
              new Empleado("Fernado", "Gonzalez", 4236.4, "Marketing")
      };

      Predicate<Empleado> condicion = empleado ->
              (empleado.obtenerSueldo() >= 4000 &&
                      empleado.obtenerSueldo() <= 6000);

      Comparator<Empleado> comparador = Comparator.comparing(Empleado::obtenerSueldo);

      //crear flujo
      //filtrar por condición
      //ordenar con comparador
      //listado (forEach)
      Arrays.stream(empleados).filter(condicion).sorted(comparador).
              forEach(empleado -> System.out.println(empleado.generarLineaSimple()));

      //listar todos los nombres, sin repetidos
      List<String> nombres =
              Arrays.stream(empleados).map(empleado -> empleado.obtenerNombre()).distinct().collect(Collectors.toList());

      //Agrupamiento de los empleados por departamento
      Map<String, List<Empleado>> agrupamiento = new HashMap<>();

      String departamento;
      List<Empleado> listaEmpleados;
      for (int i=0; i<empleados.length; i++){
         departamento = empleados[i].obtenerDepartamento();
         //ver si ya existe esa clave en el mapa
         listaEmpleados=agrupamiento.get(departamento);

         if (listaEmpleados == null){
            listaEmpleados = new LinkedList<Empleado>();
            listaEmpleados.add(empleados[i]);

            //introduzco entrada en el mapa
            agrupamiento.put(departamento,listaEmpleados);
         }else{
            listaEmpleados.add(empleados[i]);
         }
      }

      Iterator<String> claves = agrupamiento.keySet().iterator();
      String clave;
      while (claves.hasNext()){
         clave = claves.next();
         //determinar numero de empleados por departamento
         System.out.println(clave + " : "+ agrupamiento.get(clave).size());
      }


      Map<String, List<Empleado>> agrupadosDept =
              Arrays.stream(empleados).collect(Collectors.groupingBy(Empleado::obtenerDepartamento));

      agrupadosDept.forEach(
         (dept, asignados)->{
            System.out.println(dept + " : " + asignados.size());
         }
      );

      // creación de mapas con metodos específicos; conteo de empleados en cada departamento.
      //Objeto: Map<String, int>
      TreeMap<String, Long> contadores =
              Arrays.stream(empleados).collect(Collectors.groupingBy(
                      Empleado::obtenerDepartamento, TreeMap::new, Collectors.counting()));


      //Obtener la media de los sueldos de todos los empleados
      double media = Arrays.stream(empleados).mapToDouble(Empleado::obtenerSueldo).average().getAsDouble();

   }
}


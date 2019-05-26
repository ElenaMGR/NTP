# Práctica 2: programación funcional en Scala y recursividad
### Elena María Gómez Ríos
## Entorno de desarrollo utilizado
He usado IntelliJ Idea, con la versión de jdk 1.8.
## Valoración de la práctica
<p style="text-align: justify;">El lenguaje de Scala es una mejora con respecto a la programación funcional de java, facilita mucho el uso de las colecciones. Como ya comenté con la programación funcional en java, es difícil adaptarse a este tipo de programación por lo que complica el aprendizaje </p>

<p style="text-align: justify;"> En la siguiente tabla podemos ver los tiempos que ha tardado los dos algoritmos de búsqueda para diferentes elementos y tamaños.
</p>

|                  | tamaño = 10000  elemento = 333 | tamaño = 100000000  elemento = 333 | tamaño = 100000000  elemento = 45000000 | tamaño = 100000000  elemento = 95000000 |
|------------------|--------------------------------|------------------------------------|-----------------------------------------|:---------------------------------------:|
| Busqueda Binaria |          0.006035658 s         |            1.446741027 s           |              3.642611599 s              |              0.835704378 s              |
|  Busqueda Saltos |          0.006166319 s         |            1.105772227 s           |              0.859408673 s              |              0.712817837 s              |

<p style="text-align: justify;"> Como se puede observar, se podría decir que el algoritmo de búsqueda por saltos es más eficiente en general que la búsqueda binaria.
</p>

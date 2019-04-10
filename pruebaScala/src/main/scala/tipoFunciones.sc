def duplicar(x:Int) = x*2

val resultado = duplicar(4)

// almacenar funcion en una variable
val funcion : Int => Int = duplicar

//definir funcion con expresión lambda
val funcion2: Int => Int = x => x*2

// la expresion lambda anterior es identica a la siguiente
val funcion3: Int => Int = _*2

// no se fijan los argumentos de momento
val funcion4 = duplicar _
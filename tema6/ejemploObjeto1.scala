
object Saludo{
   println("En objeto saludo")
   def saludar="Hola"
}

object ejemploObjeto1 extends App{
   println(Saludo.saludar)

   // La segunda vez que se llama a saludar el objeto
   // ya ha sido creado y no se muestra el mensaje
   // inicial
   println(Saludo.saludar)
}

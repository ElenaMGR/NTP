val saludo = new Array[String](3)

saludo(0) = "Hola"
saludo(1) = "mundo"
saludo(2) = "cruel"
saludo.apply(0)
saludo.update(2,"soleado")

for (i <- 0 to 2) println(saludo(i))

(0).to(2).by(1)





package claseCase

abstract class Notificacion

case class CorreoElectronico(direccion:String, titulo:String, cuerpo:String) extends Notificacion

case class MensajeSMS(numeroOringen:String, mensaje:String) extends Notificacion

case class MensajeVoz(contacto:String,enlace:String) extends Notificacion

object Prueba extends App{
  def mostrar(notificacion: Notificacion) = {
    notificacion match{
      case CorreoElectronico(dir,tit,_)=>{
        s"Recibido correo de: $dir - titulo: $tit"
      }
      case MensajeSMS(num,men)=>{
        s"Recibido SMS de numero: $num - mensaje: $men"
      }
      case MensajeVoz(con,enl) =>{
        s"Recibido mensaje de voz contacto: $con - enlace: $enl"
      }
      case _ => {"Tipo de objeto desconocido"}
    }
  }

  val sms = new MensajeSMS("12345","Hola, Pepe")
  val voz = new MensajeVoz("Tomas", "http://mensajeVoz/tomas")
  val correo = CorreoElectronico("mgo@ugr.es","fiesta mañana","fiesta escuela")

  val mensajes = List(sms,voz,correo)

  val resultado = mensajes.map(notificacion => mostrar(notificacion))
  println(resultado.mkString("\n"))
}
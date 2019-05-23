package adapter;

public interface AdaptadorCifrado {
    public void cifrar(String texto);
}

class Adaptador1 implements AdaptadorCifrado{
    private CifradorLibreria1 cifrador;

    public Adaptador1(CifradorLibreria1 cifrador){
        this.cifrador=cifrador;
    }

    @Override
    public void cifrar(String texto){
        cifrador.cifrar(texto);
    }
}

class Adaptador2 implements AdaptadorCifrado{
    private CifradorLibreria2 cifrador;

    public Adaptador2(CifradorLibreria2 cifrador){
        this.cifrador=cifrador;
    }

    @Override
    public void cifrar(String texto){
        cifrador.realizarCifrado(texto);
    }
}

class Cliente{
    private AdaptadorCifrado adaptador;

    /*public Cliente(AdaptadorCifrado adaptador){
        this.adaptador=adaptador;
    }*/

    public void asignarAdaptador(AdaptadorCifrado adaptador){
        this.adaptador=adaptador;
    }

    public void cifrar(String texto){
        adaptador.cifrar(texto);
    }

    public static void main(String args[]){
        CifradorLibreria1 cifrador1 = new CifradorLibreria1();
        CifradorLibreria2 cifrador2 = new CifradorLibreria2();
        Adaptador1 adaptador1 = new Adaptador1(cifrador1);
        Adaptador2 adaptador2 = new Adaptador2(cifrador2);

        /*Cliente cliente1 = new Cliente(adaptador1);
        cliente1.cifrar("texto a cifrar");

        Cliente cliente2 = new Cliente(adaptador2);
        cliente2.cifrar("texto a cifrar");*/

        Cliente cliente = new Cliente();
        cliente.asignarAdaptador(adaptador1);
        cliente.cifrar("cadena");
        cliente.asignarAdaptador(adaptador2);
        cliente.cifrar("cadena");

    }
}

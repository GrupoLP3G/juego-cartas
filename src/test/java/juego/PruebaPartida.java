package juego;
import juego.modelo.ObservadorPartida;
import juego.modelo.Partida;
import juego.modelo.cartas.Escudo;
import juego.modelo.cartas.Golpe;
import juego.modelo.cartas.Pocion;
import java.util.List;
import juego.excepciones.JuegoException;
import juego.modelo.Jugador;
import juego.modelo.Mazo;
import juego.modelo.jefes.EstrategiaFija;
import juego.modelo.jefes.Jefe;
public class PruebaPartida 
{
    private static  void probarTurnoNormal() throws JuegoException
    {
        Jugador jugador= new Jugador("Fer");
        Jefe jefe=new Jefe("El malo", 30, new EstrategiaFija(), new EstrategiaFija(), 0);
        Mazo mazo=new Mazo(List.of(new Golpe(),new Golpe(),new Escudo(),new Pocion(),new Pocion()));    
        ObservadorNumeros numeros= new ObservadorNumeros();
        ObservadorBitacora bitacora=new ObservadorBitacora();
        Partida partida=new Partida(jugador, jefe, mazo);
        partida.agregarObservador(bitacora);
        partida.agregarObservador(numeros);
        System.out.println("----Paso 1---");
        partida.iniciarTurno();
        System.out.println("----Paso 2-----");
        partida.jugarCarta(0);
        System.out.println("---Paso 3---");
        partida.terminarTurno();
        try
        {
            System.out.println("----Paso 4----");
            partida.jugarCarta(10);
        }catch(JuegoException e) {System.out.println(e.getMessage());}
    }
    private static  void probarAgotado()throws JuegoException
    {
        System.out.println("---Paso 5------");
        ObservadorNumeros numeros= new ObservadorNumeros();
        ObservadorBitacora bitacora=new ObservadorBitacora();
        Mazo mazo=new Mazo(List.of(new Golpe(),new Golpe(),new Golpe(),new Golpe(),new Golpe()
        ,new Golpe(),new Golpe(),new Golpe(),new Golpe()));
        Jefe jefe=new Jefe("El malo", 30, new EstrategiaFija(), new EstrategiaFija(), 0);
        Jugador jugador= new Jugador("Fer");
        Partida partida=new Partida(jugador, jefe, mazo);
        partida.iniciarTurno();
        partida.agregarObservador(bitacora);
        partida.agregarObservador(numeros);
        partida.jugarCarta(0);
        partida.jugarCarta(0);
        partida.jugarCarta(0);
        partida.terminarTurno();
        partida.jugarCarta(0);
        partida.jugarCarta(0);
        partida.jugarCarta(0);
        partida.terminarTurno();
        partida.jugarCarta(0);
        System.out.println("--- Paso 6");   
        partida.quitarObservador(bitacora);
        partida.jugarCarta(0);

    }
    public static void main(String[] args) throws JuegoException
    {
        probarTurnoNormal();
        probarAgotado();
    }
}

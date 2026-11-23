package juego;

import java.util.List;

import juego.excepciones.JuegoException;
import juego.modelo.Jugador;
import juego.modelo.Mazo;
import juego.modelo.Partida;
import juego.modelo.cartas.Golpe;
import juego.modelo.jefes.Jefe;

public class PruebaDefensas 
{
    public static void main(String[] args) throws JuegoException
    {
        Jugador jugador=new Jugador("Fer");
        ObservadorBitacora bitacora=new ObservadorBitacora();
        ObservadorNumeros numeros=new ObservadorNumeros();
        Jefe jefe=new Jefe("El malo",40,new  EstrategiaFija(),new EstrategiaFija(),70);
        Partida partida=new Partida(jugador, jefe, new Mazo(List.of(new Golpe(),new Golpe(),new Golpe(),new Golpe(),new Golpe())));
        partida.agregarObservador(bitacora);
        partida.agregarObservador(numeros);
        partida.iniciarTurno();
        partida.blindarJefe(5);
        partida.jugarCarta(0);
        partida.ponerJefeEnGuardia();
        partida.jugarCarta(0);
        partida.terminarTurno();
        partida.jugarCarta(0);
    }
        
}

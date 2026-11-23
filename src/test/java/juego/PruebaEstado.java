package juego;
import juego.modelo.ObservadorPartida;
import juego.modelo.Partida;
import juego.modelo.cartas.Golpe;
import java.util.List;
import juego.excepciones.JuegoException;
import juego.modelo.EstadoPartida;
import juego.modelo.Jugador;
import juego.modelo.Mazo;
import juego.modelo.jefes.Jefe;
public class PruebaEstado 
{
    public static void main(String[] args) throws JuegoException 
    {
        ObservadorPartida observadorBitacora=new ObservadorBitacora();
        ObservadorPartida observadorNumeros=new ObservadorNumeros();
        Jugador jugador = new Jugador("Fern");
        Jefe jefe =new Jefe("El malo", 30, new EstrategiaFija(), new EstrategiaFija(), 0);
        Mazo mazo =new Mazo(List.of(new Golpe(),new Golpe(),new Golpe(),new Golpe(),new Golpe(),new Golpe()));
        Partida partida=new Partida(jugador, jefe, mazo);    
        partida.agregarObservador(observadorNumeros);
        partida.agregarObservador(observadorBitacora);
        partida.iniciarTurno();
        EstadoPartida foto=partida.guardarEstado();
        partida.jugarCarta(0);
        partida.restaurarEstado(foto);
        partida.jugarCarta(0);
        partida.restaurarEstado(foto);
    }
}

package juego;

import java.util.List;

import juego.comandos.Comando;
import juego.comandos.HistorialComandos;
import juego.comandos.JugarCartaComando;
import juego.excepciones.JuegoException;
import juego.modelo.Jugador;
import juego.modelo.Mazo;
import juego.modelo.Partida;
import juego.modelo.cartas.Golpe;
import juego.modelo.jefes.Jefe;

public class PruebaComandos 
{
    public static void main(String[] args) throws JuegoException
    {
        Jugador jugador=new Jugador("Fre");
        Mazo mazo=new Mazo(List.of(new Golpe(),new Golpe(),new Golpe(),new Golpe(),new Golpe()));
        Jefe jefe =new Jefe("null", 30);
        Partida partida=new Partida(jugador, jefe, mazo);
        ObservadorNumeros observadorNumeros=new ObservadorNumeros();
        partida.agregarObservador(observadorNumeros);
        HistorialComandos historialComandos=new HistorialComandos();
        partida.iniciarTurno();
        System.out.println("Puede deshacer:"+historialComandos.puedeDeshacer());
        System.out.println("Puede rehacer :"+historialComandos.puedeRehacer());
        historialComandos.ejecutar(new JugarCartaComando(partida, 0));
        System.out.println("Puede deshacer:"+historialComandos.puedeDeshacer());
        System.out.println("Puede rehacer :"+historialComandos.puedeRehacer());
        historialComandos.ejecutar(new JugarCartaComando(partida, 0));
        System.out.println("Puede deshacer:"+historialComandos.puedeDeshacer());
        System.out.println("Puede rehacer :"+historialComandos.puedeRehacer());
        historialComandos.deshacer();
        System.out.println("Puede deshacer:"+historialComandos.puedeDeshacer());
        System.out.println("Puede rehacer :"+historialComandos.puedeRehacer());
        historialComandos.deshacer();
        System.out.println("Puede deshacer:"+historialComandos.puedeDeshacer());
        System.out.println("Puede rehacer :"+historialComandos.puedeRehacer());
        historialComandos.rehacer();
        System.out.println("Puede deshacer:"+historialComandos.puedeDeshacer());
        System.out.println("Puede rehacer :"+historialComandos.puedeRehacer());
        historialComandos.ejecutar(new JugarCartaComando(partida, 0));
        System.out.println("Puede deshacer:"+historialComandos.puedeDeshacer());
        System.out.println("Puede rehacer :"+historialComandos.puedeRehacer());
    }    
}

package juego;

import java.util.List;

import javax.swing.SwingUtilities;

import juego.controlador.ControladorJuego;
import juego.modelo.Jugador;
import juego.modelo.Mazo;
import juego.modelo.Partida;
import juego.modelo.cartas.Escudo;
import juego.modelo.cartas.Golpe;
import juego.modelo.cartas.Pocion;
import juego.modelo.jefes.Jefe;
import juego.vista.VentanaSimple;

public class Main {

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(()->
        {
            Jugador jugador=new Jugador("Fer");
            Jefe jefe=new Jefe("el malo", 50);
            Mazo mazo=new Mazo(List.of(new Golpe(),new Golpe(),new Golpe(),new Pocion(),new Pocion(),new Pocion(),
            new Escudo(),new Escudo(),new Escudo() ));
            Partida partida=new Partida(jugador, jefe, mazo);
            ControladorJuego controlador=new ControladorJuego(partida);
            VentanaSimple ventana=new VentanaSimple(controlador);
            partida.agregarObservador(ventana);
            ventana.setVisible(true);
            controlador.iniciar();
        });
    }
}

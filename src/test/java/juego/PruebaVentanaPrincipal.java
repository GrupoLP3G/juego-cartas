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
import juego.modelo.jefes.CatalogoJefes;
import juego.vista.VentanaPrincipal;

public class PruebaVentanaPrincipal {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Jugador jugador = new Jugador("Sebastián");
            Mazo mazo = new Mazo(List.of(
                    new Golpe(), new Escudo(), new Pocion(),
                    new Golpe(), new Escudo(), new Pocion()
            ));

            Partida partida = new Partida(jugador, CatalogoJefes.crearAgresivo(), mazo);
            ControladorJuego controlador = new ControladorJuego(partida);
            VentanaPrincipal ventana = new VentanaPrincipal(partida, controlador);

            controlador.iniciar();
            ventana.setVisible(true);
        });
    }
}
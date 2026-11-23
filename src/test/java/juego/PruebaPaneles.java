package juego;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import juego.controlador.ControladorJuego;
import juego.modelo.Jugador;
import juego.modelo.Mazo;
import juego.modelo.Partida;
import juego.modelo.cartas.Escudo;
import juego.modelo.cartas.Golpe;
import juego.modelo.cartas.Pocion;
import juego.modelo.jefes.CatalogoJefes;
import juego.vista.PanelJugador;
import juego.vista.PanelJefe;
import juego.vista.PanelMano;

public class PruebaPaneles {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Jugador jugador = new Jugador("Sebastián");
            Mazo mazo = new Mazo(List.of(new Golpe(), new Escudo(), new Pocion()));
            Partida partida = new Partida(jugador, CatalogoJefes.crearAgresivo(), mazo);
            ControladorJuego controlador = new ControladorJuego(partida);

            PanelJugador panelJugador = new PanelJugador();
            PanelJefe panelJefe = new PanelJefe();
            PanelMano panelMano = new PanelMano(controlador);

            partida.agregarObservador(panelJugador);
            partida.agregarObservador(panelJefe);
            partida.agregarObservador(panelMano);
            controlador.iniciar();

            JPanel estados = new JPanel(new GridLayout(1, 2, 8, 0));
            estados.add(panelJugador);
            estados.add(panelJefe);

            JFrame ventana = new JFrame("Prueba de los tres paneles");
            ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventana.add(estados, BorderLayout.CENTER);
            ventana.add(panelMano, BorderLayout.SOUTH);
            ventana.pack();
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        });
    }
}
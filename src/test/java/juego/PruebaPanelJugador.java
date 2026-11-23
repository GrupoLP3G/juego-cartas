package juego;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import juego.controlador.ControladorJuego;
import juego.modelo.Jugador;
import juego.modelo.Mazo;
import juego.modelo.Partida;
import juego.modelo.cartas.Escudo;
import juego.modelo.jefes.CatalogoJefes;
import juego.vista.PanelJugador;

public class PruebaPanelJugador {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Jugador jugador = new Jugador("Sebastián");
            Mazo mazo = new Mazo(List.of(new Escudo(), new Escudo(), new Escudo()));
            Partida partida = new Partida(jugador, CatalogoJefes.crearAgresivo(), mazo);
            ControladorJuego controlador = new ControladorJuego(partida);

            PanelJugador panel = new PanelJugador();
            partida.agregarObservador(panel);
            controlador.iniciar();

            JButton boton = new JButton("Jugar Escudo");
            boton.addActionListener(evento -> {
                controlador.jugarCarta(0);
                boton.setEnabled(false);
            });

            JFrame ventana = new JFrame("Panel del jugador");
            ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventana.add(panel, BorderLayout.CENTER);
            ventana.add(boton, BorderLayout.SOUTH);
            ventana.pack();
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        });
    }
}
package juego.vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import juego.controlador.ControladorJuego;
import juego.modelo.ObservadorPartida;
import juego.modelo.Partida;

public class VentanaPrincipal extends JFrame implements ObservadorPartida {

    private final JButton terminarTurno = new JButton("Terminar turno");

    public VentanaPrincipal(Partida partida, ControladorJuego controlador) {
        super("Juego de cartas");
        MenuAcciones menuAcciones = new MenuAcciones(controlador);
        setJMenuBar(menuAcciones);
        partida.agregarObservador(menuAcciones);

        PanelJugador panelJugador = new PanelJugador();
        PanelJefe panelJefe = new PanelJefe();
        PanelMano panelMano = new PanelMano(controlador);
        PanelBitacora panelBitacora = new PanelBitacora();

        JPanel estados = new JPanel(new GridLayout(1, 2, 8, 0));
        estados.setOpaque(false);
        estados.add(panelJugador);
        estados.add(panelJefe);

        terminarTurno.setBackground(EstiloPixel.DORADO);
        terminarTurno.setForeground(EstiloPixel.BORDE);
        terminarTurno.setEnabled(false);
        terminarTurno.addActionListener(evento -> controlador.terminarTurno());

        JPanel zonaInferior = new JPanel(new BorderLayout(8, 0));
        zonaInferior.setOpaque(false);
        zonaInferior.add(panelMano, BorderLayout.CENTER);
        zonaInferior.add(terminarTurno, BorderLayout.EAST);

        JPanel contenido = new JPanel(new BorderLayout(8, 8));
        contenido.setBackground(EstiloPixel.FONDO);
        contenido.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contenido.add(estados, BorderLayout.NORTH);
        contenido.add(panelBitacora, BorderLayout.CENTER);
        contenido.add(zonaInferior, BorderLayout.SOUTH);

        setContentPane(contenido);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(850, 480);
        setLocationRelativeTo(null);

        partida.agregarObservador(panelJugador);
        partida.agregarObservador(panelJefe);
        partida.agregarObservador(panelMano);
        partida.agregarObservador(panelBitacora);
        partida.agregarObservador(this);
    }

    @Override
    public void alCambiarPartida(Partida partida) {
        if (!SwingUtilities.isEventDispatchThread()) {
            SwingUtilities.invokeLater(() -> alCambiarPartida(partida));
            return;
        }

        terminarTurno.setEnabled(!partida.isTerminada());
    }

    @Override
    public void alRegistrarMensaje(String mensaje) {
        // PanelBitacora ya recibe los mensajes directamente de la partida.
    }
}
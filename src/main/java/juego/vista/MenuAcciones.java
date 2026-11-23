package juego.vista;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;
import juego.controlador.ControladorJuego;
import juego.modelo.ObservadorPartida;
import juego.modelo.Partida;

public class MenuAcciones extends JMenuBar implements ObservadorPartida {

    private final ControladorJuego controlador;
    private final JMenuItem deshacer = new JMenuItem("Deshacer");
    private final JMenuItem rehacer = new JMenuItem("Rehacer");

    public MenuAcciones(ControladorJuego controlador) {
        this.controlador = controlador;

        JMenu acciones = new JMenu("Acciones");

        deshacer.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK));
        rehacer.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_DOWN_MASK));

        deshacer.addActionListener(evento -> controlador.deshacer());
        rehacer.addActionListener(evento -> controlador.rehacer());

        acciones.add(deshacer);
        acciones.add(rehacer);
        add(acciones);

        actualizarOpciones();
    }

    private void actualizarOpciones() {
        deshacer.setEnabled(controlador.puedeDeshacer());
        rehacer.setEnabled(controlador.puedeRehacer());
    }

    @Override
    public void alCambiarPartida(Partida partida) {
        // Actualiza el menú cuando el controlador ya terminó de guardar la jugada.
        SwingUtilities.invokeLater(() -> actualizarOpciones());
    }

    @Override
    public void alRegistrarMensaje(String mensaje) {
        // Los mensajes los muestra la bitácora.
    }
}
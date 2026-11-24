package juego.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import juego.controlador.ControladorJuego;
import juego.modelo.ObservadorPartida;
import juego.modelo.Partida;
import juego.modelo.cartas.Carta;

public class PanelMano extends JPanel implements ObservadorPartida {

    private final ControladorJuego controlador;
    private final JPanel cartas = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));

    public PanelMano(ControladorJuego controlador) {
        super(new BorderLayout());
        this.controlador = controlador;

        setBackground(EstiloPixel.PANEL);
        cartas.setBackground(EstiloPixel.PANEL);

        TitledBorder borde = BorderFactory.createTitledBorder(
                EstiloPixel.BORDE_PANEL, "Tu mano");
        borde.setTitleColor(EstiloPixel.DORADO);
        setBorder(borde);

        JScrollPane desplazamiento = new JScrollPane(cartas,
                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        desplazamiento.setBorder(null);
        add(desplazamiento, BorderLayout.CENTER);
    }

    @Override
    public void alCambiarPartida(Partida partida) {
        if (!SwingUtilities.isEventDispatchThread()) {
            SwingUtilities.invokeLater(() -> alCambiarPartida(partida));
            return;
        }

        cartas.removeAll();
        List<Carta> mano = partida.getJugador().getMano();

        for (int indice = 0; indice < mano.size(); indice++) {
            Carta carta = mano.get(indice);
            int posicion = indice;

            JButton boton = new JButton(carta.getNombre() + " · Costo: " + carta.getCosto());
            boton.setBackground(EstiloPixel.FONDO);
            boton.setForeground(EstiloPixel.TEXTO);
            boton.setToolTipText(carta.getDescripcion());
            boton.setEnabled(!partida.isTerminada());
            boton.addActionListener(evento -> controlador.jugarCarta(posicion));
            cartas.add(boton);
        }

        if (mano.isEmpty()) {
            JLabel aviso = new JLabel("Mano vacía");
            aviso.setForeground(EstiloPixel.TEXTO);
            cartas.add(aviso);
        }

        cartas.revalidate();
        cartas.repaint();
    }

    @Override
    public void alRegistrarMensaje(String mensaje) {
        // Los mensajes se muestran en el panel de bitácora.
    }
}
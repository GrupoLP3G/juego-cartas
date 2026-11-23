package juego.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import juego.modelo.Jugador;
import juego.modelo.ObservadorPartida;
import juego.modelo.Partida;

public class PanelJugador extends JPanel implements ObservadorPartida {

    private final JLabel vida = new JLabel();
    private final JLabel escudo = new JLabel();
    private final JLabel energia = new JLabel();
    private final JLabel veneno = new JLabel();

    public PanelJugador() {
        setLayout(new GridLayout(2, 2, 20, 12));
        setBackground(EstiloPixel.PANEL);
        setBorder(BorderFactory.createCompoundBorder(
                EstiloPixel.BORDE_PANEL,
                BorderFactory.createEmptyBorder(16, 20, 16, 20)
        ));

        agregarDato(vida, EstiloPixel.ROJO);
        agregarDato(escudo, EstiloPixel.AZUL);
        agregarDato(energia, EstiloPixel.DORADO);
        agregarDato(veneno, EstiloPixel.VERDE);
    }

    private void agregarDato(JLabel etiqueta, Color color) {
        etiqueta.setForeground(color);
        etiqueta.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
        add(etiqueta);
    }

    @Override
    public void alCambiarPartida(Partida partida) {
        if (!SwingUtilities.isEventDispatchThread()) {
            SwingUtilities.invokeLater(() -> alCambiarPartida(partida));
            return;
        }

        Jugador jugador = partida.getJugador();
        vida.setText("Vida: " + jugador.getVida());
        escudo.setText("Escudo: " + jugador.getEscudo());
        energia.setText("Energía: " + jugador.getEnergia());
        veneno.setText("Veneno: " + jugador.getMarcasVeneno());
    }

    @Override
    public void alRegistrarMensaje(String mensaje) {
        // Los mensajes se muestran en el panel de bitácora.
    }
}
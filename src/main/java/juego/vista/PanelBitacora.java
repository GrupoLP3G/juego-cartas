package juego.vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import juego.modelo.ObservadorPartida;
import juego.modelo.Partida;

public class PanelBitacora extends JPanel implements ObservadorPartida {

    private final JTextArea mensajes = new JTextArea(6, 35);

    public PanelBitacora() {
        super(new BorderLayout());
        setBackground(EstiloPixel.PANEL);

        TitledBorder borde = BorderFactory.createTitledBorder(
                EstiloPixel.BORDE_PANEL, "Bitácora");
        borde.setTitleColor(EstiloPixel.DORADO);
        setBorder(borde);

        mensajes.setEditable(false);
        mensajes.setLineWrap(true);
        mensajes.setWrapStyleWord(true);
        mensajes.setBackground(EstiloPixel.FONDO);
        mensajes.setForeground(EstiloPixel.TEXTO);
        mensajes.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        mensajes.setMargin(new Insets(6, 8, 6, 8));

        JScrollPane desplazamiento = new JScrollPane(mensajes);
        desplazamiento.setBorder(null);
        add(desplazamiento, BorderLayout.CENTER);
    }

    @Override
    public void alCambiarPartida(Partida partida) {
        // La bitácora se actualiza cuando recibe un mensaje.
    }

    @Override
    public void alRegistrarMensaje(String mensaje) {
        if (!SwingUtilities.isEventDispatchThread()) {
            SwingUtilities.invokeLater(() -> alRegistrarMensaje(mensaje));
            return;
        }

        mensajes.append(mensaje + "\n");
        mensajes.setCaretPosition(mensajes.getDocument().getLength());
    }
}
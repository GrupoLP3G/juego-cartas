package juego.vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;
import java.util.Locale;
import javax.swing.*;
import juego.modelo.ObservadorPartida;
import juego.modelo.Partida;
import juego.modelo.jefes.Jefe;

public class PanelJefe extends JPanel implements ObservadorPartida {

    private final JLabel nombre = new JLabel();
    private final JLabel retrato = new JLabel("JEFE", SwingConstants.CENTER);
    private final JProgressBar barraVida = new JProgressBar();

    public PanelJefe() {
        setLayout(new BorderLayout(16, 0));
        setBackground(EstiloPixel.PANEL);
        setBorder(BorderFactory.createCompoundBorder(
                EstiloPixel.BORDE_PANEL,
                BorderFactory.createEmptyBorder(12, 16, 12, 16)
        ));

        nombre.setForeground(EstiloPixel.DORADO);
        nombre.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
        retrato.setForeground(EstiloPixel.TEXTO);

        barraVida.setForeground(EstiloPixel.ROJO);
        barraVida.setBackground(EstiloPixel.FONDO);
        barraVida.setStringPainted(true);

        JPanel datos = new JPanel(new GridLayout(2, 1, 0, 6));
        datos.setOpaque(false);
        datos.add(nombre);
        datos.add(barraVida);

        add(retrato, BorderLayout.WEST);
        add(datos, BorderLayout.CENTER);
    }

    @Override
    public void alCambiarPartida(Partida partida) {
        if (!SwingUtilities.isEventDispatchThread()) {
            SwingUtilities.invokeLater(() -> alCambiarPartida(partida));
            return;
        }

        Jefe jefe = partida.getJefe();
        String nombreJefe = jefe.getNombre().trim();

        if (!nombreJefe.equals(nombre.getText())) {
            nombre.setText(nombreJefe);
            cargarRetrato(nombreJefe);
        }

        barraVida.setMaximum(jefe.getVidaMaxima());
        barraVida.setValue(jefe.getVida());
        barraVida.setString("Vida: " + jefe.getVida() + " / " + jefe.getVidaMaxima());
    }

    private void cargarRetrato(String nombreJefe) {
        String archivo = nombreJefe.toLowerCase(Locale.ROOT) + ".png";
        URL ruta = PanelJefe.class.getResource("/imagenes/jefes/" + archivo);

        if (ruta == null) {
            retrato.setIcon(null);
            retrato.setText("JEFE");
            return;
        }

        Image imagen = new ImageIcon(ruta).getImage();
        retrato.setIcon(new ImageIcon(imagen.getScaledInstance(80, 80, Image.SCALE_REPLICATE)));
        retrato.setText("");
    }

    @Override
    public void alRegistrarMensaje(String mensaje) {
        // Los mensajes se muestran en el panel de bitácora.
    }
}
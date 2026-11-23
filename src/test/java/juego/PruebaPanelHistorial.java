package juego;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import juego.vista.PanelHistorial;

public class PruebaPanelHistorial {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PanelHistorial panel = new PanelHistorial();

            String[] columnas = {"Jugador", "Jefe", "Resultado", "Turnos"};
            Object[][] partidas = {
                {"Nachok", "Diablo", "Victoria", 5},
                {"Nachok", "Diablo", "Derrota", 8}
            };
            panel.mostrarHistorial(columnas, partidas);

            JFrame ventana = new JFrame("Prueba del historial");
            ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventana.add(panel);
            ventana.setSize(520, 260);
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        });
    }
}
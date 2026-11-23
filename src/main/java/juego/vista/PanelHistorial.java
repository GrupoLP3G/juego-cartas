package juego.vista;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PanelHistorial extends JPanel {

    private final DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };

    private final JLabel aviso = new JLabel("Sin registros para mostrar.");

    public PanelHistorial() {
        super(new BorderLayout(0, 6));
        setBackground(EstiloPixel.PANEL);

        TitledBorder borde = BorderFactory.createTitledBorder(
                EstiloPixel.BORDE_PANEL, "Historial de partidas");
        borde.setTitleColor(EstiloPixel.DORADO);
        setBorder(borde);

        JTable tabla = new JTable(modelo);
        tabla.setFillsViewportHeight(true);
        tabla.setRowHeight(24);
        tabla.setBackground(EstiloPixel.FONDO);
        tabla.setForeground(EstiloPixel.TEXTO);
        tabla.setGridColor(EstiloPixel.BORDE);
        tabla.setSelectionBackground(EstiloPixel.AZUL);
        tabla.setSelectionForeground(EstiloPixel.BORDE);

        aviso.setForeground(EstiloPixel.TEXTO);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        add(aviso, BorderLayout.SOUTH);
    }

    public void mostrarHistorial(String[] columnas, Object[][] filas) {
        if (!SwingUtilities.isEventDispatchThread()) {
            SwingUtilities.invokeLater(() -> mostrarHistorial(columnas, filas));
            return;
        }

        modelo.setDataVector(filas, columnas);
        aviso.setVisible(modelo.getRowCount() == 0);
    }
}
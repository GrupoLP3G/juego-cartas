package juego.vista;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import juego.controlador.ControladorJuego;
import juego.modelo.ObservadorPartida;
import juego.modelo.Partida;
import juego.modelo.cartas.Carta;
public class VentanaSimple extends JFrame implements ObservadorPartida
{
    private ControladorJuego controlador;
    private JLabel etiquetaJugador,etiquetaJefe;
    private JPanel panelCartas;
    private JTextArea bitacora;
    private JButton botonDeshacer,botonRehacer,botonTerminar;
    public VentanaSimple(ControladorJuego controlador)
    {
        this.botonDeshacer=new JButton("Deshacer");
        this.botonRehacer=new JButton("Rehacer");
        this.botonTerminar=new JButton("Terminar turno");
        this.controlador=controlador;
        setTitle("Juego de cartas");
        setSize(800,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel panelArriba= new JPanel(new GridLayout(2,1));
        this.etiquetaJugador=new JLabel();
        this.etiquetaJefe=new JLabel();
        panelArriba.add(this.etiquetaJugador);
        panelArriba.add(this.etiquetaJefe);
        add(panelArriba,BorderLayout.NORTH);
        this.bitacora= new JTextArea();
        this.bitacora.setEditable(false);
        add(new JScrollPane(this.bitacora),BorderLayout.CENTER);
        JPanel panelAbajo=new JPanel(new GridLayout(2,1));
        this.panelCartas=new JPanel();
        JPanel panelBotones=new JPanel();
        panelAbajo.add(this.panelCartas);
        panelAbajo.add(panelBotones);
        add(panelAbajo,BorderLayout.SOUTH);
        botonTerminar.addActionListener(e-> {controlador.terminarTurno();actualizarBotones();});
        botonDeshacer.addActionListener(e-> {controlador.deshacer();actualizarBotones();});
        botonRehacer.addActionListener(e-> {controlador.rehacer();actualizarBotones();});
        panelBotones.add(this.botonTerminar);
        panelBotones.add(this.botonDeshacer);
        panelBotones.add(this.botonRehacer);
        actualizarBotones();
    }
    private void actualizarBotones()
    {
        this.botonDeshacer.setEnabled(controlador.puedeDeshacer());
        this.botonRehacer.setEnabled(controlador.puedeRehacer());
    }
    @Override 
    public void alRegistrarMensaje(String mensaje){this.bitacora.append(mensaje+"\n");}
    @Override 
    public void alCambiarPartida(Partida partida)
    {
        this.etiquetaJugador.setText("Vida:"+partida.getJugador().getVida()+" Escudo:"+partida.getJugador().getEscudo()
        +" Energia:"+partida.getJugador().getEnergia()+" Veneno:"+partida.getJugador().getMarcasVeneno());
        String textoJefe=partida.getJefe().getNombre()+":"+" Vida:"+partida.getJefe().getVida()+
        ". Intencion:"+partida.getJefe().getIntencion().getDescripcion();
        if(partida.getJefe().estaEnRabia()){textoJefe=textoJefe+"ESTA2 FURIOSO";}
        this.etiquetaJefe.setText(textoJefe);
        this.panelCartas.removeAll();
        List<Carta> mano = partida.getJugador().getMano();
        for (int i = 0; i < mano.size(); i++)
        {
            Carta carta = mano.get(i);
            JButton botonCarta = new JButton(carta.getNombre() + " (" + carta.getCosto() + ")");
            final int posicion = i;
            botonCarta.addActionListener(e -> {controlador.jugarCarta(posicion);actualizarBotones();});
            botonCarta.setToolTipText(carta.getDescripcion());
            panelCartas.add(botonCarta);
        }
        if(partida.isTerminada()){this.botonTerminar.setEnabled(false);}

        panelCartas.revalidate();
        panelCartas.repaint();
    }
}

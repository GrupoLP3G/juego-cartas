package juego.controlador;

import juego.comandos.HistorialComandos;
import juego.comandos.JugarCartaComando;
import juego.excepciones.JuegoException;
import juego.modelo.Partida;
import javax.swing.JOptionPane;

public class ControladorJuego 
{
    private Partida partida;
    private HistorialComandos historial;
    public ControladorJuego(Partida partida)
    {
        this.partida=partida;
        this.historial=new HistorialComandos();
    }
    private void mostrarError(String mensaje){JOptionPane.showMessageDialog(null, mensaje);}
    public void iniciar(){this.partida.iniciarTurno();}
    public void jugarCarta(int posicion)
    {
        try
        {
            this.historial.ejecutar(new JugarCartaComando(this.partida,posicion));
        }catch (JuegoException e){mostrarError(e.getMessage());}
    }    
    public void terminarTurno()
    {
        try
        {
            this.partida.terminarTurno();
            this.historial.limpiar();
        }catch (JuegoException e){mostrarError(e.getMessage());}
    }
    public void deshacer(){this.historial.deshacer();}
    public void rehacer()
    {
        try
        {
            this.historial.rehacer();
        }catch (JuegoException e){mostrarError(e.getMessage());}
    }
    public boolean puedeDeshacer(){return this.historial.puedeDeshacer();}
    public boolean puedeRehacer(){return this.historial.puedeRehacer();}
}

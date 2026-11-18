package juego.comandos;

import juego.excepciones.JuegoException;
import juego.modelo.EstadoPartida;
import juego.modelo.Partida;

public class JugarCartaComando implements Comando 
{
    private Partida partida;
    private int posicion;
    private EstadoPartida estadoAntes;
    private EstadoPartida estadoDespues;
    public JugarCartaComando(Partida partida,int posicion)
    {
        this.partida=partida;
        this.posicion=posicion;
    }
    @Override 
    public void ejecutar() throws JuegoException
    {
        if(this.estadoDespues==null)
        {
            this.estadoAntes= partida.guardarEstado();
            this.partida.jugarCarta(posicion);
            this.estadoDespues = partida.guardarEstado();
        }else partida.restaurarEstado(this.estadoDespues);
    }
    @Override 
    public void deshacer()
    {
        partida.restaurarEstado(estadoAntes);
        partida.registrar("Se deshizo la jugada");
    }
        
}

package juego.modelo.jefes;

import juego.modelo.Partida;

public class AtaqueDoble implements AccionJefe
{
    private String nombre;
    private int danio;
    public AtaqueDoble(String nombre ,int danio)
    {
        this.nombre=nombre;
        this.danio=danio;
    }
    @Override 
    public void ejecutar(Partida partida)
    {
        partida.daniarJugador(danio);
        partida.daniarJugador(danio);
    }
    @Override 
    public String getDescripcion(){return this.nombre+" "+this.danio+" x2";}    
}

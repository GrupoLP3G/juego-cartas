package juego.modelo;

import juego.modelo.jefes.Jefe;

public class EstadoPartida 
{
    Jugador jugador;
    Jefe jefe;
    Mazo mazo;
    int turno;
    public EstadoPartida(Jugador jugador,Jefe jefe,Mazo mazo,int turno)
    {
        this.jugador=jugador;
        this.jefe=jefe;
        this.mazo=mazo;
        this.turno=turno;
    }
    public Jugador getJugador(){return this.jugador;}
    public Jefe getJefe(){return this.jefe;}
    public Mazo getMazo(){return this.mazo;}
    public int getTurno(){return this.turno;}    
}

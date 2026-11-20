package juego.modelo.jefes;

import juego.modelo.Jugador;

public class EstrategiaFija implements EstrategiaJefe 
{
    @Override 
    public AccionJefe elegirAccion(Jefe jefe,Jugador jugador)
    {return new Atacar("Golpe", 5);}    
}

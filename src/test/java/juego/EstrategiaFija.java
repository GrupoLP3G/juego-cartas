package juego;
import juego.modelo.Jugador;
import juego.modelo.jefes.AccionJefe;
import juego.modelo.jefes.Atacar;
import juego.modelo.jefes.EstrategiaJefe;
import juego.modelo.jefes.Jefe;
public class EstrategiaFija implements EstrategiaJefe 
{
    @Override 
    public AccionJefe elegirAccion(Jefe jefe,Jugador jugador)
    {return new Atacar("Golpe ", 5);}    
}

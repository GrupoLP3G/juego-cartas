package juego.modelo.jefes;

import juego.modelo.Jugador;

public class EstrategiaAgresivaRabia implements EstrategiaJefe
{
    @Override
    public AccionJefe elegirAccion(Jefe jefe,Jugador jugador)
    {
        return new AtaqueDoble("Super ataque", 6);
    }    
}

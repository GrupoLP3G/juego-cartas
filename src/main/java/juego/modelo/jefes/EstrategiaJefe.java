package juego.modelo.jefes;

import juego.modelo.Jugador;

public interface EstrategiaJefe {
    public AccionJefe elegirAccion(Jefe jefe,Jugador jugador);
}

package juego.modelo.jefes;

import juego.modelo.Partida;

public interface AccionJefe 
{
    public void ejecutar(Partida partida);
    public String getDescripcion();
        
}

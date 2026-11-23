package juego.modelo.jefes;

import juego.modelo.Jugador;

public class EstrategiaAgresivaNormal implements EstrategiaJefe
{
    @Override 
    public AccionJefe elegirAccion(Jefe jefe,Jugador jugador)
    {
        if(jugador.getVida()<=10)
        {
            return new Atacar(" Golpe Brutal ", 10);
        }
        return new Atacar(" Martillazo ", 8);
    }    
}

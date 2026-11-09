package juego.modelo.cartas;

import juego.modelo.Partida;

public class Golpe extends Carta
{
    public Golpe()
    {
        super("Golpe",TipoCarta.ATAQUE,1
        ,"Inflige 6 de daño","golpe");
    }
    @Override 
    public void aplicar(Partida partida)
    {
        partida.atacarJefe(6);
    }    
}

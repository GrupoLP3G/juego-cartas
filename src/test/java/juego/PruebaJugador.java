package juego;

import juego.excepciones.JuegoException;
import juego.modelo.Jugador;
public class PruebaJugador 
{
    public static void main(String[] args) 
    {
        Jugador j1=new Jugador("Fer");
        j1.agregarEscudo(5);
        j1.recibirDanio(8);
        try
        {
            j1.gastarEnergia(2);
            System.out.println("Energia:"+j1.getEnergia());
            j1.gastarEnergia(4);
            j1.gastarEnergia(3);
            System.out.println("Energia:"+j1.getEnergia());
        }catch(JuegoException e){System.out.println(e.getMessage());}
        System.out.println("Vida:"+j1.getVida()+" Escudo:"+j1.getEscudo()+" Esta agotado:"+j1.estaAgotado());
        j1.recibirDanio(100);
        System.out.println(j1.estaVivo());
    }  
}

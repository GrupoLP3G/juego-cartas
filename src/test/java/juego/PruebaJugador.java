package juego;
import juego.modelo.cartas.Carta;
import juego.excepciones.JuegoException;
import juego.modelo.Jugador;
import juego.modelo.cartas.Escudo;
import juego.modelo.cartas.Golpe;
import juego.modelo.cartas.Pocion;
public class PruebaJugador 
{
    public static void main(String[] args) 
    {
        // Jugador j1=new Jugador("Fer");
        // j1.agregarEscudo(5);
        // j1.recibirDanio(8);
        // try
        // {
        //     j1.gastarEnergia(2);
        //     System.out.println("Energia:"+j1.getEnergia());
        //     j1.gastarEnergia(4);
        //     j1.gastarEnergia(3);
        //     System.out.println("Energia:"+j1.getEnergia());
        // }catch(JuegoException e){System.out.println(e.getMessage());}
        // System.out.println("Vida:"+j1.getVida()+" Escudo:"+j1.getEscudo()+" Esta agotado:"+j1.estaAgotado());
        // j1.recibirDanio(100);
        // System.out.println(j1.estaVivo());
        Jugador j1=new Jugador("Fer");
        j1.agregarCartaMano(new Pocion());
        j1.agregarCartaMano(new Golpe());
        j1.agregarCartaMano(new Escudo());
        System.out.print("Cartas actuales:"+j1.getCantidadCartasMano());
        Carta c=j1.quitarCartaMano(1);
        System.out.println("Carta elimindada"+c.getNombre()+"Nueva cantidad"+j1.getCantidadCartasMano());
        
    }  
}

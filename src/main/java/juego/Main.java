package juego;
import java.util.List;
import javax.swing.SwingUtilities;
import juego.controlador.ControladorJuego;
import juego.modelo.Jugador;
import juego.modelo.Mazo;
import juego.modelo.Partida;
import juego.modelo.cartas.Antidoto;
import juego.modelo.cartas.Contraataque;
import juego.modelo.cartas.Escudo;
import juego.modelo.cartas.Golpe;
import juego.modelo.cartas.GolpeDoble;
import juego.modelo.cartas.GolpeFuerte;
import juego.modelo.cartas.Muro;
import juego.modelo.cartas.Pocion;
import juego.modelo.cartas.Robo;
import juego.modelo.jefes.CatalogoJefes;
import juego.modelo.jefes.Jefe;
import juego.vista.VentanaSimple;
public class Main {
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(()->
        {
            Jugador jugador=new Jugador("Fer");
            Jefe jefe=CatalogoJefes.crearAgresivo();
            Mazo mazo=new Mazo(List.of(new Golpe(),new Golpe(),new Golpe(),new Pocion(),new Pocion(),
            new Escudo(),new Escudo(),new Escudo(),new GolpeFuerte(), new GolpeDoble(),
             new Contraataque(), new Muro(),new Antidoto(),new Robo()));
            Partida partida=new Partida(jugador, jefe, mazo);
            ControladorJuego controlador=new ControladorJuego(partida);
            VentanaSimple ventana=new VentanaSimple(controlador);
            partida.agregarObservador(ventana);
            ventana.setVisible(true);
            controlador.iniciar();
        });
    }
}

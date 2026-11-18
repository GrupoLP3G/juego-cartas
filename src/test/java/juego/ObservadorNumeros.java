package juego;
import juego.modelo.ObservadorPartida;
import juego.modelo.Partida;
import juego.modelo.Jugador;
import juego.modelo.jefes.Jefe;
public class ObservadorNumeros implements ObservadorPartida
{
    @Override 
    public void alCambiarPartida(Partida partida)
    {
        Jefe jefe=partida.getJefe();
        Jugador jugador=partida.getJugador();
        System.out.println("[Numeros] Vida:"+jugador.getVida()+" Escudo:"+jugador.getEscudo()+" Energia:"+jugador.getEnergia()
        +" Veneno:"+jugador.getMarcasVeneno()+" Mano:"+jugador.getCantidadCartasMano()+" Jefe:"+jefe.getVida());
    }
    @Override 
    public void alRegistrarMensaje(String mensaje){}
}

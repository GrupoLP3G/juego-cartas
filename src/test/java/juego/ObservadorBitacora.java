package juego;
import juego.modelo.ObservadorPartida;
import juego.modelo.Partida;
public class ObservadorBitacora implements ObservadorPartida
{
    @Override
    public void alCambiarPartida(Partida partida){}
    @Override
    public void alRegistrarMensaje(String mensaje)
    {
        System.out.println("[Bitácora] " + mensaje);
    }
}

package juego.excepciones;

public class PartidaTerminadaException extends JuegoException
{
    public PartidaTerminadaException()
    {
        super("El juego ya ha terminado");
    }
}

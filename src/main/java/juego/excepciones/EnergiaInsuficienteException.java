package juego.excepciones;

public class EnergiaInsuficienteException extends JuegoException
{
    public EnergiaInsuficienteException(int costoCarta,int energia)
    {
        super("Necesitas "+ costoCarta+ " solo tienes "+energia);
    }
}

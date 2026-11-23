package juego.modelo.jefes;

public class CatalogoJefes 
{
    public static Jefe crearAgresivo()
    {
        return new Jefe("Diablo ",40,new EstrategiaAgresivaNormal()
        ,new EstrategiaAgresivaRabia(),70);
    }    
}

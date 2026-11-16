package juego.modelo.jefes;

public class Jefe 
{
    private String nombre;
    private int    vida;
    private int vidaMaxima;
    public Jefe(String nombre,int vidaMaxima)
    {
        this.nombre=nombre;
        this.vidaMaxima=vidaMaxima;
        this.vida=vidaMaxima;
    }
    public String getNombre(){return this.nombre;}
    public int getVida(){return this.vida;}
    public int getvidaMaxima(){return this.vidaMaxima;}
    public boolean estaVivo(){return this.vida>0;}
    public void recibirDanio(int cantidad)
    {
        this.vida-=cantidad;
        if(this.vida<0)this.vida=0;
    }
}

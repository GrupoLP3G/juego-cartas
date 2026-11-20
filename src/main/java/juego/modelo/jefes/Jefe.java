package juego.modelo.jefes;

public class Jefe 
{
    private String nombre;
    private int    vida;
    private int vidaMaxima;
    private AccionJefe intencion;
    public Jefe(String nombre,int vidaMaxima)
    {
        this.nombre=nombre;
        this.vidaMaxima=vidaMaxima;
        this.vida=vidaMaxima;
    }
    public Jefe(Jefe otro)
    {
        this.nombre=otro.nombre;
        this.vidaMaxima=otro.vidaMaxima;
        this.vida=otro.vida;
        this.intencion=otro.intencion;
    }
    public String getNombre(){return this.nombre;}
    public int getVida(){return this.vida;}
    public int getVidaMaxima(){return this.vidaMaxima;}
    public AccionJefe getIntencion(){return this.intencion;}
    public boolean estaVivo(){return this.vida>0;}
    public void recibirDanio(int cantidad)
    {
        this.vida-=cantidad;
        if(this.vida<0)this.vida=0;
    }
    public void decidirIntencion(){this.intencion=new Atacar("Golpe", 5);} //TEMPORAL :despues se decide la estrategia
}
        
package juego.modelo.jefes;

import juego.modelo.Jugador;

public class Jefe 
{
    private String nombre;
    private int    vida;
    private int vidaMaxima;
    private AccionJefe intencion;
    private EstrategiaJefe estrategiaNormal;
    private EstrategiaJefe estrategiaRabia;
    private int porcentajeRabia;
    public Jefe(String nombre,int vidaMaxima,EstrategiaJefe estrategiaNormal
        ,EstrategiaJefe estrategiaRabia,int porcentajeRabia)
    {
        this.nombre=nombre;
        this.vidaMaxima=vidaMaxima;
        this.vida=vidaMaxima;
        this.estrategiaNormal=estrategiaNormal;
        this.estrategiaRabia=estrategiaRabia;
        this.porcentajeRabia=porcentajeRabia;
    }
    public Jefe(Jefe otro)
    {
        this.nombre=otro.nombre;
        this.vidaMaxima=otro.vidaMaxima;
        this.vida=otro.vida;
        this.intencion=otro.intencion;
        this.estrategiaNormal=otro.estrategiaNormal;
        this.estrategiaRabia=otro.estrategiaRabia;
        this.porcentajeRabia=otro.porcentajeRabia;
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
    public void decidirIntencion(Jugador jugador)
    {this.intencion=getEstrategiaActual().elegirAccion(this, jugador);} 
    public boolean estaEnRabia(){return this.vida*100<=this.vidaMaxima*this.porcentajeRabia;}
    private EstrategiaJefe getEstrategiaActual()
    {
        if(estaEnRabia())return this.estrategiaRabia;
        return this.estrategiaNormal;
    }
}
        
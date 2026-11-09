package juego.modelo.cartas;

import juego.modelo.Partida;

public abstract class Carta 
{
    private String nombre;
    private TipoCarta tipo;
    private int costo;
    private String descripcion;
    private String claveImagen;
    protected Carta(String nombre,TipoCarta tipo, int costo,String descripcion,String claveImagen)
    {
        this.tipo=tipo;
        this.nombre=nombre;
        this.costo=costo;
        this.descripcion=descripcion;
        this.claveImagen=claveImagen;
    }   
    public String getNombre(){return this.nombre;}
    public TipoCarta geTipoCarta(){return this.tipo;}
    public int getCosto(){return this.costo;}
    public String getDescripcion(){return this.descripcion;}
    public String getClaveImagen(){return this.claveImagen;}
    public abstract void aplicar (Partida p);
}

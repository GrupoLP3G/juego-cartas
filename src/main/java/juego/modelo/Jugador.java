package juego.modelo;
import java.util.ArrayList;
import java.util.List;

import juego.excepciones.EnergiaInsuficienteException;
import juego.modelo.cartas.Carta;
public class Jugador
{
    private List<Carta> mano;
    private int vida,escudo,energia,marcasVeneno;
    private String nombre;
    private static final int VIDA_MAXIMA=30;
    private static final int ENERGIA_MAXIMA=6;
    public Jugador(String nombre)
    {
        this.mano=new ArrayList<>();
        this.nombre=nombre;
        this.vida=VIDA_MAXIMA;
        this.energia=ENERGIA_MAXIMA;
        this.escudo=0;
        this.marcasVeneno=0;
    }
    public List<Carta> getMano(){return this.mano;}
    public String getNombre(){return this.nombre;}
    public int getVida(){return this.vida;}
    public int getEnergia(){return this.energia;}
    public int getEscudo(){return this.escudo;}
    public int getMarcasVeneno(){return this.marcasVeneno;}
    public int getVidaMaxima(){return VIDA_MAXIMA;}
    public int getEnergiaMaxima(){return  ENERGIA_MAXIMA;}
    public void agregarCartaMano(Carta carta){this.mano.add(carta);}
    public Carta quitarCartaMano(int posicion){return this.mano.remove(posicion);}
    public int getCantidadCartasMano(){return this.mano.size();}
    public boolean estaVivo()
    {
        return this.vida>0;
    }
    public boolean estaAgotado()
    {
        return this.energia==0;
    }
    public void recibirDanio(int cantidad)
    {
        if(this.escudo>=cantidad)
        {
            this.escudo-=cantidad;
        }else
        {
            int danioSobrante =cantidad-this.escudo;
            this.vida-=danioSobrante;
            this.escudo=0;
            if(this.vida<0){this.vida=0;}
        }
    }
    public void perderVida(int cantidad)
    {
        this.vida-=cantidad;
        if(this.vida<0){this.vida=0;}
    }
    public void curar(int cantidad)
    {
        this.vida+=cantidad;
        if(this.vida>VIDA_MAXIMA){this.vida=VIDA_MAXIMA;}
    }
    public void agregarEscudo(int cantidad)
    {
        this.escudo+=cantidad;
    }
    public void  reiniciarEscudo(){this.escudo=0;}
    public void gastarEnergia(int costo) throws EnergiaInsuficienteException
    {
        if(estaAgotado())return;
        if(this.energia<costo)throw new EnergiaInsuficienteException(costo,this.energia);
        this.energia-=costo;
    }
    public void recuperarEnergia(){this.energia=ENERGIA_MAXIMA;}
    public void agregarVeneno(int marcas){this.marcasVeneno+=marcas;}
    public void quitarVeneno(){this.marcasVeneno=0;}
}


package juego.modelo;
import java.util.ArrayList;
import java.util.List;

import juego.excepciones.EnergiaInsuficienteException;
import juego.excepciones.JuegoException;
import juego.excepciones.PartidaTerminadaException;
import juego.modelo.cartas.Carta;
import juego.modelo.jefes.Jefe;
public class Partida 
{
    private Jugador jugador;
    private Jefe jefe;
    private Mazo mazo;
    private int turno=0;
    private static final int CARTAS_EN_MANO=3;
    private List<ObservadorPartida> observadores;
    public Partida(Jugador jugador,Jefe jefe,Mazo mazo)
    {
        this.jugador=jugador;
        this.jefe=jefe;
        this.mazo=mazo;
        this.observadores=new ArrayList<>();
    }
    public Jugador getJugador(){return this.jugador;}
    public Jefe getJefe(){return this.jefe;}
    public Mazo getMazo(){return this.mazo;}
    public int getTurno(){return this.turno;}
    public void iniciarTurno()
    {
        this.turno++;
        this.jugador.reiniciarEscudo();
        if(this.jugador.getMarcasVeneno()>0)
        {
            this.jugador.perderVida(this.jugador.getMarcasVeneno());
            registrar("El veneno te quito "+this.jugador.getMarcasVeneno());
        }
        anunciarFinSiTermino();
        robarCartas(CARTAS_EN_MANO-this.jugador.getMano().size());
        registrar("Comienza el turno "+this.turno);
        notificarCambio();
    }
    public void jugarCarta(int posicion) throws JuegoException
    {
        if(isTerminada()) throw new PartidaTerminadaException();
        if(posicion<0||posicion>=this.jugador.getMano().size())throw new JuegoException("Esa carta no existe");
        Carta carta=this.jugador.getMano().get(posicion);
        if(!(this.jugador.puedePagar(carta.getCosto())))throw new EnergiaInsuficienteException(carta.getCosto(),this.jugador.getEnergia());
        registrar("Usaste "+carta.getNombre() );
        this.jugador.quitarCartaMano(posicion);
        carta.aplicar(this);
        this.jugador.gastarEnergia(carta.getCosto());
        this.mazo.descartar(carta);
        anunciarFinSiTermino();
        notificarCambio();
    }
    public void terminarTurno()throws PartidaTerminadaException
    {
        if(isTerminada())throw new PartidaTerminadaException();
        daniarJugador(5); //TEMPORAL hasta que los jefes ya tengan su estrategia
        if(isTerminada())
        {
            anunciarFinSiTermino();
            notificarCambio();
        }else iniciarTurno();
    }
    public boolean isTerminada(){return !(this.jugador.estaVivo())||!(this.jefe.estaVivo());}
    public boolean isGanada(){return !(this.jefe.estaVivo())&& this.jugador.estaVivo();}
    public void atacarJefe(int danio) 
    {
        int danioFinal=aplicarDebilidad(danio);
        this.jefe.recibirDanio(danioFinal);
        registrar("Hiciste "+danioFinal+" de daño a "+this.jefe.getNombre());
    }
    public void agregarEscudo(int cantidad)
    {
        int cantidadFinal=aplicarDebilidad(cantidad);
        this.jugador.agregarEscudo(cantidadFinal);
        registrar("Ganaste "+cantidadFinal+" de escudo");
    }
    public void curarJugador(int cantidad)
    {
        int vidaAntes=this.jugador.getVida();
        int cantidadFinal=aplicarDebilidad(cantidad);
        this.jugador.curar(cantidadFinal);
        int vidaRecuperada=this.jugador.getVida()-vidaAntes;
        registrar("Recuperaste "+vidaRecuperada+" de vida");
    }
    public void quitarVeneno()
    {
        this.jugador.quitarVeneno();
        registrar("Te curaste del veneno");
    }
    public void robarCartas(int cantidad)
    {
        for(int i=0;i<cantidad;i++)
        {
            Carta carta=this.mazo.robar();
            if(carta==null)break;
            this.jugador.agregarCartaMano(carta);
        }
    }
    public void daniarJugador(int danio)
    {
        int danioFinal=aplicarVulnerabilidad(danio);
        this.jugador.recibirDanio(danioFinal);
        registrar(this.jefe.getNombre()+" te hizo "+danioFinal+" de daño");
    }
    public void envenenarJugador(int marcas)
    {
        this.jugador.agregarVeneno(marcas);
        registrar(this.jefe.getNombre()+" te enveneno");

    }
    public void agregarObservador(ObservadorPartida observador){this.observadores.add(observador);}
    public void quitarObservador(ObservadorPartida observador){this.observadores.remove(observador);}
    private int aplicarDebilidad(int valor)
    {
        if(this.jugador.estaAgotado()) return valor/2;
        return valor;
    }
    private int aplicarVulnerabilidad(int danio)
    {
        if(this.jugador.estaAgotado())return danio*3/2;
        return danio;
    }
    private void notificarCambio()
    {
        for(ObservadorPartida observador:this.observadores)
        {
            observador.alCambiarPartida(this);
        }
    }
    private void anunciarFinSiTermino()
    {
        if(!(isTerminada()))return ;
        if(isGanada()) registrar("GANASTE");
        else registrar("PERDISTE");
    }
    public void registrar(String mensaje)
    {
        for(ObservadorPartida observador:this.observadores)
        {
            observador.alRegistrarMensaje(mensaje);
        }
    }   
}

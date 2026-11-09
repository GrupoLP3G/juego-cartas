package juego.modelo;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import juego.modelo.cartas.Carta;
public class Mazo 
{
    private List<Carta> cartasPorRobar;
    private List<Carta> descarte;
    public Mazo(List<Carta> cartasIniciales)
    {
        this.cartasPorRobar=new ArrayList<>();
        this.cartasPorRobar.addAll(cartasIniciales);
        this.descarte=new ArrayList<>();
        Collections.shuffle(this.cartasPorRobar);
    }    
    private void rebarajarDescarte()
    {
        this.cartasPorRobar.addAll(this.descarte);
        Collections.shuffle(this.cartasPorRobar);
        this.descarte.clear();
    }
    public Carta robar()
    {
        if(this.cartasPorRobar.isEmpty())
        {
            rebarajarDescarte();
            if(this.cartasPorRobar.isEmpty()) return null;// Devuelve null si no quedan cartas ni en el mazo ni en el descarte
        }
        return this.cartasPorRobar.remove(0);

    }
    public void descartar(Carta carta){this.descarte.add(carta);}
    public int getCantidadPorRobar(){return this.cartasPorRobar.size();}
    public int getCantidadDescarte(){return this.descarte.size();}
}

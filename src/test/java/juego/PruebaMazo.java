package juego;

import java.util.ArrayList;
import java.util.List;

import juego.modelo.Mazo;
import juego.modelo.cartas.Carta;
import juego.modelo.cartas.Escudo;
import juego.modelo.cartas.Golpe;
import juego.modelo.cartas.Pocion;

public class PruebaMazo 
{
    public static void main(String[] args) 
    {
        Mazo m1=new Mazo(List.of(new Golpe(), new Escudo(), new  Pocion()));
        Carta c1=m1.robar();
        Carta c2=m1.robar();
        Carta c3=m1.robar();
        System.out.println("Numero de cartas:"+m1.getCantidadPorRobar());
        m1.descartar(c1);
        m1.descartar(c3);
        Carta c4=m1.robar();
        System.out.println("Después de rebarajar: robé " + c4.getNombre() + ", quedan " + m1.getCantidadPorRobar());
        Carta c5=m1.robar();
        System.out.println("Por rrobar:"+m1.getCantidadPorRobar()+" Descarte:"+m1.getCantidadDescarte()
        +" Robar:"+m1.robar());   
    }    
}

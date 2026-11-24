package juego;

import java.util.List;

import juego.modelo.Jugador;
import juego.modelo.Mazo;
import juego.modelo.Partida;
import juego.modelo.cartas.Antidoto;
import juego.modelo.cartas.Carta;
import juego.modelo.cartas.Contraataque;
import juego.modelo.cartas.Golpe;
import juego.modelo.cartas.GolpeDoble;
import juego.modelo.cartas.GolpeFuerte;
import juego.modelo.cartas.Muro;
import juego.modelo.cartas.Robo;
import juego.modelo.jefes.Jefe;

public class PruebaCartas
{
    private static Partida crearPartida(ObservadorNumeros numeros, ObservadorBitacora bitacora)
    {
        Jugador jugador = new Jugador("Fer");
        Jefe jefe = new Jefe("El malo", 100, new EstrategiaFija(), new EstrategiaFija(), 0);
        Mazo mazo = new Mazo(List.of(new Golpe(), new Golpe(), new Golpe(), new Golpe(), new Golpe(),
        new Golpe(), new Golpe(), new Golpe(), new Golpe(), new Golpe()));
        Partida partida = new Partida(jugador, jefe, mazo);
        partida.agregarObservador(numeros);
        partida.agregarObservador(bitacora);
        return partida;
    }

    private static void probarCarta(Carta carta, String esperado)
    {
        ObservadorNumeros numeros = new ObservadorNumeros();
        ObservadorBitacora bitacora = new ObservadorBitacora();
        Partida partida = crearPartida(numeros, bitacora);
        System.out.println("---- " + carta.getNombre() + " ----");
        carta.aplicar(partida);
        numeros.alCambiarPartida(partida);
        System.out.println("Esperado: " + esperado);
    }

    private static void probarAntidoto()
    {
        ObservadorNumeros numeros = new ObservadorNumeros();
        ObservadorBitacora bitacora = new ObservadorBitacora();
        Partida partida = crearPartida(numeros, bitacora);
        System.out.println("---- Antidoto ----");
        partida.envenenarJugador(3);
        numeros.alCambiarPartida(partida);
        new Antidoto().aplicar(partida);
        numeros.alCambiarPartida(partida);
        System.out.println("Esperado: Veneno:3 y luego Veneno:0");
    }

    public static void main(String[] args)
    {
        probarCarta(new GolpeFuerte(), "Jefe:90");
        probarCarta(new GolpeDoble(), "Jefe:92");
        probarCarta(new Contraataque(), "Jefe:97 y Escudo:3");
        probarCarta(new Muro(), "Escudo:10");
        probarAntidoto();
        probarCarta(new Robo(), "Mano:2");
    }
} 
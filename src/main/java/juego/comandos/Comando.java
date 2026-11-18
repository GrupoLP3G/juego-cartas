package juego.comandos;

import juego.excepciones.JuegoException;

public interface Comando 
{
    public void ejecutar() throws JuegoException;
    public void deshacer();    
}

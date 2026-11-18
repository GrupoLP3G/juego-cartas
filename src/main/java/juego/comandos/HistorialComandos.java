package juego.comandos;

import java.util.ArrayDeque;
import java.util.Deque;

import juego.excepciones.JuegoException;

public class HistorialComandos 
{
    private Deque<Comando> pilaDeshacer;
    private Deque<Comando> pilaRehacer;
    public HistorialComandos()
    {
        this.pilaDeshacer=new ArrayDeque<>();
        this.pilaRehacer=new ArrayDeque<>();
    }
    public void ejecutar(Comando comando) throws JuegoException
    {
        comando.ejecutar();
        this.pilaDeshacer.push(comando);
        this.pilaRehacer.clear();

    }
    public void deshacer()
    {   
        if(this.pilaDeshacer.isEmpty()) return ;
        Comando comando=this.pilaDeshacer.pop();
        comando.deshacer();
        this.pilaRehacer.push(comando);
    }
    public void rehacer()throws JuegoException
    {
        if(this.pilaRehacer.isEmpty()) return ;
        Comando comando=this.pilaRehacer.pop();
        comando.ejecutar();
        this.pilaDeshacer.push(comando);
    }
    public boolean puedeDeshacer() {return !(this.pilaDeshacer.isEmpty()); }
    public boolean puedeRehacer() {return !(this.pilaRehacer.isEmpty());}
    public void limpiar()
    {
        this.pilaDeshacer.clear();
        this.pilaRehacer.clear();
    }    

}

package modelo.pieza;

import modelo.jugador.Sector;
import modelo.pieza.movimiento.*;
import modelo.pieza.recibirDanio.*;
import modelo.pieza.sanacion.*;
import modelo.tablero.Tablero;

public abstract class Pieza {
    private int costo;
    private int vida_maxima;
    private double vida;
    protected Ubicacion ubicacion;
    private int equipo;
    // strategy pattern
    private IModoMovimiento modoMovimiento;
    private ICalculadorDeDanio danioARecibir;
    private IModoSanacion modoSanacion;

    // Constructores
    public Pieza(int costo, int vidaMaxima, int equipo, IModoMovimiento modoMovimiento, IModoSanacion modoSanacion, int posX, int posY) {
        this.costo = costo;
        this.vida_maxima = vidaMaxima;
        this.vida = vidaMaxima;
        this.equipo = equipo;
        this.modoMovimiento = modoMovimiento;
        this.modoSanacion = modoSanacion;
        // verificar si esta en su zona consultando a tablero?
        this.ubicacion = new Ubicacion(posX, posY);
        this.danioARecibir = new DanioZonaPropia();
    }

    // SETTER GETTER

    public void setVida(double vida){
        this.vida = vida;
    }

    public double getPuntosVida(){
        return vida;
    }

    public Ubicacion getUbicacion(){
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion){
        this.ubicacion = ubicacion;
    }

    public int getEquipo(){ return equipo;}

    public int getCosto(){ return costo;}

    public boolean esEnemigo(Pieza otra){
        return (this.getEquipo() != otra.getEquipo());
    }

    // METODOS

    public void evaluarZonaDeDanio(Sector sector) {
        if (sector.esDelSector(ubicacion.getPosicionEnX())) { this.danioARecibir = new DanioZonaEnemiga(); }
        else this.danioARecibir = new DanioZonaPropia();
    } //Variara dependiendo de donde lo recibe. Incluso puede hacer un new Sector (equipo) y ya esta

    public void recibirDanio(double danioBase) throws UnidadEstaMuertaException {
        if (vida<=0) throw new UnidadEstaMuertaException();
        vida-= danioARecibir.danio(danioBase);
        vida = Math.max(vida, 0);
    }

    public void sanar(int puntos) throws UnidadNoSePuedeCurar {
        vida += modoSanacion.restaurarPuntosDeVida(puntos);
        vida = Math.min(vida, vida_maxima);
    }

    public void moverArriba() throws NoSePuedeMoverException {
        Ubicacion nueva = modoMovimiento.arriba(this.getUbicacion());
        this.setUbicacion(nueva);
    }

    public void mover(Tablero tablero, Direccion direccion) throws NoSePuedeMoverException {
        Ubicacion anterior = this.getUbicacion();
        int nuevoX = anterior.getPosicionEnX()+ direccion.getDesplazamientoEnX();
        int nuevoY = anterior.getPosicionEnY() + direccion.getDesplazamientoEnY();
        /* ver q la ubicacion sea valida, que no se salga de los parametros del tablero */

        if ( !tablero.casillaEstaOcupada(nuevoX, nuevoY)){
            this.setUbicacion(new Ubicacion(nuevoX, nuevoY));
            //this.evaluarZonaDeDanio(sector);
            tablero.ocuparCasilla(this,nuevoX, nuevoY);
            tablero.desocuparCasilla(anterior.getPosicionEnX(), anterior.getPosicionEnY());
        } else{
            throw new NoSePuedeMoverException();
        }
    }

    public abstract String getNombre();
}
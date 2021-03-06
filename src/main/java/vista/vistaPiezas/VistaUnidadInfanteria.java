package vista.vistaPiezas;

import modelo.Juego;
import modelo.pieza.tipos.Infanteria;
import vista.VistaDeTablero;
import vista.fasesPartida.faseMediaPartida.botonesFaseMedia.BotonCrearBatallon;
import vista.fasesPartida.faseMediaPartida.botonesFaseMedia.BotonMoverBatallon;

public class VistaUnidadInfanteria extends VistaUnidadAtacante {

    Infanteria infanteria;
    public VistaUnidadInfanteria(Infanteria piezaAtacante, VistaDeTablero vistaDeTablero, String nombre, Juego juego) {
        super(piezaAtacante, vistaDeTablero, nombre, juego);
        this.infanteria=piezaAtacante;

    }

    public void barraDeOpciones() {
        super.barraDeOpciones();
        barraDeOpcionesDeUnidad.getChildren().add(new BotonCrearBatallon(piezaAtacante,vistaDeTablero,barraDeOpcionesDeUnidad));
        barraDeOpcionesDeUnidad.getChildren().add(new BotonMoverBatallon(this,vistaDeTablero,barraDeOpcionesDeUnidad));

    }

    public Infanteria getPieza(){
        return infanteria;
    }

}

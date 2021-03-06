package vista.vistaPiezas;

import modelo.Juego;
import modelo.pieza.ataque.PiezaAtacante;
import vista.VistaDeTablero;
import vista.fasesPartida.faseMediaPartida.botonesFaseMedia.BotonAtacar;

public class VistaUnidadCatapulta extends VistaUnidadAtacante {
    public VistaUnidadCatapulta(PiezaAtacante piezaAtacante, VistaDeTablero vistaDeTablero, String nombre, Juego juego) {
        super(piezaAtacante, vistaDeTablero, nombre, juego);

    }

    public void barraDeOpciones() {
        actualizacionVistaDeOpciones();
        barraDeOpcionesDeUnidad.getChildren().clear();
        barraDeOpcionesDeUnidad.getChildren().add(new BotonAtacar(piezaAtacante,  vistaDeTablero, barraDeOpcionesDeUnidad));
    }


}

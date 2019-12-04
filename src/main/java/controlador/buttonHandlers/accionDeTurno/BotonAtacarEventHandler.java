package controlador.buttonHandlers.accionDeTurno;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import modelo.Juego;
import modelo.pieza.ataque.PiezaAtacante;
import resources.sonidos.Audio;
import vista.VistaDeTablero;


public class BotonAtacarEventHandler implements EventHandler<ActionEvent> {
private Label comunicador;
private VistaDeTablero vistaDeTablero;
private PiezaAtacante piezaAtacante;
private HBox barra;


    public BotonAtacarEventHandler(PiezaAtacante piezaAtacante, Label comunicador, VistaDeTablero vistaDeTablero, HBox barraDeOpcionesDeUnidad){
    this.comunicador = comunicador;
    this.vistaDeTablero = vistaDeTablero;
    this.piezaAtacante = piezaAtacante;
    this.barra = barraDeOpcionesDeUnidad;
}

    @Override
    public void handle(ActionEvent event) {
        this.comunicador.setText("Haga click a la pieza a la que desea atacar");
        this.comunicador.setTextFill(Color.web("#336600"));
        vistaDeTablero.tableroEnModoAtaque(piezaAtacante);
        barra.setVisible(false);
        Audio.reproducirInterfaz("click");
    }
}

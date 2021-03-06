package vista.fasesPartida.faseMediaPartida;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;


public class BarraDeJugador extends VBox {

    private Rectangle fondoDeNombreJugador = new Rectangle(300,45,Color.rgb(0,0,0,0.1));
    private Label comunicador;
    private String nombre;

    public BarraDeJugador(String nombreDeJugador, int numeroJugador) {
        this.setSpacing(15);
        nombre=nombreDeJugador;
        grabarNombre(nombreDeJugador, numeroJugador);
        comunicador=  new Label("Presiona una pieza y comienza el juego.");
        this.getChildren().add(comunicador);
    }

    public void grabarNombre (String nombreDeJugador, int numeroJugador){
        Label etiqueta = new Label();
        etiqueta.setFont(new Font( "Arial", 15));
        etiqueta.setText(" Jugador: " + nombreDeJugador);
        etiqueta.setAlignment(Pos.CENTER);
        if (numeroJugador == 1) etiqueta.setTextFill(Color.web("0075FF"));
        else etiqueta.setTextFill(Color.web("FF821F"));
        StackPane panelNombre = new StackPane();
        panelNombre.getChildren().add(fondoDeNombreJugador);
        panelNombre.getChildren().add(etiqueta);
        this.getChildren().add(panelNombre);

    }

    public void invertirEstadoDeshabilitado(){
        if (this.isDisable()) this.setDisable(false);
        else this.setDisable(true);
    }


    public void agregarAVista(VistaPiezaClikeada vistaDePiezaClikeada, String nombreJugadorTurno) {
        if (nombre==nombreJugadorTurno){
            vistaDePiezaClikeada.vistaMensaje("Puede pasar de turno cuando desee.");
            this.getChildren().add(vistaDePiezaClikeada);
        }
    }

    public void vistaAlertas(String texto,String nombreJugadorTurno) {
        if (nombre==nombreJugadorTurno) {
            comunicador.setTextFill(Color.web("#FF0000"));
            comunicador.setText(texto);
        }
    }

}

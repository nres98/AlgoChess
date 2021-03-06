package vista.fasesPartida.faseInicialPartida.botonesAgregarPiezas;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import modelo.Juego;
import modelo.pieza.Pieza;
import modelo.pieza.tipos.Catapulta;
import modelo.pieza.tipos.Curandero;
import modelo.pieza.tipos.Infanteria;
import modelo.pieza.tipos.Jinete;
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.BarraLateralOpciones;
import vista.vistaPiezas.VistaInformacionDeUnidad;

public class ContenedorElegirPieza extends GridPane {

    private BotonAgregarInfanteria btnInfanteria;
    private BotonAgregarCurandero btnCurandero;
    private  BotonAgregarJinete btnJinete;
    private BotonAgregarCatapulta botonCatapulta;

    public ContenedorElegirPieza(VistaDeTablero vistaDeTablero, BarraLateralOpciones vistaLateral, Juego juego) {

        btnInfanteria = new BotonAgregarInfanteria(vistaDeTablero, vistaLateral, juego);
        btnCurandero = new BotonAgregarCurandero(vistaDeTablero, vistaLateral, juego);
        btnJinete = new BotonAgregarJinete(vistaDeTablero, vistaLateral, juego);
        botonCatapulta = new BotonAgregarCatapulta(vistaDeTablero, vistaLateral, juego);

        cargarContenedor();
        fondoContenedor();

    }

    private void fondoContenedor() {
        Image imangenMuro = new Image("resources/texturas/fondocompra.png");
        Background fondoDeContenedor = new Background(new BackgroundImage(imangenMuro,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(300, 400, false, false, false, false)));
        this.setBackground(fondoDeContenedor);
    }

    private void cargarContenedor(){
        this.add(contenedorDePieza(btnInfanteria,"infanteria",new Infanteria()), 0, 0);
        this.add(contenedorDePieza(btnCurandero,"curandero",new Curandero()), 0, 1);
        this.add(contenedorDePieza(btnJinete,"jinete",new Jinete()), 1, 0);
        this.add(contenedorDePieza(botonCatapulta,"catapulta",new Catapulta()), 1, 1);
        this.setAlignment(Pos.CENTER);
        this.autosize();
    }

    private VBox contenedorDePieza(Button boton, String nombre, Pieza pieza) {
        VistaInformacionDeUnidad vistaInformacion = new VistaInformacionDeUnidad(nombre, pieza);
        vistaInformacion.setAlignment(Pos.CENTER);
        VBox piezaVistaContenedor = new VBox(5);
        vistaInformacion.setAlignment(Pos.CENTER);
        piezaVistaContenedor.getChildren().addAll(vistaInformacion, boton);
        piezaVistaContenedor.setSpacing(10);
        return piezaVistaContenedor;

    }

}

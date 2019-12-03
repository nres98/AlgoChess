package vista;


import controlador.ClickEnPiezaEventHandler;
import controlador.ClickEnZonaEventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modelo.pieza.Ubicacion;
import modelo.tablero.Tablero;
import vista.vistaPiezas.VistaUnidad;
import vista.vistaPiezas.VistaUnidadParaTablero;


public class VistaDeTablero extends Group {

    public int altura;
    public int anchura;
    private int alturaCelda = 45;
    private int anchuraCelda = 45;
    private Tablero tablero;
    private Rectangle rectanguloDeMovimiento = new Rectangle(45,45,Color.rgb(0,0,0,0.4));
    private GridPane contenedorTabla;
    private Pane[][] casillaTabla;
    private Ubicacion ubicacionDelCursor;
    private VistaUnidadParaTablero vistaUnidadClikeada;

    public VistaDeTablero(Tablero tablero){

        this.tablero = tablero;
        this.ubicacionDelCursor =new Ubicacion(9,9);
        this.vistaUnidadClikeada =new VistaUnidadParaTablero(this);
        contenedorTabla = new GridPane();
        anchura = anchuraCelda * tablero.getColumnas();
        altura = alturaCelda * tablero.getFilas();
        casillaTabla = new Pane[anchura][altura];
        contenedorTabla.add(rectanguloDeMovimiento,9,9);

        for (int i = 0; i < tablero.getColumnas(); i++) {
            for (int j = 0; j < tablero.getFilas(); j++) {
                Pane v = new Pane();
                v.setOnMouseClicked(new ClickEnZonaEventHandler(rectanguloDeMovimiento,v, ubicacionDelCursor));
                v.setMinHeight(this.alturaCelda);
                v.setMinWidth(this.anchuraCelda);
                casillaTabla[i][j] = v;
                contenedorTabla.add(v , i, j);
            }
        }

        Background fondoDeContenedor = new Background(new BackgroundImage(new Image("resources/texturas/tablero.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(this.anchura, this.altura, false, false, false, false)));
        contenedorTabla.setBackground(fondoDeContenedor);

        this.getChildren().add(contenedorTabla);
    }

    public Ubicacion getUbicacionDelCursor(){return ubicacionDelCursor;}
    public VistaUnidadParaTablero getVistaDePiezaClikeada(){return vistaUnidadClikeada;}

    public void agregarUnidad(VistaUnidadParaTablero etiquetaUnidad, int x, int y){
        GridPane.setRowIndex(etiquetaUnidad, x);
        GridPane.setColumnIndex(etiquetaUnidad, y);
        contenedorTabla.getChildren().add(etiquetaUnidad);
        //addViewOnMap(unidad, x, y);
        casillaTabla[x][y].getChildren().add(0, etiquetaUnidad);
        etiquetaUnidad.setOnMouseClicked(new ClickEnPiezaEventHandler(vistaUnidadClikeada, etiquetaUnidad));
    }

    public void addViewOnMap(Node view, int x, int y) {
        for (int i = 0; i < anchura; i++) {
            for (int j = 0; j < altura; j++) {
                try {
                    casillaTabla[i][j].getChildren().remove(view);
                } catch (Exception e) {
                    //TODO: handle exception
                }
            }
        }
        casillaTabla[x][y].getChildren().add(0, view);
    }

    public void updateView(Node view) {
        getChildren().remove(view);
        getChildren().add(view);
    }

    public Tablero getTablero(){ return tablero;}

}
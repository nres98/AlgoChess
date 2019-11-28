package modelo.pieza.movimiento;

public class AbajoIzquierda  extends Direccion{
    static final int DESPLAZAMIENTO_X = -1;
    static final int DESPLAZAMIENTO_Y = 1;

    public AbajoIzquierda(){
        super(DESPLAZAMIENTO_X,DESPLAZAMIENTO_Y);
    }

}
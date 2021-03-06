package modelo.tablero;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import modelo.pieza.Pieza;
import org.mockito.Mockito;

public class ColumnaTest {

    @Test
    public void test01ColumnaGuardaNumeroDeCasillasIgualAFilasEsperadas(){
        Columna columna = new Columna(20);
        assertEquals(20,columna.getTamanio());
    }

    @Test
    public void test02ElEstadoDeLasCasillasDeUnaColumnaNuevaEsLibre(){
        Columna columna = new Columna(20);
        for (int numeroCasilla=0; numeroCasilla <  20; numeroCasilla++)
            assertEquals(false,columna.casillaDeLaFilaEstaOcupada(numeroCasilla));
    }

    @Test
    public void test03ElEstadoDeUnaCasillaLibreALaQueOcupoPasaAOcupado(){
        Columna columna = new Columna(20);
        Pieza pieza = Mockito.mock(Pieza.class);
        columna.ocuparCasilla(pieza, 1);
        assertEquals(true,columna.casillaDeLaFilaEstaOcupada(1));
    }

    @Test
    public void test04ElEstadoDeUnaCasillaALaQueOcupoPasaADesocupadaCuandoLaDesocupo(){
        Columna columna = new Columna(20);
        Pieza pieza = Mockito.mock(Pieza.class);
        columna.ocuparCasilla(pieza, 1);
        columna.desocuparCasilla(1);
        assertEquals(false,columna.casillaDeLaFilaEstaOcupada(1));
    }

    @Test
    public void test05OcuparUnaCasillaDeLaColumnaNoModificaElEstadoDeOtraCasillaLibre(){
        Columna columna = new Columna(20);
        Pieza pieza = Mockito.mock(Pieza.class);
        columna.ocuparCasilla(pieza, 1);
        assertEquals(false,columna.casillaDeLaFilaEstaOcupada(2));
    }

    @Test
    public void test06DesocuparUnaCasillaDeLaColumnaNoModificaElEstadoDeOtraCasillaOcupada(){
        Columna columna = new Columna(20);
        Pieza pieza = Mockito.mock(Pieza.class);
        columna.ocuparCasilla(pieza, 1);
        columna.ocuparCasilla(pieza, 2);
        columna.desocuparCasilla(1);
        assertEquals(true,columna.casillaDeLaFilaEstaOcupada(2));
    }
}

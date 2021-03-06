package modelo.jugador;

import modelo.jugador.presupuesto.CompraInvalidaException;
import modelo.pieza.tipos.Infanteria;
import org.junit.Test;
import modelo.pieza.tipos.Catapulta;
import modelo.pieza.tipos.Curandero;
import modelo.pieza.tipos.Jinete;

import static org.junit.Assert.assertEquals;



public class FabricaDePiezasTest {
    @Test
    public void test01PidoUnaPiezaInfanteriaYMeDanPiezaDeInfanteria() throws CompraInvalidaException {
        FabricaDePiezas fabrica = new FabricaDePiezas();
        assertEquals(Infanteria.class, fabrica.crearPieza(1,"Infanteria",1,1).getClass());
    }

    @Test
    public void test02PidoUnaPiezaCuranderoYMeDanPiezaCurandero() throws CompraInvalidaException {
        FabricaDePiezas fabrica = new FabricaDePiezas();
        assertEquals(Curandero.class, fabrica.crearPieza(1,"Curandero",1,1).getClass());
    }

    @Test
    public void test03PidoUnaPiezaJineteYMeDanPiezaJinete() throws CompraInvalidaException {
        FabricaDePiezas fabrica = new FabricaDePiezas();
        assertEquals(Jinete.class, fabrica.crearPieza(1,"Jinete",1,1).getClass());
    }

    @Test
    public void test04PidoUnaPiezaDeCatapultaYMeDanPiezaCatapulta() throws CompraInvalidaException {
        FabricaDePiezas fabrica = new FabricaDePiezas();
        assertEquals(Catapulta.class, fabrica.crearPieza(1,"Catapulta",1,1).getClass());
    }

    @Test(expected = CompraInvalidaException.class)
    public void test05PidoUnaPiezaInvalidaYMeDanException() throws CompraInvalidaException {
        FabricaDePiezas fabrica = new FabricaDePiezas();
        fabrica.crearPieza(1,"JineteCuranderoConCatapultaArrojaInfantesEnAmarillo",1,1);
    }

}



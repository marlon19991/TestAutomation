package Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MiTest {
    private int numeroUno = 5;
    private int numeroDos = 3;

    @Test
    public void testNumeroVerdadero() {
        Assert.assertTrue(numeroUno==numeroDos+2, "El número no es verdadero, "+String.valueOf("número uno no es igual a número dos"));
    }

    @Test
    public void testNumeroFalso() {
        Assert.assertFalse(numeroUno==numeroDos);
    }

    @Test
    public void testNumerosIguales() {
        Assert.assertEquals(numeroUno+10, numeroDos+12);
    }

    @Test
    public void testNumerosNoIguales() {
        Assert.assertNotEquals(numeroUno-1, numeroDos*514);
    }

    @Test
    public void testNulo() {
        Personas persona = new Personas("Pepe", "Gonzales");
        Assert.assertNotNull(persona);
    }

    @Test
    public void testNoNulo() {
        Personas persona = null;
        Assert.assertNull(persona);
    }

    @Test
    public void noMismoObjeto() {
        Personas persona = new Personas("Pepe", "Gonzales");
        Personas personaDos = new Personas("Pepe", "Gonzales");
        Assert.assertNotSame(persona,personaDos);
    }

    @Test
    public void mismoObjeto() {
        Personas persona = new Personas("Pepe", "Gonzales");
        Personas personaDos = persona;
        Assert.assertSame(persona,personaDos);
    }

}

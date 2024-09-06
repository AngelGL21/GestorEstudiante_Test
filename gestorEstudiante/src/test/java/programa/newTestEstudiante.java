/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package programa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class newTestEstudiante {

    @Test
    void testAgregarNota() {
        Estudiante estudiante = new Estudiante("Juan");
        estudiante.agregarNota(85);
        estudiante.agregarNota(90);

        System.out.println("Notas  de " +estudiante.getNombre()+ " agregadas:" + estudiante.getNotas());

        assertEquals(2, estudiante.getNotas().size(), "El estudiante debería tener 2 notas agregadas.");
        assertTrue(estudiante.getNotas().contains(85), "La nota 85 debería estar en la lista.");
        assertTrue(estudiante.getNotas().contains(90), "La nota 90 debería estar en la lista.");
    }

    @Test
    void testCalcularPromedio() {
        Estudiante estudiante = new Estudiante("Maria");
        estudiante.agregarNota(60);
        estudiante.agregarNota(70);
        estudiante.agregarNota(80);

        double promedio = estudiante.calcularPromedio();
        System.out.println("Promedio de Maria calculado es de: " + promedio);

        assertEquals(70.0, promedio, 0.001, "El promedio debería ser 70.0");
    }

    @Test
    void testHaAprobado() {
        Estudiante estudiante = new Estudiante("Carlos");
        estudiante.agregarNota(65);
        estudiante.agregarNota(75);

        boolean aprobadoInicial = estudiante.haAprobado();
        System.out.println("¿Carlos ha aprobado antes de agregar nota baja? " + aprobadoInicial);

        assertTrue(aprobadoInicial, "El estudiante debería haber aprobado.");

        estudiante.agregarNota(30);

        boolean aprobadoFinal = estudiante.haAprobado();
        System.out.println("¿Carlos ha aprobado después de agregar nota baja? " + aprobadoFinal);

        assertFalse(aprobadoFinal, "El estudiante debería reprobar si el promedio es menor a 60.");
    }
}

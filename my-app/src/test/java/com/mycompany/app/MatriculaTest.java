package com.mycompany.app;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Vector;

public class MatriculaTest {
    private Matricula matricula;

    //Cree una prueba de unidad para la clase Matricula que verifique que se lanza una excepción cuando el vector de
    //asignaturas es nulo. No es necesario usar mocks.

    @Test
    public void testGetImporteThrowsException(){
        matricula = new Matricula(null);
        assertThrows(Exception.class, () -> matricula.getImporte());
    }

    //prueba usando mockito
    @Test
    public void testGetImporteThrowsException2(){
        Vector<Asignatura> asignaturas = Mockito.mock(Vector.class);
        matricula = new Matricula(asignaturas);
        assertThrows(Exception.class, () -> matricula.getImporte());
    }

    //Cree una prueba de unidad para la clase Matricula que verifique que el importe devuelto es correcto  Se deben usar mocks.
    @Test
    public void testGetImporte() throws Exception {
         // Arrange: Crear mocks de Asignatura
        Asignatura asignatura1 = Mockito.mock(Asignatura.class);
        Asignatura asignatura2 = Mockito.mock(Asignatura.class);
        Asignatura asignatura3 = Mockito.mock(Asignatura.class);
        // Configurar los valores retornados por getImporte
        when(asignatura1.getImporte()).thenReturn(100.0);
        when(asignatura2.getImporte()).thenReturn(150.0);
        when(asignatura3.getImporte()).thenReturn(200.0);
        // Crear un vector con los mocks
        Vector<Asignatura> asignaturas = new Vector<>();
        asignaturas.add(asignatura1);
        asignaturas.add(asignatura2);
        asignaturas.add(asignatura3);
        // Crear una instancia de Matricula con el vector de asignaturas
        matricula = new Matricula(asignaturas);
        double importe = matricula.getImporte();
        assertEquals(450, importe);
    }
    // crear una prueba para la clase matricula que verifique que el método getimporte() recorre todas las asignaturas de vectorAsignaturas
    @Test
    public void testGetImporteRecorreTodasAsignaturas() throws Exception {
        // Arrange: Crear mocks de Asignatura
        Asignatura asignatura1 = Mockito.mock(Asignatura.class);
        Asignatura asignatura2 = Mockito.mock(Asignatura.class);
        Asignatura asignatura3 = Mockito.mock(Asignatura.class);
        // Configurar los valores retornados por getImporte
        when(asignatura1.getImporte()).thenReturn(100.0);
        when(asignatura2.getImporte()).thenReturn(150.0);
        when(asignatura3.getImporte()).thenReturn(200.0);
        // Crear un vector con los mocks
        Vector<Asignatura> asignaturas = new Vector<>();
        asignaturas.add(asignatura1);
        asignaturas.add(asignatura2);
        asignaturas.add(asignatura3);
        // Crear una instancia de Matricula con el vector de asignaturas
        matricula = new Matricula(asignaturas);
        // Act: Llamar al método getImporte
        matricula.getImporte();
        // Assert: Verificar que el método getImporte fue llamado en cada asignatura
        verify(asignatura1, times(1)).getImporte();
        verify(asignatura2, times(1)).getImporte();
        verify(asignatura3, times(1)).getImporte();
    }


}

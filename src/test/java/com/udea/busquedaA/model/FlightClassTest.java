package com.udea.busquedaA.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlightClassTest {

    private FlightClass flightClass;

    @BeforeEach
    void setUp() {
        // Inicializamos un FlightClass con datos de ejemplo
        flightClass = new FlightClass(1, "Business", 3, 100, null);
    }

    // Test para el constructor sin parámetros
    @Test
    void testNoArgsConstructor() {
        FlightClass emptyFlightClass = new FlightClass();
        assertNull(emptyFlightClass.getFlightClassName(), "El nombre de la clase debería ser nulo para el constructor vacío.");
        assertNull(emptyFlightClass.getLuggageAmount(), "La cantidad de equipaje debería ser nula para el constructor vacío.");
        assertNull(emptyFlightClass.getExtraPrice(), "El precio adicional debería ser nulo para el constructor vacío.");
    }

    // Test para el constructor con parámetros
    @Test
    void testAllArgsConstructor() {
        FlightClass fullFlightClass = new FlightClass(2, "Economy", 2, 50, null);
        assertEquals(2, fullFlightClass.getIdFlightClass(), "El ID de la clase debería ser 2.");
        assertEquals("Economy", fullFlightClass.getFlightClassName(), "El nombre de la clase debería ser 'Economy'.");
        assertEquals(2, fullFlightClass.getLuggageAmount(), "La cantidad de equipaje debería ser 2.");
        assertEquals(50, fullFlightClass.getExtraPrice(), "El precio adicional debería ser 50.");
    }

    // Test para el getter de extraPrice
    @Test
    void testGetExtraPrice() {
        assertEquals(100, flightClass.getExtraPrice(), "El precio adicional debería ser 100.");
    }

    // Test para los setters y getters de flightClassName, luggageAmount y extraPrice
    @Test
    void testSettersAndGetters() {
        flightClass.setFlightClassName("Economy");
        assertEquals("Economy", flightClass.getFlightClassName(), "El nombre de la clase debería ser 'Economy'.");

        flightClass.setLuggageAmount(2);
        assertEquals(2, flightClass.getLuggageAmount(), "La cantidad de equipaje debería ser 2.");

        flightClass.setExtraPrice(75);
        assertEquals(75, flightClass.getExtraPrice(), "El precio adicional debería ser 75.");
    }

    // Test para equals cuando los objetos son iguales
    @Test
    void testEquals() {
        FlightClass sameFlightClass = new FlightClass(1, "Business", 3, 100, null);
        assertTrue(flightClass.equals(sameFlightClass), "Dos clases de vuelo con el mismo ID deberían ser iguales.");
    }

    // Test para equals cuando los objetos son diferentes
    @Test
    void testNotEquals() {
        FlightClass differentFlightClass = new FlightClass(2, "Economy", 2, 50, null);
        assertFalse(flightClass.equals(differentFlightClass), "Dos clases de vuelo con diferentes IDs no deberían ser iguales.");
    }

    // Test para hashCode cuando los objetos son iguales
    @Test
    void testHashCodeEquals() {
        FlightClass sameFlightClass = new FlightClass(1, "Business", 3, 100, null);
        assertEquals(flightClass.hashCode(), sameFlightClass.hashCode(), "Los objetos con el mismo ID deberían tener el mismo hashCode.");
    }

    // Test para hashCode cuando los objetos son diferentes
    @Test
    void testHashCodeNotEquals() {
        FlightClass differentFlightClass = new FlightClass(2, "Economy", 2, 50, null);
        assertNotEquals(flightClass.hashCode(), differentFlightClass.hashCode(), "Los objetos con diferentes IDs deberían tener diferentes hashCodes.");
    }
}

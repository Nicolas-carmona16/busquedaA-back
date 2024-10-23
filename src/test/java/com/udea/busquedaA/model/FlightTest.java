package com.udea.busquedaA.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {

    private Flight flight;
    private FlightClass flightClass;

    @BeforeEach
    void setUp() {
        flightClass = new FlightClass(1, "Economy", 2, 50, null);
        flight = new Flight(1, "Medellin", "Bogota", flightClass, "FL123",
                LocalDate.of(2024, 10, 20), LocalDate.of(2024, 10, 20),
                LocalTime.of(10, 0), LocalTime.of(12, 0), 200, 250);
    }

    // Test para el constructor sin parámetros
    @Test
    void testNoArgsConstructor() {
        Flight emptyFlight = new Flight();
        assertNull(emptyFlight.getFlightClass(), "La clase del vuelo debería ser nula para el constructor sin parámetros.");
    }

    // Test para el constructor con parámetros
    @Test
    void testAllArgsConstructor() {
        assertEquals("Medellin", flight.getOrigin(), "El origen debería ser Medellin.");
        assertEquals("Bogota", flight.getDestination(), "El destino debería ser Bogota.");
        assertEquals(flightClass, flight.getFlightClass(), "La clase del vuelo debería ser Economy.");
        assertEquals(200, flight.getPrice(), "El precio debería ser 200.");
    }

    // Test para el método getDuration
    @Test
    void testGetDuration() {
        Duration expectedDuration = Duration.ofHours(2);
        assertEquals(expectedDuration, flight.getDuration(), "La duración del vuelo debería ser de 2 horas.");
    }

    // Test para el método getDurationFormat
    @Test
    void testGetDurationFormat() {
        String expectedFormat = "2 horas y 0 minutos";
        assertEquals(expectedFormat, flight.getDurationFormat(), "El formato de duración es incorrecto.");
    }

    // Test para el método getTotalPrice con un FlightClass válido
    @Test
    void testGetTotalPrice() {
        double expectedTotalPrice = 250.0;
        assertEquals(expectedTotalPrice, flight.getTotalPrice(), "El precio total debería incluir el precio base más el precio adicional de la clase.");
    }

    // Test para el método getTotalPrice cuando FlightClass es null
    @Test
    void testGetTotalPriceNoFlightClass() {
        flight.setFlightClass(null);
        double expectedTotalPrice = 200.0;
        assertEquals(expectedTotalPrice, flight.getTotalPrice(), "El precio total debería ser solo el precio base cuando no hay clase de vuelo.");
    }

    // Test para setters y getters
    @Test
    void testSettersAndGetters() {
        flight.setOrigin("Cali");
        assertEquals("Cali", flight.getOrigin(), "El origen debería haber cambiado a Cali.");

        flight.setDestination("Cartagena");
        assertEquals("Cartagena", flight.getDestination(), "El destino debería haber cambiado a Cartagena.");

        flight.setPrice(300);
        assertEquals(300, flight.getPrice(), "El precio debería haberse actualizado a 300.");
    }

    // Test para equals
    @Test
    void testEquals() {
        Flight sameFlight = new Flight(1, "Medellin", "Bogota", flightClass, "FL123",
                LocalDate.of(2024, 10, 20), LocalDate.of(2024, 10, 20),
                LocalTime.of(10, 0), LocalTime.of(12, 0), 200, 250);

        assertTrue(flight.equals(sameFlight), "Los vuelos con el mismo ID deberían ser iguales.");
    }

    // Test para equals cuando los vuelos son diferentes
    @Test
    void testNotEquals() {
        Flight differentFlight = new Flight(2, "Medellin", "Bogota", flightClass, "FL124",
                LocalDate.of(2024, 10, 21), LocalDate.of(2024, 10, 21),
                LocalTime.of(10, 0), LocalTime.of(12, 0), 200, 250);

        assertFalse(flight.equals(differentFlight), "Los vuelos con diferentes IDs no deberían ser iguales.");
    }

    // Test para hashCode
    @Test
    void testHashCode() {
        Flight sameFlight = new Flight(1, "Medellin", "Bogota", flightClass, "FL123",
                LocalDate.of(2024, 10, 20), LocalDate.of(2024, 10, 20),
                LocalTime.of(10, 0), LocalTime.of(12, 0), 200, 250);

        assertEquals(flight.hashCode(), sameFlight.hashCode(), "Los vuelos con el mismo ID deberían tener el mismo hashCode.");
    }
}

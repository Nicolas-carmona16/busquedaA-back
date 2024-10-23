package com.udea.busquedaA.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class FlightClass implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFlightClass;

    private String flightClassName;
    private Integer luggageAmount;
    private Integer extraPrice;

    public FlightClass() {
    }

    public FlightClass(Integer idFlightClass, String flightClassName, Integer luggageAmount, Integer extraPrice, List<Flight> flights) {
        this.idFlightClass = idFlightClass;
        this.flightClassName = flightClassName;
        this.luggageAmount = luggageAmount;
        this.extraPrice = extraPrice;
    }

    // Getter y Setter para flightClassName
    public String getFlightClassName() {
        return flightClassName;
    }

    public void setFlightClassName(String flightClassName) {
        this.flightClassName = flightClassName;
    }

    // Getter y Setter para luggageAmount
    public Integer getLuggageAmount() {
        return luggageAmount;
    }

    public void setLuggageAmount(Integer luggageAmount) {
        this.luggageAmount = luggageAmount;
    }

    // Getter y Setter para extraPrice
    public Integer getExtraPrice() {
        return extraPrice;
    }

    public void setExtraPrice(Integer extraPrice) {
        this.extraPrice = extraPrice;
    }


    public Integer getIdFlightClass() {
        return idFlightClass;
    }

    // equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightClass that = (FlightClass) o;
        return Objects.equals(idFlightClass, that.idFlightClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFlightClass);
    }
}

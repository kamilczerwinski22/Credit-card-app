package pl.krakow.uek.pp5.kijo.home.creditcard.model;

import pl.krakow.uek.pp5.kijo.home.creditcard.model.exceptions.CreditBelowMinimumException;

import java.math.BigDecimal;
public class CreditCard {

    private final String cardNumber; // Tworzymy zmienną do numeru karty
    private BigDecimal cardLimit; // Tworzy zmienną do limitu karty
    private String slogan; // jeszcze nie wiem po co

    public CreditCard(String cardNumber) { // konstruktor naszej klasy CreditCard
        this.cardNumber = cardNumber;
    }

    public void assignLimit(BigDecimal newLimit){ // funkcja ktora przypisze nowy limit do limitu karty
        if (BigDecimal.valueOf(100).compareTo(newLimit) == 1) { // compareTo zwraca +1 jeśli pierwsza wartość jest większa od drugiej
            throw new CreditBelowMinimumException();
        } // Na karcie nie może być mniej niż 100 monet
        cardLimit = newLimit;
    }

    public BigDecimal getLimit() { // getter limitu karty
        return cardLimit;
    }
}

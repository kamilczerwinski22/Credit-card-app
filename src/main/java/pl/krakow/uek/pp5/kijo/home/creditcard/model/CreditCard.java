package pl.krakow.uek.pp5.kijo.home.creditcard.model;

import java.math.BigDecimal;
public class CreditCard {

    private final String cardNumber; // Tworzymy zmienną do numeru karty
    private BigDecimal cardLimit; // Tworzy zmienną do

    public CreditCard(String cardNumber) { // konstruktor naszej klasy CreditCard
        this.cardNumber = cardNumber;
    }

    public void assignLimit(BigDecimal newLimit){ // funkcja ktora przypisze nowy limit do limitu karty
        cardLimit = newLimit;
    }

    public BigDecimal getLimit() { // getter limitu karty
        return cardLimit;
    }
}

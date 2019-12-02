package pl.krakow.uek.pp5.kijo.home.creditcard.model;

import pl.krakow.uek.pp5.kijo.home.creditcard.model.exceptions.CreditBelowMinimumException;
import pl.krakow.uek.pp5.kijo.home.creditcard.model.exceptions.NotEnoughtMoneyException;

import java.math.BigDecimal;
public class CreditCard {

    private final String cardNumber; // Tworzymy zmienną do numeru karty
    private BigDecimal cardLimit; // Tworzy zmienną do limitu karty
    private String slogan; // jeszcze nie wiem po co
    private BigDecimal cardBalance; // Tworzymy zmienną do balansu konta

    public CreditCard(String cardNumber) { // konstruktor naszej klasy CreditCard
        this.cardNumber = cardNumber;
    }

    public void assignLimit(BigDecimal newLimit){ // funkcja ktora przypisze nowy limit do limitu karty
        if (BigDecimal.valueOf(100).compareTo(newLimit) == 1) { // compareTo zwraca +1 jeśli pierwsza wartość jest większa od drugiej
            throw new CreditBelowMinimumException();
        } // Na karcie nie może być mniej niż 100 monet
        cardLimit = newLimit; // przypisanie zmiennej cardLimit nowej wartosci newLimit podanej jako parametr funkcji
        cardBalance = cardLimit; // przypisanie limitu karty jako balansu karty
    }

    public BigDecimal getLimit() { // getter limitu karty
        return cardLimit;
    }

    public void withdraw(BigDecimal money){ //funkcja do wypłat monety
        if (currentBalance().compareTo(money) == -1) { // compareTo zwraca -1 jeśli druga wartośc jest większa od pierwszej, czyli jeżeli ilośc monet ktora chcemy wypłac
                                                       // będzie większa niż nasz balans konta, wyrzuci błąd
            throw new NotEnoughtMoneyException();
        }
        cardBalance = cardBalance.subtract(money); // od balansu na karcie odejmujemy podaną do funkcji wartosc
    }

    public BigDecimal currentBalance(){ //funckja zwracająca obesną ilość srodkow na końcie
        return cardBalance;
    }


}

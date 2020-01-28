package pl.krakow.uek.pp5.kijo.home.creditcard.model;

import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCreditCardStorage {
    ConcurrentHashMap<String, CreditCard> cards;

    public InMemoryCreditCardStorage() {
        cards = new ConcurrentHashMap<>();
    }

    public void add(CreditCard cc) {
        cards.put(cc.getNumber(), cc);
    }

    public CreditCard load(String creditCardNumber) {
        return cards.get(creditCardNumber);
    }
}
